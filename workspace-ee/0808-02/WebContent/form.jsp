<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사용자가 페이지에 대한 정보를 입력 -->
	<!-- 사용자가 페이지 번호를 입력하면 해당 페이지의 책 목록이 출력 -->
	<!-- 1페이지 입력하면 0~9까지 10개의 목록이 출력되도록, 2페이지-10~19 -->
	<form action="./books.jsp">
		<input type="number" name="page" />
		<input type="submit" />
	</form>
</body>
</html>