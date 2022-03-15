package cw.agent.statsd;

import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;

public class StatsdApplication {

	public static void main(String[] args) throws InterruptedException {
		StatsDClient client = new NonBlockingStatsDClientBuilder()
				.prefix("statsd")
				.hostname("localhost")
				.port(8125)
				.build();
		for (int i = 0; i < 10; i++) {
			System.out.println("Sending seth-statd-metric");
			client.gauge("seth-statd-metric", 101 * i, "Seth0:Seth0");
			Thread.sleep(60000);
		}
		client.close();
	}

}
