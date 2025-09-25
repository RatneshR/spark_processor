#!/bin/bash
# A script to run a Spark job with specified parameters
# Usage: ./run-spark.sh <master-url> <app-jar> <main-class> [<app-args>...]

mvn clean compile exec:java -Dexec.mainClass="com.rr.spark_processor.SparkProcessorApplication"