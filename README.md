Sample APP To Send Statsd Metrics

Sample run command

arg order
1. prefix
2. hostname
3. port
4. metricName
5. metricsPublished
6. initialValue
7. sleep in milliseconds
8. tag name
9. tag value

./gradlew bootRun --args=statsd,localhost,8125,statd-metric,180,111,20000,tagName,tagValue