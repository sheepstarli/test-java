package sort.sorts;

public class SortTest {

	public static void main(String[] args) {
		
		int[] data1 = {2,88,22,44,45,90,100,12};
		show(data1);
		BubbleSort.sort(data1);
		show(data1);
		
		int[] data2 = {2,88,22,44,45,90,100,12};
		show(data2);
		SelectionSort.sort(data2);
		show(data2);
		
		int[] data3 = {2,88,22,44,45,90,100,12,11};
		show(data3);
		InsertSort.sort(data3);
		show(data3);
		
		int[] data4 = {2,88,22,44,45,90,100,12,11};
		show(data4);
		ShellSort.sort(data4);
		show(data4);

	}
	
	public static void show(int[] data) {
		System.out.print("数组：");
		for (int num : data) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
