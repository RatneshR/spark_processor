package com.rr.spark_processor.schema;

import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.types.DataTypes;

public class OrderEventSchema {
    public static StructType getSchema() {
        return new StructType()
                .add("orderId", DataTypes.StringType)
                .add("productId", DataTypes.StringType)
                .add("quantity", DataTypes.IntegerType)
                .add("price", DataTypes.DoubleType)
                .add("timeStamp", DataTypes.TimestampType);
    }

}
