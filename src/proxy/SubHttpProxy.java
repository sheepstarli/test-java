package proxy;

import java.io.*;
import java.net.*;

public class SubHttpProxy extends HttpProxy {
    static private boolean first=true;
    public SubHttpProxy(Socket s) {
	super(s);
    }
    public void writeLog(int c, boolean browser) throws IOException {
	if (first) log.write('*');
	first=false;
	log.write(c);
	if (c=='\n') log.write('*');
    }
    public String processHostName(String url, String host, int port, Socket sock) {
	// 直接返回
	return host;
    }
    // 测试用的简单main方法
    static public void main(String args[]) {
	System.out.println("在端口9999启动代理服务器\n");
	HttpProxy.log=System.out;
	HttpProxy.logging=true;
	HttpProxy.startProxy(9999,SubHttpProxy.class);
      }


}
