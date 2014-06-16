package array;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<String>();
		strList.add("lcx");
		strList.add(null);
		strList.add("lichenxing");
		List<String> newArr = new ArrayList<String>();
		strList.addAll(newArr);
		
		for (String str : strList) {
			System.out.println(str);
		}
	}

}
