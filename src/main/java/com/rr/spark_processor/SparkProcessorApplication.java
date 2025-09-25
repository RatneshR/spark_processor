package com.rr.spark_processor;

import com.rr.spark_processor.processor.OrderMetricsProcessor;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class SparkProcessorApplication {

	public static void main(String[] args) throws TimeoutException, StreamingQueryException {
		new OrderMetricsProcessor().start();
//		SpringApplication.run(SparkProcessorApplication.class, args);
	}

}
