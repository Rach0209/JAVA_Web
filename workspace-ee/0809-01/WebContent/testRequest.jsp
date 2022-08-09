<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>자바 웹 애플리케이션은 각각의 고유한 context root 경로를 가집니다</p>
	<p><%= request.getContextPath() %></p>
	<!-- 표현식을 사용해서 루트 경로를 가져오면 편리 -->
	<form action="<%= request.getContextPath() %>/testRequest.jsp">
		<input type="submit" />
	</form>
</body>
</html>