package http;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	
	public static String recommendUrl = "http://221.122.66.243/momotalk-recommend";

	public static void main(String[] args) {
		
		String url = recommendUrl +"/wow/getSameGuildNotRecommend";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", "10110707");
		params.put("realm", "石爪峰");
		params.put("guild", "黎明之翼");
		params.put("pageIndex", 0);
		params.put("maxSize", 1000);
		String paramsStr = HttpUtil.encode(params);
		HttpResult httpResult = HttpUtil.getResponse(recommendUrl, HttpUtil.POST, HttpUtil.UTF8, paramsStr);
		System.out.println(httpResult.getResult());
	}

}
