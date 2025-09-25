package com.rr.spark_processor;

import com.rr.spark_processor.schema.OrderEventSchema;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderMetricsProcessorTest {

    @Test
    void testSchemaValidation() {
        var schema = OrderEventSchema.getSchema();
        assertEquals("orderId", schema.fields()[0].name());
        assertEquals("productId", schema.fields()[1].name());
        assertEquals("quantity", schema.fields()[2].name());
    }
}
