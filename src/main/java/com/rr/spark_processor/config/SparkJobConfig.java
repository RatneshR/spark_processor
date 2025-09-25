package com.rr.spark_processor.config;

import org.apache.spark.sql.SparkSession;

public class SparkJobConfig {
    public static SparkSession createSession() {
        return SparkSession.builder()
                .appName("OrderMetricsProcessor")
                .master("local[*]")
                .config("spark.sql.streaming.schemaInference", "true")
                .getOrCreate();
    }
}
