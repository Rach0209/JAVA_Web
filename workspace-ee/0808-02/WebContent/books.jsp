<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> list = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		list.add("book" + i);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 여러 줄로 적어도 여러 공백을 한 개의 공백으로 치환시켜서 한 줄로 출력 -->
	<%
		String pageStr = request.getParameter("page");
		int pageNum = Integer.parseInt(pageStr);

		int start = (pageNum - 1) * 10;
		
		for(int i = start; i < start + 10; i++) {
			out.println(list.get(i));
			out.println("<br/>");
		}
		/* out객체도 마찬가지로, 출력 객체이다. 표현식(sysout)과의 차이점 => 표현식은 자바 스크립트 안에서 사용할 수 없다.)*/
	%>
</body>
</html>