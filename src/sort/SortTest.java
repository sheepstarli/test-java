package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(22D);
		doubleList.add(12D);
		doubleList.add(30D);
		doubleList.add(Math.abs(-10D));
		sortList(doubleList);
		for (Double db : doubleList) {
			System.out.println(db);
		}
	}
	
	public static void sortList(List<Double> doubleList) {
		Collections.sort(doubleList, new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return o1.compareTo(o2);
			}
		});
	}

}
