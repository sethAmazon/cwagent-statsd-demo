package cw.agent.statsd;

import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;

import java.util.Arrays;

public class StatsdApplication {

    public static void main(String[] args) throws InterruptedException {
        if (args == null || args.length == 0) {
            args = new String[]{"seth,localhost,8125,statsd-metric,1000,10,10000,seth,seth"};
        }
        args = args[0].split(",");
        System.out.println("args " + Arrays.toString(args));
        String prefix = args[0];
        String hostname = args[1];
        int port = Integer.parseInt(args[2]);
        String metricName = args[3];
        long metricsPublished = Long.parseLong(args[4]);
        long initialValue = Long.parseLong(args[5]);
        int sleep = Integer.parseInt(args[6]);
        String tagName = args[7];
        String tagValue = args[8];
        StatsDClient client = new NonBlockingStatsDClientBuilder()
                .prefix(prefix)
                .hostname(hostname)
                .port(port)
                .build();
        for (int i = 0; i < metricsPublished; i++) {
            long value = initialValue * i;
            System.out.println("Sending " + metricName + " " + value);
            client.gauge(metricName, value, tagName + ":" + tagValue);
            Thread.sleep(sleep);
        }
        client.close();
    }
}
