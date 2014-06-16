package sort.sorts;

public class SelectionSort {
	
	public static void sort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[index]) {
					index = j;
				}
			}
			int temp = data[index];
			data[index] = data[i];
			data[i] = temp;
		}
	}

}
