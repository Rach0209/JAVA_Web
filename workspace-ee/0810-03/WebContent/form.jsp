<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
			<!-- ./ => 현재 경로부터 찾기위해~ 
				/ => root경로라서 쓸 경우 /0810-03/param으로 해주어야 함
				또는 ${ pageContext.request.contextPath }/param -->
	<form action="./param">
		<input type="text" name="name" />
		<input type="number" name="age" />
		<input type="submit" />
	</form>
</body>
</html>