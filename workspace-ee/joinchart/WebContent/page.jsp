<%@page import="test.crawling.Music"%>
<%@page import="test.crawling.Melon"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
</head>
<%
	List<Music> melonList = Melon.crawlingMelon();
	request.setAttribute("melonlist", melonList);
	
	out.print(request.getParameter("start"));
%>
<c:set var="music" scope="session" value="${melon.title}" />
<c:set var="totalCount" scope="session" value="<%=melonList.size()%>" />
<c:set var="perPage" scope="session" value="${10}" />
<c:set var="pageStart" value="${param.start}" />
<c:if test="${empty pageStart or pageStart < 0}">
	<c:set var="pageStart" value="0" />
</c:if>
<c:if test="${totalCount < pageStart}">
	<c:set var="pageStart" value="${pageStart - perPage}" />
</c:if>
<a href="?start=${pageStart - perPage}"><<</a>${pageStart + 1}
- ${pageStart + perPage}
<a href="?start=${pageStart + perPage}">>></a>
<table class="products">
	<tr>
		<td colspan="5" class="charttitle">멜론차트 top 100</td>
	</tr>
	<tr class="time">
		<th colspan="5">기준 시간 : ${ melontime }</th>
	</tr>
	<tr class="smalltitle">
		<th colspan="2">순위</th>
		<th colspan="3">곡 정보</th>
	</tr>
	<c:forEach begin="${pageStart}" end="${pageStart + perPage - 1}"
		items="${ melonlist }" var="melon" varStatus="i">
		<tr>
			<td class="rank"><c:out value="${ melon.rank }" /></td>
			<td class="updown"><c:out value="${ melon.updown }" /></td>
			<td>
				<div class="image">
					<img class="albumArt" src="${ melon.albumArt }" />
				</div>
			</td>
			<td>
				<div class="title">
					<p class="overflow">
						<a href="./chart.jsp?=${melon.title}"> <c:out
								value="${melon.title}" />
						</a>
					</p>
					<p class="album overflow">
						<c:out value="${ melon.album }" />
					</p>
				</div>
			</td>
			<td class="artist">
				<p class="overflow">
					<c:out value="${ melon.artist }" />
				</p>
			</td>
		</tr>
	</c:forEach>
</table>