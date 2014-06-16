package apn;

import java.util.Date;
import java.util.Map;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class Main {

	public static void main(String[] args) {
		try {
			ApnsService service = APNS.newService().withCert("D:\\apnCert\\game_91.p12", "syp123456").withSandboxDestination().build();
			String payload = APNS.newPayload().alertBody("李晨星测试 声音为null " + new Date()).sound(null).customField("userid", "10000121").customField("type", "91").build();
//			String token = "ef52debc3144b492c6518c9d2793193777686f382b53a9f883035c740616cbb2";
//			String token = "c5f808ed 2f45fc34 1a2b7d98 0af095ae 646f0442 0f4b69b1 83b87f31 38e2c080";
//			String token = "95bf9776 3edf2fe4 be617f71 fe8ecff8 c9d6e047 eecb436b 91e7cd71 1c5d197f";
			String token = "4313d3d0 d65df128 2f9c2573 3004c59e 555af008 732354da 6014e590 2c53709d";
			token = token.replace(" ", "");
			System.out.println(payload);
			service.push(token, payload);
			Map<String, Date> inactiveDevices = service.getInactiveDevices();
			for (String deviceToken : inactiveDevices.keySet()) {
			    Date inactiveAsOf = inactiveDevices.get(deviceToken);
			    System.out.println(inactiveAsOf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
