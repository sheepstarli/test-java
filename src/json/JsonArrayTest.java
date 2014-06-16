package json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonArrayTest {

	public static void main(String[] args) {
		String json = "{\"value\":[{\"id\":1,\"name\":\"lcx1\"},{\"id\":2,\"name\":\"lcx2\"}]}";
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = new JSONArray(jsonObject.getString("value"));
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				System.out.println("id:" + object.getInt("id") + "  name:" + object.getString("name"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
