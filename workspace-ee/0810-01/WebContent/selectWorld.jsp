<%@page import="kr.co.greenart.CountryDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대륙 선택</title>
</head>
<body>
<% 
	CountryDAO dao = new CountryDAO();
	List<String> list = dao.getContinents();
%>
<p>DB에 있는 정보를 가져와</p>
<p>대륙별 나라 이름과 인구 내림차순 정렬하기~~</p>
	<form action="world.jsp" method="post">
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