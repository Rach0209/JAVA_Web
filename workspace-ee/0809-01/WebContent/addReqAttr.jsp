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
		request.setAttribute("reqAttr", "요청 객체에 존재하는 값");
		request.setAttribute("reqInt", 22);
	%>
	
	<%= request.getAttribute("reqAttr") %>
	<%= request.getAttribute("reqInt") %>
</body>
</html>