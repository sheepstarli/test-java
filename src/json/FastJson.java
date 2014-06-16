package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class FastJson {

	public static void main(String[] args) {
		ClientRequest clientRequest = new ClientRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> contactsList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> contacts = new LinkedHashMap<String, String>();
			contacts.put("name", "lichenxing" + i);
			contactsList.add(contacts);
		}
		map.put("contacts", contactsList);
		clientRequest.setParams(map);
		System.out.println(JSON.toJSONString(clientRequest, true));

	}

}
