package http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientTest {

	public static void main(String[] args) {
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new PostMethod("http://58.83.193.119/gamepro/dailyNews/createDailyNews");
		method.setRequestHeader("Content-Type",	"application/x-www-form-urlencoded");
		HttpMethodParams hmp = new HttpMethodParams();
		hmp.setParameter("userid", "10000203");
		hmp.setParameter("editorNote", "明天凌晨例行维护后，SoO将开启跨服组队功能，服务器首杀必须满足80的团员来自同一公会，才可以获得首杀刷屏。");
		hmp.setParameter("img", "47887");
		hmp.setParameter("imgQuote", "图/剁手祭旗");
		hmp.setParameter("title", "跨服SoO：80以上同公会才有首杀刷屏");
		hmp.setParameter("content", "在明天凌晨的服务器例行维护后，决战奥格瑞玛普通和英雄难度将开启跨服组队功能——你将可以邀请其它服务器上的战网昵称和实名好友一起挑战普通和英雄难度的加尔鲁什。");
		hmp.setParameter("messageId", 4472);
		method.setParams(hmp);
		try {
			httpClient.executeMethod(method);
			System.out.println(method.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
