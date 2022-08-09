<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<!-- 사용자가 로그인 처리 페이지로 정보를 넘길 수 있도록 만들어보기 -->
	<form action="./progress.jsp">
	<!-- 현재를 기준으로 상대경로 작성 -->
		<input type="text" name="userid" />
		<input type="submit" /> 
		<!-- submit 눌렀을 때 요청이 들어감 -->
	</form>
</body>
</html>