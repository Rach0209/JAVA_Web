<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
	<form action="./addperson.do" method="post">
		<input type="text" name="firstname" />
		<input type="text" name="lastname" />
		<input type="number" name="age" />
		<input type="email" name="email" />
		<input type="submit" />
		<c:if test="${ not empty errors }">
			<div>
				<c:forEach var="message" items="errors">
					${ message.value }
				</c:forEach>
			</div>
		</c:if>
	</form>
</body>
</html>