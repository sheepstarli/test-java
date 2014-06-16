package pinyin;

import org.apache.commons.lang.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public class PinyinUtil {
	
	public static void main(String[] args) throws Exception {
		System.out.println(getFirstABC(")a"));
	}
	
	public static String getFirstABC(String str) throws Exception {
		String pinyin = getPinyin(str);
		if(StringUtils.isNotBlank(pinyin)) {
			return pinyin.substring(0, 1);
		}
		return pinyin;
	}

	public static String getPinyin(String str) throws Exception {
		if (StringUtils.isNotBlank(str)) {
			char[] chars = str.toCharArray();
			HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
			format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
			format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			format.setVCharType(HanyuPinyinVCharType.WITH_V);
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {   
                    builder.append(c);
                    continue;
                }
				try {
					builder.append(PinyinHelper.toHanyuPinyinStringArray(c,
							format)[0]);
				} catch (Exception e) {
					throw e;
				}
			}
			return builder.toString();
		}
		return str;
	}
}
