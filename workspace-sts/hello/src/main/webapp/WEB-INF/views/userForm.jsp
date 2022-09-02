<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 입력</title>
</head>
<body>
<!-- taglib 사용 springframework에서 제공 -->
	<f:form modelAttribute="user" method="post">
		<f:errors path="name"/> <!-- name에 대한 에러 메시지를 보여주기 path로 확인 -->
		<f:input type="text" path="name" />
		<f:errors path="age" />
		<f:input type="number" path="age" />
		<input type="submit" />
	</f:form>
</body>
</html>