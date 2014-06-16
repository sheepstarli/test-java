package json;

import java.util.Date;
import java.util.HashMap;

public class ClientRequest {
	
	private String sn;
	
	private String token;
	
	private String method;
	
	private String mac;
	
	private String imei;
	
	private String channel;
	
	private String version;
	
	private boolean isEncrypt;
	
	private boolean isCompression;
	
	private HashMap<String, Object> params;

	public String getSn() {
		return sn;
	}
	
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getMac() {
		return mac;
	}
	
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getImei() {
		return imei;
	}
	
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	public HashMap<String, Object> getParams() {
		return params;
	}
	
	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}
	
	public boolean isEncrypt() {
		return isEncrypt;
	}

	public void setEncrypt(boolean isEncrypt) {
		this.isEncrypt = isEncrypt;
	}

	public boolean isCompression() {
		return isCompression;
	}

	public void setCompression(boolean isCompression) {
		this.isCompression = isCompression;
	}
	
	public boolean containsKey(String key) {
		return null != params && params.containsKey(key);
	}
	
	public String getParameter(String key) {
		if(null != params && null != params.get(key)) {
			return String.valueOf(params.get(key));
		}
		return null;
	}
	
	public Object getObjectParameter(String key) {
		return params.get(key);
	}
	
	public int getIntParameter(String key) {
		return Integer.parseInt(getParameter(key));
	}
	
	public long getLongParameter(String key) {
		return Long.parseLong(getParameter(key));
	}
	
	public double getDoubleParameter(String key) {
		return Double.parseDouble(getParameter(key));
	}
	
	public Date getDateParameter(String key) {
		return new Date(getLongParameter(key));
	}

}
