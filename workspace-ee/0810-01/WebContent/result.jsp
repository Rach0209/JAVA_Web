<%@page import="kr.co.greenart.CountryDAO"%>
<%@page import="kr.co.greenart.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	

	List<Country> list = (List<Country>) request.getAttribute("list");
%>
	<ul>
	<% 
		for (int i = 0; i < list.size(); i++) { %>
			<li><%= list.get(i).getName() %>
				인구 -
				<%= list.get(i).getPopulation() %>
			</li>
	<% }%>	
	</ul>
</body>
</html>