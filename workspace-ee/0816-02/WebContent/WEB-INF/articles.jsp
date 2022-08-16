<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<c:if test="${ not empty articles }">
		<c:forEach var="a" items="${ articles }">
			<p>${ a }</p>
		</c:forEach>
	</c:if>
</body>
</html>