<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러 페이지로 forward된다.  -->
<%@ page errorPage="showerror.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 발생시킬 페이지</title>
</head>
<body>
	<%
		String name = null;
		System.out.println(name.toString());
	%>
</body>
</html>