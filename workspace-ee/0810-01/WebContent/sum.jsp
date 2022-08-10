<%@page import="kr.co.greenart.MyMath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMath m = new MyMath();
	out.println(m.sum(10, 20));
%>
</body>
</html>