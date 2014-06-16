import java.util.ArrayList;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("1000020" + String.valueOf(i));
		}
		Object str = "10000209";
		if (list.contains(str)) {
			System.out.println("存在");
		} else {
			System.out.println("不存在");
		}
	}

}
