package baidu;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class BaiduMapTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://221.122.66.243:3306/gamepro?user=root&password=";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn= DriverManager.getConnection(url);
			File file = new File("C:\\Users\\LiChenxing\\Desktop\\BaiduMap_cityCenter.txt");
			if (file.exists() == false) {
				System.out.println("文件不存在");
			}
			List<String> lines = IOUtils.readLines(new FileInputStream(file));
			StringBuilder jsonBuilder = new StringBuilder();
			for (String line : lines) {
				jsonBuilder.append(line);
			}
			JSONObject jsonObj = new JSONObject(jsonBuilder.toString());
			JSONArray municipalitiesJsonArr = jsonObj.getJSONArray("municipalities");
			JSONArray provincesJsonArr = jsonObj.getJSONArray("provinces");
			Integer municipalitiesLength = municipalitiesJsonArr.length();
			for (int i = 0; i < municipalitiesLength; i++) {
				String type = "municipalities";
				JSONObject municipalitiesJsonObj = municipalitiesJsonArr.getJSONObject(i);
				String city = municipalitiesJsonObj.getString("n");
				String temp = municipalitiesJsonObj.getString("g");
				String [] tempArr = temp.split("\\|");
				String [] location = tempArr[0].split(",");
				System.out.println(city + " " + location[0] + " " + location[1]);
				try {
					pstmt = conn.prepareStatement("update citycode set longitude = ?, latitude = ?, type = ? where city = ?");
					pstmt.setDouble(1, Double.valueOf(location[0]));
					pstmt.setDouble(2, Double.valueOf(location[1]));
					pstmt.setString(3, type);
					pstmt.setString(4, city);
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {  
					    if(pstmt != null) {  
					        pstmt.close();  
					        pstmt = null;  
					    }  
					//捕获SQL异常  
					} catch (SQLException e) {  
					    e.printStackTrace();  
					}  
				}
			}
			for (int i = 0; i < provincesJsonArr.length(); i++) {
				JSONObject provinceJsonObj = provincesJsonArr.getJSONObject(i);
				String type = "province";
				String city = provinceJsonObj.getString("n");
				String temp = provinceJsonObj.getString("g");
				String [] tempArr = temp.split("\\|");
				String [] location = tempArr[0].split(",");
				System.out.println(city + " " + location[0] + " " + location[1]);
				try {
					pstmt = conn.prepareStatement("update citycode set longitude = ?, latitude = ?, type = ? where city = ?");
					pstmt.setDouble(1, Double.valueOf(location[0]));
					pstmt.setDouble(2, Double.valueOf(location[1]));
					pstmt.setString(3, type);
					pstmt.setString(4, city);
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {  
					    if(pstmt != null) {  
					        pstmt.close();  
					        pstmt = null;  
					    }  
					//捕获SQL异常  
					} catch (SQLException e) {  
					    e.printStackTrace();  
					}  
				}
				
				
				
				
				JSONArray citiesArr = provinceJsonObj.getJSONArray("cities");
				for (int t = 0; t <citiesArr.length(); t++) {
					JSONObject cityJsonObj = citiesArr.getJSONObject(t);
					String _type = "city";
					String _city = cityJsonObj.getString("n");
					String _temp = cityJsonObj.getString("g");
					String [] _tempArr = _temp.split("\\|");
					String [] _location = _tempArr[0].split(",");
					System.out.println(_city + " " + _location[0] + " " + _location[1]);
					try {
						pstmt = conn.prepareStatement("update citycode set longitude = ?, latitude = ?, type = ? where city = ?");
						pstmt.setDouble(1, Double.valueOf(_location[0]));
						pstmt.setDouble(2, Double.valueOf(_location[1]));
						pstmt.setString(3, _type);
						pstmt.setString(4, _city);
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {  
						    if(pstmt != null) {  
						        pstmt.close();  
						        pstmt = null;  
						    }  
						//捕获SQL异常  
						} catch (SQLException e) {  
						    e.printStackTrace();  
						}  
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {  
				if(conn != null) {  
                    conn.close();  
                    conn = null;  
                }  
			//捕获SQL异常  
			} catch (SQLException e) {  
			    e.printStackTrace();  
			}  
		}
	}

}
