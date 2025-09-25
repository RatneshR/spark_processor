package com.rr.spark_processor.processor;

import com.rr.spark_processor.config.SparkJobConfig;
import com.rr.spark_processor.schema.OrderEventSchema;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.StreamingQueryException;

import java.util.concurrent.TimeoutException;

import static org.apache.spark.sql.functions.*;

public class OrderMetricsProcessor {
    public void start() throws TimeoutException, StreamingQueryException {
        var spark = SparkJobConfig.createSession();

        var orders = spark.readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "localhost:9092")
                .option("subscribe", "orders")
                .load()
                .selectExpr("CAST(value AS STRING)");

        var parsed = orders
                .select(from_json(col("value"), OrderEventSchema.getSchema()).as("data"))
                .select("data.*");

        var revenueByProduct = parsed
                .groupBy("productId")
                .agg(sum("price").alias("totalRevenue"));

        revenueByProduct.writeStream()
                .format("console")
                .outputMode("complete")
                .option("truncate", false)
                .start()
                .awaitTermination();
    }
}
