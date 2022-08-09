<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>A</h1>
<p>현재 시간</p>
<!-- 객체로 받아줘서 객체인 result로만 표현하기 -->
<% Object result = request.getAttribute("time"); %>
<%= result %>
</body>
</html>