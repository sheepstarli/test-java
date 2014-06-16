package file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

public class Test11 {
	private static String base_url = "http://localhost:8888/gamepro/fileserver/";
	public static void main(String args[]) throws Exception {
		String token = "一个有效的TOKEN";
		File src = new File("E:\\logs\\img\\IMG_0833.PNG");
		FileInputStream is = new FileInputStream(src);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int t = 256;
		byte[] buffer = new byte[t];
		while((t = is.read(buffer,0,t))!=-1){
			IOUtils.write(buffer, bos);
		}
		String addTopImage = "NO";
		String compressImage = "Y";
	
		new Test11().upload(token,bos.toByteArray(), src.getName(),"image/png", addTopImage, compressImage);
		is.close();
	}
	
	/**
	 * 获取上传地址
	 * @param addTopImage
	 * @param compressImage
	 * @return
	 */
	private String getUploadUrl(String addTopImage,String compressImage){
		String service = "/put?userid=333&type=title&compressImage=N&addTopImage=N";
		service = service.replaceAll("#compressImage#", compressImage);
		service = service.replaceAll("#addTopImage#", addTopImage);
		String url = base_url+service;
		return url;
	}
	/**
	 * 根据图片ID获取图片URL
	 * @param id
	 * @return
	 */
	public String getFileAsUrl(String id) throws Exception {
		if(null != id){
			String fileUrl = base_url+"/get/"+id;
			return fileUrl;
		}else{
			throw new NullPointerException("根据图片ID获取图片URL,图片ID不能为空");
		}
	}
	/**
	 * 上传到图片服务器，返回图片ID
	 * @param token 一个有效的TOKEN
	 * @param bos 字节数组输出流
	 * @param fileName 文件名
	 * @param contentType 请求类型
	 * @param addTopImage OK 加水印，NO 不加水印
	 * @param compressImage OK 压缩，NO 不压缩
	 * @return
	 * @throws Exception
	 */
	public String upload(String token,byte[] obj,String fileName,String contentType,String addTopImage,String compressImage) throws Exception{
		PostMethod post = new PostMethod(getUploadUrl(addTopImage,compressImage));
		try {
			PartSource part = new ByteArrayPartSource(fileName,obj);
			FilePart filePart = new FilePart("file",part);
			filePart.setContentType(contentType);
			post.addRequestHeader("token", token);
			HttpMethodParams httpMethodParams = new HttpMethodParams();
			post.setRequestEntity( new MultipartRequestEntity( new Part[]{filePart} , httpMethodParams ) );
			HttpClient client = new HttpClient();
			int status = client.executeMethod(post);
			String res = post.getResponseBodyAsString();
			return res;
		} catch (Exception e) {
			throw e;
		} finally {
			post.releaseConnection();
		}
	}

}