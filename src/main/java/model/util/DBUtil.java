package main.java.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static final String loc = "C:\\Users\\hyundoo\\NS_BE\\src\\main\\resources\\application_db.properties";
	private static Properties dbinfo = new Properties();

	static {
		try {
			dbinfo.load(new FileInputStream(loc));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Connection 객체 반환하는 static 메소드 구현
	public static Connection getConnection() throws SQLException {
		String url = dbinfo.getProperty("db.mysql.url");
		String username = dbinfo.getProperty("db.mysql.username");
		String password = dbinfo.getProperty("db.mysql.password");
		return DriverManager.getConnection(url, username, password);
	}

	// DML용 자원 반환
	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {

		}
	}

	// DML용 자원 반환
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {

		}
	}
}
