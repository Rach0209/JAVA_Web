<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두구두구두국</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	String answer = request.getParameter("answer");
	%>
	제출한 답 = <%=answer%>
	<%
		if (answer.equals("융프라우")) {
	%>
	<p>정답입니다.</p>
	<%
		} else {
	%>
	<p>오답입니다.</p>
	<%
		}
	%>
</body>
</html>