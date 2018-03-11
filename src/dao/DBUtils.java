package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection MyConnection() {
		String url = "jdbc:mysql://localhost:3306/imsdb";
		String user = "root";
		String pass = "Sujan-123";
//		String driver = "com.mysql.jdbc.Driver";
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
		
	}

}
