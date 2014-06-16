package version;

public class VersionTest {
	public static void main(String[] args) {
		String version1 = "23.3.2.1-dev";
		String version2 = "24.3.2.2";
		if (check(version1, version2)) {
			System.out.println("version1:" + version1 + " version2:" + version2 + "更新");
		} else {
			System.out.println("version1:" + version1 + " version2:" + version2 + "不更新");
		}
	}
	
	public static boolean check(String version1, String version2) {
		String v1 = version1.split("-")[0];
		String v2 = version2.split("-")[0];
		String[] v1Arr = v1.split("\\.");
		String[] v2Arr = v2.split("\\.");
		for (int i = 0; i < v1Arr.length; i++) {
			if (Integer.parseInt(v2Arr[i]) > Integer.parseInt(v1Arr[i])) {
				System.out.println("v2Arr[" + i + "]:" + v2Arr[i] + "  v1Arr[" + i + "]:" + v1Arr[i]);
				return true;
			} else if (Integer.parseInt(v2Arr[i]) < Integer.parseInt(v1Arr[i])) {
				System.out.println("v2Arr[" + i + "]:" + v2Arr[i] + "  v1Arr[" + i + "]:" + v1Arr[i]);
				return false;
			}
		}
		return false;
	}
	
	public static boolean checkClientUpdate(String version1, String version2) {
		try {
			if(version1.equals(version2)) {
				System.out.println(1);
				return false;
			}
			Integer first1 = Integer.parseInt(version1.substring(0, 1));
			Integer first2 = Integer.parseInt(version2.substring(0, 1));
			if(first2 > first1) {
				System.out.println(2);
				return true;
			}
			Integer intv1 = Integer.parseInt(version1.replaceAll("\\.", "").replaceAll("\\_", "").replaceAll("\\-", ""));
			Integer intv2 = Integer.parseInt(version2.replaceAll("\\.", "").replaceAll("\\_", "").replaceAll("\\-", ""));
			if(intv2 > intv1) {
				System.out.println(3);
				return true;
			}
		} catch(Exception e) {
			System.out.println(4);
			return false;
		}
		System.out.println(5);
		return false;
	}
}
