<%@page import="kr.co.greenart.Country"%>
<%@page import="kr.co.greenart.CountryDAO"%>
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
 <ul>
 <%
	String continent = request.getParameter("continent");
	CountryDAO dao = new CountryDAO();
	List<Country> list = dao.getCountryByContinent(continent);
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("result.jsp").forward(request, response);
 %>

	</ul> 
</body>
</html>