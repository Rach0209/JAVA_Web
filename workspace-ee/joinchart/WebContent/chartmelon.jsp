<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="test.crawling.Melon"%>
<%@page import="test.crawling.Graph"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>차트 연습</title>
</head>
<body>
	<c:set var="title" value="${param.title}" />
	<%
	String title = request.getParameter("title");
	List<Graph> graphMelon = Melon.graphMelon(title);
	request.setAttribute("graphMelon", graphMelon);
	/* List<List<String>> timeGraph = musicGraph.Graph();
	List<String> timeGraph2 = timeGraph.get(1); */
 	LocalDateTime now = LocalDateTime.now();	
	DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MM/dd");
	DateTimeFormatter hourformatter = DateTimeFormatter.ofPattern("HH");
	List<String> hourList = new ArrayList<>();
	String hour = now.format(hourformatter);
	for (int i = 0; i < Integer.valueOf(hour) ; i++) {
		String text;
		if (i == 0) {
			text = "00";
		}
		text = String.valueOf(i + 1);
		hourList.add(String.valueOf(text + ":" + "00"));
	}
	
	int size = hourList.size();
	String[] time = new String[size];
	
	for (int i = 0; i < time.length; i++) {
		time[i] = hourList.get(i);
	}
	request.setAttribute("time", time);
	%>
	<main>
		<div>
			<canvas id="line-chart" width="1200px" height="800px"></canvas>
		</div>
	</main>
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script type="text/javascript">
	var labels = [<c:forEach items="${ time }" var="tim">"${ tim }",</c:forEach>];
	console.log(labels);
	new Chart(document.getElementById("line-chart"), {
		type : 'line',
		data : {
			labels : labels,
			datasets : [ {
				data :  [<c:forEach items="${ graphMelon }" var="graph" varStatus="i" ><c:out value="${ graph.notIn }"/>,</c:forEach>] ,
				label : "일간 멜론 순위",
				borderColor : "#3e95cd",
				fill : false, 
			}]
		},
		options : {
			responsive: false,
			scales: {
				yAxes: [{
					display: true,
					ticks: {
						suggestedMin : 1,
						suggestedMax : 100,
						reverse	: true
					}
				}]
			},
			title : {
				display : true,
				text : "${ title }"
			}
		}
	});
</script>
</html>