<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원하는 목록맞냐?!</title>
</head>
<body>
<%
	String continent = request.getParameter("continent");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
	String query = "SELECT Name, Population FROM country WHERE continent = ? ORDER BY Population DESC";
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1, continent);
	rs = pstmt.executeQuery();
	
	while (rs.next()) {
		String name = rs.getString("Name");
		String pop = rs.getString("Population");
		out.println("<li>" + "나라 이름: " + name + ", 인구: " + pop + "</li>");
	}
} finally {
	if (rs != null) {
		rs.close();
	}
	if (pstmt != null) {
		pstmt.close();
	}
	if (conn != null) {
		conn.close();
	}
}
%>
<form action="searchform.jsp">
	<button>돌아가기</button>
</form>
</body>
</html>