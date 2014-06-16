package number;

import org.apache.commons.lang.StringUtils;

public class Formate {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("199"+StringUtils.leftPad(String.valueOf(i), 8, "0"));
		}
	}

}
