package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileDao {
	private Connection conn;
	private java.sql.PreparedStatement pstmt;
	private ResultSet rs;
	
	public FileDao() throws ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/xe?&useSSL=false";
		String user="scott";
		String password="tiger";
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int upload(String fileName,String fileRealName) {
		String sql="insert into file values (?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
