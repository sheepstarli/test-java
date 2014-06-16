package thread;

public class ThreadTest {

	public static void main(String[] args) {
		
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		MyTheadTest t1 = new MyTheadTest("A", c, a);
		MyTheadTest t2 = new MyTheadTest("B", a, b);
		MyTheadTest t3 = new MyTheadTest("C", b, c);
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

	}
	
	public static class MyTheadTest implements Runnable {
		
		private String name;
		private Object pre;
		private Object self;
		
		public MyTheadTest(String name, Object pre, Object self) {
			this.name = name;
			this.pre = pre;
			this.self = self;
		}
		@Override
		public void run() {
			
			for (int i = 1; i <= 5; i++) {
				synchronized (pre) {
					System.out.println(name + "获取pre");
					synchronized (self) {
						System.out.println(name + "获取self");
						System.out.println(name + "_" + i);
						try {
							self.wait();
							System.out.println(name + "释放self");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	}


}
