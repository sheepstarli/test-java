package concurrent.BlockingQueue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> drop = new ArrayBlockingQueue<String>(1, true);
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
	}

}

class Producer implements Runnable {
	
	private BlockingQueue<String> drop;
	
	List<String> messages = Arrays.asList(
	        "Mares eat oats",
	        "Does eat oats",
	        "Little lambs eat ivy",
	        "Wouldn't you eat ivy too?");
	
	public Producer(BlockingQueue<String> d) {
		this.drop = d;
	}
	
	@Override
	public void run() {
		try
        {
            for (String s : messages) {
            	drop.put(s);
            }
            drop.put("DONE");
        }
        catch (InterruptedException intEx)
        {
            System.err.println("Interrupted! " + 
                "Last one out, turn out the lights!");
        }
	}
}

class Consumer implements Runnable {
	
	private BlockingQueue<String> drop;
	
	public Consumer(BlockingQueue<String> d) {
		this.drop = d;
	}

	@Override
	public void run() {
		try
        {
			
            String msg = null;
            while (!((msg = drop.take()).equals("DONE")))
                System.out.println(msg);
        }
        catch (InterruptedException intEx)
        {
            System.out.println("Interrupted! " + 
                "Last one out, turn out the lights!");
        }
	}
}
