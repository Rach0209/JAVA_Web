<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답 함 보까~?</title>
</head>
<body>
	<%
		String[] questions = new String[6];
	questions[0] = "문제 : 스위스 인터라켄에 위치한 Top of Europe이라 불리는 산은?";
	questions[1] = "문제 : 기본적인 피아노 건반은 몇개일까요?";
	questions[2] = "문제 : 오늘 학원의 2분단에는 몇명이 남았을까요?";
	questions[3] = "문제 : 사회로 방출되기까지 몇달 남았을까요?";
	questions[4] = "문제 : {5 + (5 * 2) + 3} / 2 = ?";
	questions[5] = "문제 : 안성훈이 지어준 장예림의 별명은?";
	String[] answers = new String[questions.length];
	answers[0] = "융프라우";
	answers[1] = "88개";
	answers[2] = "5명";
	answers[3] = "2달";
	answers[4] = "9";
	answers[5] = "옥자";
	String answer = request.getParameter("answer");
	String question = request.getParameter("question");
	%>
	제출한 답 :
	<%=answer%>
	<%
		Map<String[], String[]> map = new HashMap<String[], String[]>();
	map.put(questions, answers);
	String aa = "";
	for (int i = 0; i < questions.length; i++) {
		if (questions[i].equals(question)) {
			aa = answers[i].toString();
	%>
		<%="정답은 : " + aa + " 입니다"%>
	<%
		}
	}
	%>
</body>
</html>