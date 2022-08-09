<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 자바 코드를 적을 수 있는 영역!
		// scriptlet 영역 이라 불림.
		// 자바 표현은 컴파일이 되는 중이다.
		System.out.println("사용자가 jsp 페이지를 요청했습니다.");
		int a = 10;
	%>
	<p>jsp 페이지 입니다.</p>
	<!-- %= 표현식. 밑에서는 LocalTime.now()의 toString()이 호출된 것. -->
	<strong><%= java.time.LocalTime.now() %></strong><br />
	<p>a의 값은 <%= a %>입니다.</p>
	<!-- 밑의 표현을 해주면, 실행흐름을 건너 띄어준다 (%-- --%) -->
	<%-- 
	<p>b의 값은 <%= b %>입니다.</p>
	<% int b = 20; %>
	--%>
	<p> 현재 날짜 : <%= LocalDate.now() %> 입니다.</p>
</body> 
</html>