import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class StringTest {

	public static void main(String[] args) {
		String characterUrl = "http://www.battlenet.com.cn/wow/zh/character/石爪峰/限量版丶小六/simple";
		try {
			characterUrl = URLDecoder.decode(characterUrl, "UTF-8");
			System.out.println(characterUrl);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Integer index = characterUrl.lastIndexOf("character/");
		String reaml_character = characterUrl.substring(index + "character/".length(), characterUrl.length());
		String [] split = reaml_character.split("/");
		if (split != null && split.length >= 2) {
			System.out.println(split[0]);
			System.out.println(split[1]);
		}
	}

}
