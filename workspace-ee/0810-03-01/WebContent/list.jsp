<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<c:if test="${ not empty list }">
		<ul>
			<c:forEach var="person" items="${ list }">
				<li>${ person.firstName } ${ person.lastName } ${ person.age } ${ person.email }</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>