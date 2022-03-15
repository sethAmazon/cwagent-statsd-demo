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
		for (int i = 0; i < 5; i++) {
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
					"15:2",
					"512:Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis euismod nibh id volutpat blandit. Sed quis aliquam nulla. Fusce imperdiet dui justo, sit amet blandit nunc pulvinar at. Donec mattis lorem eget eros iaculis, at posuere nisl ornare. Vestibulum sed sem lectus. Integer nec nisi ut est interdum sollicitudin eleifend at metus. Sed a consectetur sapien. Integer non tellus a lectus mollis hendrerit sed ac orci. Praesent sed diam metus. Phasellus nec leo malesuada, dictum mi sed, tincidunt nisi laoreet."
			);
			Thread.sleep(5000);
		}
		client.close();
	}

}
