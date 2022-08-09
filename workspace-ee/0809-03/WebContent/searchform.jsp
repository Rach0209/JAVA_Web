<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무얼 찾을 터인가?</title>
</head>
<body>
	<!-- 사용자가 대륙을 선택힐 수 있게 -->
	<!-- 선택한 대륙의 국가들의 이름, 인구를 볼 수 있는(인구 내림차순 정렬) 페이지 -->
	<% 
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<String> list = new ArrayList<>();
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT DISTINCT Continent FROM country");
		
		while (rs.next()) {
			String continent = rs.getString("Continent");
			list.add(continent);
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
<p>DB에 있는 정보를 가져와</p>
<p>대륙별 나라 이름과 인구 내림차순 정렬하기~~</p>
	<form action="countryinfo.jsp" method="post">
		<select name="continent">
		<% for (int i = 0; i < list.size(); i++) {
			%>
			<option value="<%= list.get(i) %>"><%= list.get(i) %></option>
			<%
		}%>
		</select>
		<input type="submit" />
	</form>
</body>
</html>