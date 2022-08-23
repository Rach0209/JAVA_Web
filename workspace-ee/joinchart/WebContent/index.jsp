<%@page import="test.crawling.Genie"%>
<%@page import="test.crawling.Bugs"%>
<%@page import="test.crawling.Melon"%>
<%@page import="test.crawling.Music"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크롤링 테스트</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
</head>
<body>
	<%
		List<Music> melonlist = Melon.crawlingMelon();
		request.setAttribute("melonlist", melonlist);
		List<Music> genielist = Genie.crawlingGenie();
		request.setAttribute("genielist", genielist);
		List<Music> bugslist = Bugs.crawlingBugs();
		request.setAttribute("bugslist", bugslist);
	%>
	<main>
		<section class="chart">
			<table>
				<tr>
					<td colspan="5" class="chartName">멜론차트 top 100</td>
				</tr>
				<tr>
					<td>순위</td>
					<td>앨범아트</td>
					<td>제목, 앨범</td>
					<td>가수</td>
				</tr>
				<c:forEach items="${ melonlist }" var="melon">
					<tr>
						<td class="rank"><c:out value="${ melon.rank }" /></td>
						<td><img class="albumArt" src="${ melon.albumArt }" /></td>
						<td>
							<p class="title">
								<a
									href="https://www.youtube.com/results?search_query=${ melon.title }+${ melon.artist }">
									<c:out value="${melon.title}" />
								</a>
							</p>
							<p class="album">
								<c:out value="${ melon.album }" />
							</p>
						</td>
						<td class="artist"><c:out value="${ melon.artist }" /></td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td colspan="5" class="chartName">지니차트 top 100</td>
				</tr>
				<tr>
					<td>순위</td>
					<td>앨범아트</td>
					<td>제목, 앨범</td>
					<td>가수</td>
				</tr>
				<c:forEach items="${ genielist }" var="genie">
					<tr>
						<td class="rank"><c:out value="${ genie.rank }" /></td>
						<td><img class="albumArt" src="${ genie.albumArt }" /></td>
						<td>
							<p class="title">
								<a
									href="https://www.youtube.com/results?search_query=${ genie.title }+${ genie.artist }">
									<c:out value="${ genie.title }" />
								</a>
							</p>
							<p class="album">
								<c:out value="${ genie.album }" />
							</p>
						</td>
						<td class="artist"><c:out value="${ genie.artist }" /></td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td colspan="5" class="chartName">벅스차트 top 100</td>
				</tr>
				<tr>
					<td>순위</td>
					<td>앨범아트</td>
					<td>제목, 앨범</td>
					<td>가수</td>
				</tr>
				<c:forEach items="${ bugslist }" var="bugs">
					<tr>
						<td class="rank"><c:out value="${ bugs.rank }" /></td>
						<td><img class="albumArt" src="${ bugs.albumArt }" /></td>
						<td>
							<p class="title">
								<a
									href="https://www.youtube.com/results?search_query=${ bugs.title }+${ bugs.artist }">
									<c:out value="${ bugs.title }" />
								</a>
							</p>
							<p class="album">
								<c:out value="${ bugs.album }" />
							</p>
						</td>
						<td class="artist"><c:out value="${ bugs.artist }" /></td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</main>
</body>
</html>