<%@page import="java.util.Random"%>
<%@page import="java.util.Map"%>
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
		String q1 = "문제 : 스위스 인터라켄에 위치한 Top of Europe이라 불리는 산은?";
		String q2 = "문제 : 기본적인 피아노 건반은 몇개일까요?";
		String q3 = "문제 : 오늘 학원의 2분단에는 몇명이 남았을까요?";
		String q4 = "문제 : 사회로 방출되기까지 몇달 남았을까요?";
		String q5 = "문제 : {5 + (5 * 2) + 3}/ 2 = ?";
		String q6 = "문제 : 안성훈이 지어준 장예림의 별명은?";

		Random random = new Random();
		int number = random.nextInt(4) + 1;
		String question = "";
		if (number == 1) {
			question = q1;
		} else if (number == 2) {
			question = q2;
		} else if (number == 3) {
			question = q3;
		} else if (number == 4) {
			question = q4;
		} else if (number == 5) {
			question = q5;
		} else if (number == 6) {
			question = q6;
		}
	%>
	<form action="/baek/requestQuiz2.jsp" method="get">
		<label><output name="question"><%= question %></output></label><br />
		<label>답 : <input name="answer" type="text" /></label> <label><input
			type="submit" /></label>
	</form>
</body>
</html>