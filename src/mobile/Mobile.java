package mobile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile {
	
	//+86或86开头的手机号
	private static final String regular_mobile_with_prefix = "^((\\+86)|(86)){1}(1)\\d{10}$";
	
	//11位手机号
	private static final String regular_mobile = "^(1)\\d{10}$";

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		Pattern p1 = Pattern.compile(regular_mobile_with_prefix);
		Matcher m1 = p1.matcher("18611814677");
		System.out.println(m1.matches());
		long time2 = System.currentTimeMillis();
		System.out.println("time2:" + (time2 - time1));
		
		Pattern p2 = Pattern.compile(regular_mobile);
		Matcher m2 = p2.matcher("+8618611814677");
		System.out.println(m2.matches());
		long time3 = System.currentTimeMillis();
		System.out.println("time3:" + (time3 - time2));
		
		String mobile = "+8618611814677";
		System.out.println(mobile.substring(mobile.length() - 11, mobile.length()));
	}

}
