package http;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

public class HttpUtil {
	
	private static Logger logger = new Logger();
	
	public static final String POST = "POST";
	
	public static final String GET = "GET";
	
	public static final String UTF8 = "UTF-8";
	
	public static final String GBK = "GBK";
	
	public static final String GB2312 = "GB2312";
	
	private static class Logger {
		public void error(String msg, Exception e) {
			System.out.println("ERROR:" + msg);
		}
		public void info(String msg) {
			System.out.println("INFO:" + msg);
		}
	}
	
	public static InputStream downfile(String url) {
		ByteArrayOutputStream out = null;
		InputStream in = null;
		try {
			URL postUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) postUrl
					.openConnection();
			conn.setRequestProperty("User-Agent", "Internet Explorer"); 
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			in = conn.getInputStream();
			out = new ByteArrayOutputStream();
			byte[] buf = new byte[in.available()];
			int n = -1;
			while((n = in.read(buf)) != -1) {
				out.write(buf, 0, n);
			}
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			logger.error("下载文件出错,,url:" + url, e);
		} finally {
			close(in);
			close(out);
		}
		return null;
	}

	public static File downfile(String dir, String filename, String url) {
		OutputStream out = null;
		InputStream in = null;
		try {
			URL postUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) postUrl
					.openConnection();
			conn.setRequestProperty("User-Agent", "Internet Explorer"); 
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			in = conn.getInputStream();
			out = new FileOutputStream(new File(dir, filename));
			byte[] buf = new byte[in.available()];
			int n = -1;
			while((n = in.read(buf)) != -1) {
				out.write(buf, 0, n);
			}
			out.flush();
			return new File(dir, filename);
		} catch (Exception e) {
			logger.error("下载文件出错, filename:" + filename + ",url:" + url, e);
		} finally {
			close(in);
			close(out);
		}
		return null;
	}
	
	private static void close(InputStream in) {
		if(null != in) {
			try {
				in.close();
			} catch(Exception e) {
			} 
		}
	}
	
	private static void close(OutputStream out) {
		if(null != out) {
			try {
				out.close();
			} catch(Exception e) {
				
			}
		}
	}
	
	public static HttpResult getResponse(String url, String body) {
		return getResponse(url, POST, UTF8, body, 30000);
	}
	
	public static HttpResult getResponse(String url, String body, int timeout) {
		return getResponse(url, POST, UTF8, body, timeout);
	}
	
	public static HttpResult getResponse(String url, String method, String encoding, String body) {
		return getResponse(url, method, encoding, body, 30000);
	}
	
	public static HttpResult getResponse(String url, String method, String encoding, String body, int timeout) {
		OutputStream out = null;
		InputStream in = null;
		try {
			URL postUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) postUrl
					.openConnection();
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			if(!GET.equals(method)) {
				conn.setDoOutput(true);
			}
			conn.setDoInput(true);
			conn.setRequestMethod(method);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setConnectTimeout(timeout);
			conn.setReadTimeout(timeout);
			conn.connect();
			if(!GET.equals(method)) {
				if(!StringUtil.isEmpty(body)) {
					out = conn.getOutputStream();
					out.write(body.getBytes());
					out.flush();
				}
			}
			HttpResult httpResult = new HttpResult();
			httpResult.setResponseCode(conn.getResponseCode());
			httpResult.setResponseMessage(conn.getResponseMessage());
			if(HttpURLConnection.HTTP_OK == httpResult.getResponseCode()) {
				in = conn.getInputStream();
				String result = read(in, encoding);
				httpResult.setResult(result);
			} else {
				in = conn.getErrorStream();
				String result = read(in, encoding);
			}
			return httpResult;
		} catch (MalformedURLException e) {
			logger.error("请求地址有误, url:" + url, e);
		} catch (Exception e) {
			logger.error("IO错误,url:" + url + ",body:" + body, e);
		} finally {
			close(in);
			close(out);
		}
		return null;
	}
	
	public static String encode(Map<String, Object> params) {
		StringBuilder builder = new StringBuilder();
		for (String key : params.keySet()) {
			String value = ObjectUtils.toString(params.get(key));
			if (StringUtils.isBlank(key)) {
				continue;
			}
			builder.append(key);
			builder.append("=");
			try {
				builder.append(URLEncoder.encode(value, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				logger.error("URLEncorder出错", e);
			}
			builder.append("&");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}
	
	public static String read(InputStream in, String encoding) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, encoding));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while(null != (line = reader.readLine())) {
				builder.append(line);
			}
			return builder.toString();
		} catch(Exception e) {
			logger.error("错误", e);
		} finally {
			close(in);
		}
		return null;
	}
}
