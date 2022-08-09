<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>C</h1>
<p>랜덤 정수 0 ~ 100</p>
<%-- <%
	Random r = new Random();
%>
<p><%= r.nextInt() %></p>
 --%>
 <% Object result = request.getAttribute("random"); %>
 <p><%= result %></p>
</body>
</html>