package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServicesTest {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		Runnable pinger = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("PING!");
			}
		};
		ses.scheduleAtFixedRate(pinger, 2, 2, TimeUnit.SECONDS);
	}

}
