package str;

import org.apache.commons.lang.StringUtils;

public class StrTest {

	public static void main(String[] args) {
//		String str = "李晨星123安不成";
//		System.out.println(str.substring(0, 4));
//		
//		String name = null;
//		name = StringUtils.trim(name);
		
//		String gender = "1";
//		if (gender.equals(1)) {
//			System.out.println("李晨星");
//		} else if (gender.equals("1")) {
//			System.out.println("李晨星2");
//		} else {
//			System.out.println("李晨星3");
//		}
		String st = "1,2,3,4,";
		String[] arr = StringUtils.split(st, ",");
		for (String s : arr) {
			System.out.println("str:" + s);
		}
	}

}
