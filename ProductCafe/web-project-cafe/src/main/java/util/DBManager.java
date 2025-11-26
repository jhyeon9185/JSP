package util;

import java.sql.*;

public class DBManager {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/edudb?serverTimezone=Asia/Seoul",
					"jdbctest",
					"1234"
					); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
