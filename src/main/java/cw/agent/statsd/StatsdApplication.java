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
			client.gauge("seth-statd-metric", 101 * i,
					"Seth0:Seth0",
					"S1:S1",
					"2:2",
					"3:2",
					"4:2",
					"5:2",
					"6:2",
					"7:2",
					"8:2",
					"9:2",
					"10:2",
					"11:2",
					"12:2",
					"13:2",
					"14:2",
					"15:2"
			);
		}
		Thread.sleep(5000);
		client.close();
	}

}
