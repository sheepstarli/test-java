package sort.sorts;

public class BubbleSort {
	public static void sort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				int temp;
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
	}
}
