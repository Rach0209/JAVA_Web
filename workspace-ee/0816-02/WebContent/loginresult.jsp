<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<c:if test="${ not empty loginid }">
		<p>${ loginid }님 환영합니다.</p>
	</c:if>
	<c:if test="${ empty loginid }">
		<p>로그인 정보를 확인해주세요.</p>
	</c:if>
	<a href="./index.jsp">메인페이지로</a>
</body>
</html>