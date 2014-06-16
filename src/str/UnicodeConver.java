package str;

import java.io.UnsupportedEncodingException;

public class UnicodeConver {

	public static void main(String[] args) {
		String str = "\u672a\u67e5\u8be2\u5230\u76f8\u5173\u6570\u636e\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002";
		try {
			byte[] utf8ByteArr = str.getBytes("utf-8");
			System.out.print(utf8ByteArr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
