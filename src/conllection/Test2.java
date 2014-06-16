package conllection;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("lcx");
		list.add("lcx");
		list.add("lcx2");
		list.add("lcx3");
		
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("#########################");
		
		list.remove("lcx4");
		for (String str : list) {
			System.out.println(str);
		}
		
				

	}

}
