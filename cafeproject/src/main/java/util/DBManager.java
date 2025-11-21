package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			 
			
		}
	}  

	public static void close(Connection con, Statement stmt) {
		try {
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
