package kr.co.greenart;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

// 특정 시기에 이벤트를 발생 시키기!
public class MyContextListener implements ServletContextListener{
	private static DataSource dataSource;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션 시작시 이벤트가 발생합니다.");
		
		// 웹 어플리케이션 첫 구동 시 필요한 설정을 할 수 있음.
		ServletContext context = sce.getServletContext();
		
		String driver = context.getInitParameter("driver");
		String dburl = context.getInitParameter("dburl");
		String dbid = context.getInitParameter("dbid");
		String dbpw = context.getInitParameter("dbpw");
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(dburl);
		ds.setUsername(dbid);
		ds.setPassword(dbpw);
		
		dataSource = ds;
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
				
	}
	
	// low 언어 c
	// high 언어 java, python
	// 어플리케이션 구현 1단계
	// 메모리 영역 2단계, db영역
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
//		return DriverManager.getConnection(dburl, dbid, dbpw);
	}
}	
