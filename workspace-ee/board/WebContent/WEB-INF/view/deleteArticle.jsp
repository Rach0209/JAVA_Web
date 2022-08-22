<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
	${ articleNum }번 ${ deleteDone }
	<br>
	${ ctxPath = pageContext.request.contextPath ; ''}
	<a href="${ ctxPath }/article/list.do">[게시글목록보기]</a>
</body>
</html>