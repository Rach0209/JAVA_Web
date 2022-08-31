
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="test.crawling.Genie"%>
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
	List<Graph> graphGenie = Genie.graphGenie(title);
	List<String> weekGenie = Genie.weekGenie();
	request.setAttribute("graphGenie", graphGenie);
	request.setAttribute("weekGenie", weekGenie);
	
	LocalDateTime now = LocalDateTime.now();	
	DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MMdd");
	List<String> hourList = new ArrayList<>();
	for (int i = 20; i >= 0 ; i--) {
		String date = now.minusDays(i).format(dateformatter);
		hourList.add(String.valueOf(date));
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
/* [ '00시', '01시', '02시', '03시', '04시', '05시', '06시', '07시', '08시', '09시', '10시', '11시', '12시', '13시', '14시', '15시', '16시', '17시', '18시', '19시', '20시', '21시', '22시', '23시' ] */
var labels = [<c:forEach items="${ time }" var="tim">"${ tim }",</c:forEach>];
	new Chart(document.getElementById("line-chart"), {
		type : 'line',
		data : {
			labels : labels,
			datasets : [ {
				data :  [null,null,null,null,null,null,null,null,null,null,null,null,null,null,<c:forEach begin="0" end="6" items="${ graphGenie }" var="graph" varStatus="i"><c:out value="${ graph.notIn }" />,</c:forEach>] ,
				label : '<c:out value="${weekGenie.get(0)}"/>',				
				borderColor : "#3e95cd",
				fill : false
			}, {
				data :  [null,null,null,null,null,null,null,<c:forEach begin="7" end="13" items="${ graphGenie }" var="graph" varStatus="i"><c:out value="${ graph.notIn }" />,</c:forEach>] ,
				label : '<c:out value="${weekGenie.get(1)}"/>',
				borderColor : "#8e5ea2",
				fill : false
			}, {
				data :  [<c:forEach begin="14" end="20" items="${ graphGenie }" var="graph" varStatus="i"><c:out value="${ graph.notIn }" />,</c:forEach>] ,
				label : '<c:out value="${weekGenie.get(2)}"/>',
				borderColor : "#3cba9f",
				fill : false
			}]
		},
		options : {
			responsive: false,
			scales: {
				yAxes: [{
					ticks: {
						suggestedMin : 1,
						suggestedMax : 100,
						reverse	: true
					}
				}]
				
			},
			title : {
				display : true,
				text : "${title}"
			}
		}
	});
</script>
</html>