<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가 목록</title>
</head>
<body>
<!-- 
	웹 어플리케이션은 라이브러리를 지정해주는 폴더가 있다.
	===> WEB-INF/lib 폴더;
 -->

 <ul>
 <%
 	Class.forName("com.mysql.cj.jdbc.Driver");
 	Connection conn = null;
 	Statement stmt = null;
 	ResultSet rs = null;
 	try {
 		/* DB랑 연결 시키기 */
 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
 		stmt = conn.createStatement();
 		rs = stmt.executeQuery("SELECT name FROM country");
 		
 		while (rs.next()) {
 			/* 첫번째 컬럼의 값 */
 			/* int result = rs.getInt(1);
 			out.println(result == 1 ? "연결 성공" : "연결 실패"); */
 			out.println("<li>" + rs.getString("name") + "</li>");
 		}
 	} finally {
 		if (rs != null) {
 			rs.close();
 		}
 		if (stmt != null) {
 			stmt.close();
 		}
 		if (conn != null) {
 			conn.close();
 		}
 	}
 %>

	</ul> 
</body>
</html>