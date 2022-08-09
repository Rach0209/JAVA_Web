<%@page import="com.sun.prism.Image"%>
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
	/* getParameter는 무조건 문자열 하나만 반환, 여러개일 때 Values사용 */
	String[] check = request.getParameterValues("num");
	
	for (int i = 0; i < check.length; i++) {
		out.println("<img src= './images/chunsik/춘식" + check[i]  + ".png'/>");
	}
	%>
</body>
</html>