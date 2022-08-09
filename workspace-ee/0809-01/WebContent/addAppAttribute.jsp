<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>어플리케이션 기본 객체에 이름-값 설정하는 페이지</p>
<!-- map 이라 생각하고, 어플리케이션이 동작하는 동안에는 map이 사라지지 않는다고 생각하면 편함 -->
	<%
		application.setAttribute("myStr", "string-obj");
		application.setAttribute("myInt", Integer.valueOf(10));
	%>
</body>
</html>