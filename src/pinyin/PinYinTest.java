package pinyin;

public class PinYinTest {

	public static void main(String[] args) {
		try {
			String py = PinyinUtil.getPinyin("李晨星");
			String firstABC = PinyinUtil.getFirstABC("李晨星");
			System.out.println(py);
			System.out.println(firstABC);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
