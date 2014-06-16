package concurrent;

import java.util.concurrent.TimeUnit;

public class TimeunitTest {

	public static void main(String[] args) {
		long duration = 2 * 60 * 60 * 1000;
		long hour = TimeUnit.MILLISECONDS.toHours(duration);
		System.out.println(hour);
	}

}
