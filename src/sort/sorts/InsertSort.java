package sort.sorts;

public class InsertSort {
	public static void sort(int[] data) {
		for (int i = 1; i < data.length; i++ ) {
			int temp = data[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp < data[j]) {
					data[j + 1] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}
