<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>application 기본 객체</p>
	<p>자바 웹 어플리케이션의 설정 등을 설정하거나 접근할 수 있는 객체입니다.</p>
	<%= application.getMajorVersion() %>
	
	<!-- 값을 변경하면, 서버를 재구동 시켜주어야 한다. -->
	<!-- 어플리케이션 안에서 계속해서 접근 가능한 값이다. 어플리케이션 전반에 관한 설정들을 해주면 된다.(JDBC 드라이버 이름 처럼) -->
	<p><%= application.getInitParameter("myParamName") %></p>
	<p><%= application.getInitParameter("mySetting") %></p>
</body>
</html>