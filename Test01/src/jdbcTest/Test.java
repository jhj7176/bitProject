package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/xe?&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("after forName");
			conn=DriverManager.getConnection(url,"scott","tiger");
			System.out.println("Dbms connection success");
			System.out.println("DB load success");
		} catch (Exception e) {
			System.out.println("DB load fail"+e.toString());
		}

	}

}
