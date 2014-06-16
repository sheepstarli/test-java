
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "body=%7B%22sn%22%3A%22c843ee4e-e675-42fe-a16b-036c490810ba%22%2C%22token%22%3A%22A0770FE8B8F547E5BA8141ECD58C56B2%22%2C%22encrypt%22%3A%22false%22%2C%22imei%22%3A%22a0000037c59bca%22%2C%22mac%22%3A%22f0%3A84%3Ac9%3Add%3Afd%3Af9%22%2C%22method%22%3A%22111%22%2C%22params%22%3A%7B%22longitude%22%3A%22116.306939%22%2C%22latitude%22%3A%2239.981278%22%2C%22shiptype%22%3A%221%22%2C%22maxSize%22%3A%22%22%2C%22pageIndex%22%3A%22%22%2C%22sorttype%22%3A%221%22%7D%2C%22compression%22%3A%22false%22%2C%22channel%22%3A%2214%22%2C%22version%22%3A%221.0.2.16%22%7D";
//		String string = URLDecoder.decode(s, "UTF-8");
//		System.out.println(string);
		
//		String str = "param1=lcx&param2=李晨星&param3=lcx+&param4=李晨星+";
//		String strEncoded = "body=%7B%22sn%22%3A%22b4788839-42a3-4e14-a791-7acd43d86411%22%2C%22token%22%3A%2252A5C7B742414DB2A83AE27EC74E56BC%22%2C%22encrypt%22%3A%22false%22%2C%22imei%22%3A%22a0000037c59bca%22%2C%22mac%22%3A%22f0%3A84%3Ac9%3Add%3Afd%3Af9%22%2C%22method%22%3A%22146%22%2C%22params%22%3A%7B%22characterid%22%3A%22141159%22%2C%22gameid%22%3A%221%22%7D%2C%22compression%22%3A%22false%22%2C%22channel%22%3A%2214%22%2C%22version%22%3A%221.0.2.3%22%7D";
//		String strDecode = URLDecoder.decode(strEncoded, "UTF-8");
//		System.out.println(strDecode);
		
		String str1 = "=";
		System.out.println(URLEncoder.encode(str1, "UTF-8"));
	}
	
}
