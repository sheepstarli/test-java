package file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

public class UploadRemoteTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:\\image\\test_3.jpg");
//		InputStream in = new FileInputStream(file);
//		String id = uploadRemote(in, file.getName(), "image/jpeg");
		String id = uploadRemote(file, file.getName(), "image/jpeg");
		System.out.println(id);
	}
	
	public static String uploadRemote(InputStream is, String fileName,String contentType) throws Exception{
		String uploadUrl = "http://114.215.109.110/upload";
		PostMethod post = new PostMethod(uploadUrl);
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int t = 256;
			byte[] buffer = new byte[t];
			while((t = is.read(buffer,0,t))!=-1){
				IOUtils.write(buffer, bos);
			}
			PartSource part = new ByteArrayPartSource(fileName,bos.toByteArray());
			FilePart filePart = new FilePart("userfile", part);
			filePart.setContentType(contentType);
			HttpMethodParams httpMethodParams = new HttpMethodParams();
			post.setRequestEntity( new MultipartRequestEntity( new Part[]{filePart} , httpMethodParams ) );
			HttpClient client = new HttpClient();
			client.executeMethod(post);
			String res = post.getResponseBodyAsString();
			return res;
		} catch (Exception e) {
			System.err.println("上传出错");
			throw e;
		} finally {
			post.releaseConnection();
		}
	}
	
	public static String uploadRemote(File file, String fileName,String contentType) throws Exception{
		String uploadUrl = "http://114.215.109.110/upload";
		PostMethod post = new PostMethod(uploadUrl);
		try {
			FilePart filePart = new FilePart("userfile", file);
			filePart.setContentType(contentType);
			filePart.setTransferEncoding(null);
			HttpMethodParams httpMethodParams = new HttpMethodParams();
			post.setRequestEntity( new MultipartRequestEntity( new Part[]{filePart} , httpMethodParams ) );
			HttpClient client = new HttpClient();
			client.executeMethod(post);
			String res = post.getResponseBodyAsString();
			return res;
		} catch (Exception e) {
			System.err.println("上传出错");
			throw e;
		} finally {
			post.releaseConnection();
		}
	}

}
