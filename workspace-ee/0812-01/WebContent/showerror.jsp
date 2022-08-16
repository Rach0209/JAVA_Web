<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- forward된 정보가 에러 페이지로 넘어옴. -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 보여줄 페이지</title>
</head>
<body>
	<p>요청 처리 중 에러가 발생했습니다. 다시 시도해주세요.</p>
	<!-- 보안을 위해 에러 정보는 감추기~ 보여줄 필요가 없음. -->
	<%-- <%= exception.getClass().getName() %> --%>
</body>
</html>