package sort.support;

import org.apache.commons.lang.math.RandomUtils;

public class IntPrepare {
	public static int[] getArr(int maxSize) {
		int[] intArr = new int[maxSize];
		for (int i = 0; i < maxSize; i++) {
			int nextInt = RandomUtils.nextInt(maxSize * 10);
			if (checkExists(intArr, nextInt)) {
				i--;
			} else {
				intArr[i] = nextInt;
			}
		}
		return intArr;
	}
	
	private static boolean checkExists(int[] intArr, int newNum) {
		for (int num : intArr) {
			if (num == newNum) {
				return true;
			}
		}
		return false;
	}
}
