package conllection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {	
		List<String> list = new ArrayList<String>();
		list.add("lcx");
		list.add("lcx");
		list.add("lcx2");
		list.add("lcx2");
		list.add("lcx3");
		Set<String> set = new HashSet<String>(list);
		set.add("lcx4");
		set.add("lcx");
		for (String str : set) {
			System.out.println(str);
		}
	}

}
