package sort.sorts;

public class ShellSort {
	
	public static void sort(int[] data) {
		
		int gap = data.length;
		
		while (gap > 1) {
			gap = gap / 2;
			for (int i = 0; i < gap; i++) {
				insertSort(data, i, gap);
			}
		}
		
	}
	
	private static void insertSort(int[] data, int start, int inc) {
		for (int i = start + inc; i < data.length; i += inc) {
			int temp = data[i];
			for (int j = i - inc; j >= 0; j -= inc) {
				if (temp < data[j]) {
					data[j + inc] = data[j];
					data[j] = temp;
				}
			}
		}
	}

}
