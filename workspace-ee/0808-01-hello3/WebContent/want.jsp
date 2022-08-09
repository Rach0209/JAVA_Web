<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭘 보고 싶니?</title>
</head>
<body>
	<%= request.getParameter("progress") %>
	<form action = "./switchpath.jsp" method="post">
		<!-- post로 메소드 호출이 되면, 사용자의 입력 내용이 body부분에 담겨서 서버에 전송이 된다. -->
		<!-- 사람을 선택했으면 사람page, 과일을 선택했으면 과일page가 나오도록 -->
		<!-- 입력값에 따라 결과가 달라지므로 입력값을 확인할 수 있어야 함 => redirect 객체 -->
		<input type="radio" value="person" name="radioB" />사람
		<input type="radio" value="fruit" name="radioB"/>과일
		<input type="submit" value="제출"/>
	</form>
</body>
</html>