package sort.mysort;

import java.util.List;

import sort.support.IntPrepare;


public class InsertSort {

	public static void main(String[] args) {
		 int[] intArr = IntPrepare.getArr(100);
		 sort(intArr);
	}
	
	private static void sort(int[] intArr) {
		for (int index = 1; index < intArr.length; index++) {
			int temp = intArr[index];
			int position = index;
			//shift larger values to the right
			while (position > 0 && compare(intArr[position - 1], temp) > 1) {
				intArr[position] = intArr[position - 1];
				position--;
			}
			intArr[position] = temp;
		}
	}
	
	private static int compare(int a, int b) {
		if (a > b) {
			return 1;
		} else if (a == b) {
			return 0;
		} else {
			return -1;
		}
	}

}
