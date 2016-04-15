package concurrent;

import java.util.concurrent.CountDownLatch;

import http.HttpResult;
import http.HttpUtil;

public class ConcurrentTesting {
	
	private static CountDownLatch start = new CountDownLatch(1);

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						start.await();
						HttpResult httpResult = HttpUtil.getResponse("http://221.122.66.243/gamepro/group/getNext", null);
						System.out.println("时间：" + System.currentTimeMillis() + " 返回码：" + httpResult.getResponseCode() + "  返回信息：" + httpResult.getResult());
					} catch (InterruptedException intEx) {
						intEx.printStackTrace();
					}
				}
			}).start();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("开始请求！！！！");
		start.countDown();

	}
}
