package kr.co.greenart.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private final static Properties properties = new Properties();
	
	static {
		InputStream inStream = null;
		
		try {
			// 프로퍼티 파일 읽어서(인풋스트림) 객체화
			inStream = DBUtil.class
					.getResourceAsStream("mysql.properties");
			properties.load(inStream);
			
			String driverClass = properties.getProperty("JDBC_DRIVER_CLASS");
			
			// 드라이버 로드(적재)
			Class.forName(driverClass);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = properties.getProperty("JDBC_URL");
		String id = properties.getProperty("JDBC_USERNAME");
		String password = properties.getProperty("JDBC_PASSWORD");
		
		return DriverManager.getConnection(url, id, password);
	}
	
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStmt(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeRS(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
















