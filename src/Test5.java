import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Test5 {

	public static void main(String[] args) {
		
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0 ; i < 20; i++) {
			Object[] t1 = new Object[] {i , i + 1};
			list.add(t1);
		}
		
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(list.size());
			Object[] t = list.get(index);
			list.remove(index);
			System.out.println("index:" + index + " t:" + t[0] + " " + t[1]);
		}
		System.out.println(list.size());

	}

}
