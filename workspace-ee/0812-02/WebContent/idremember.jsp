<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날 기억해</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("rememberme")) {
					request.setAttribute("idvalue", URLDecoder.decode(c.getValue(), "utf-8"));
				}
			}
		}
	%>
	<form action="./login" method="post">
		<input type="text" name="id" value="${ idvalue }" />
		<input type="password" name="password" />
		<label><input type="checkbox" name="rememberme" />저장</label>
		<input type="submit" />
	</form>
</body>
</html>