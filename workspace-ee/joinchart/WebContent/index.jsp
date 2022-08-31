<%@page import="test.crawling.Paging"%>
<%@page import="test.crawling.Vibej"%>
<%@page import="test.crawling.YoutubeMusic"%>
<%@page import="test.crawling.Youtube"%>
<%@page import="test.crawling.Floj"%>
<%@page import="org.openqa.selenium.WebElement"%>
<%@page import="org.openqa.selenium.chrome.ChromeDriver"%>
<%@page import="org.openqa.selenium.chrome.ChromeOptions"%>
<%@page import="io.github.bonigarcia.wdm.WebDriverManager"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="test.crawling.Genie"%>
<%@page import="test.crawling.Bugs"%>
<%@page import="test.crawling.Melon"%>
<%@page import="test.crawling.Music"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ct" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>조인 차트</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/jstable.scss" />
<link rel="stylesheet" href="./css/main.css">

<script src="./js/jstable.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Rubik&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>

	<c:set var="num" value="1" />
	<%
		List<Music> melonlist = Melon.crawlingMelon();
	request.setAttribute("melonlist", melonlist);
	List<Music> genielist = Genie.crawlingGenie();
	request.setAttribute("genielist", genielist);
	List<Music> bugslist = Bugs.crawlingBugs();
	request.setAttribute("bugslist", bugslist);
	List<Music> flolist = Floj.crawlingFlo();
	request.setAttribute("flolist", flolist);
	List<Music> vibelist = Vibej.crawlingVibe();
	request.setAttribute("vibelist", vibelist);

	String url1 = "https://www.melon.com/chart/index.htm";
	String url2 = "https://www.genie.co.kr/chart/top200";
	String url3 = "https://music.bugs.co.kr/chart";
	String url4 = "https://www.music-flo.com/browse";
	String url5 = "https://vibe.naver.com/chart/total";

	//크롤링하고싶은 대상 url 을 적는다 
	Document doc = Jsoup.connect(url1).get();
	Elements melontime = doc.select("div.calendar_prid>span");
	request.setAttribute("melontime", melontime);

	Document doc3 = Jsoup.connect(url3).get();
	String bugstime = doc3.select("time").text().substring(0, 16);
	request.setAttribute("bugstime", bugstime);

	String floTime = Floj.floTime();
	request.setAttribute("floTime", floTime);

	String vibeTime = Vibej.vibeTime();
	request.setAttribute("vibeTime", vibeTime);
	%>
	<main>
		<section class="chart">
			<table id="melon">
				<thead>
					<tr>
						<th colspan="5" class="charttitle">멜론차트 top 100</th>
					</tr>
					<tr class="time">
						<th colspan="5">기준 시간 : ${ melontime }</th>
					</tr>
					<tr>
						<th colspan="5">
							<div class="dt-top">
								<div class="dt-search">
									<i class="bi bi-search"></i> <input class="dt-input"
										type="text">
								</div>
							</div>
						</th>
					</tr>
					<tr class="smalltitle">
						<th colspan="2">순위</th>
						<th colspan="3">곡 정보</th>
					</tr>
				</thead>
				<c:forEach items="${ melonlist }" var="melon" varStatus="i">
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
									<a href="./chartmelon.jsp?title=${ melon.title }">
									<ct:pre value="${ melon.title }"></ct:pre>
									</a>
								</p>
								<p class="album overflow">
									<c:out value="${ melon.album }" />
								</p>
							</div>
						</td>
						<td class="artist">
							<p class="overflow">
								<a href="https://www.google.com/search?q=${ melon.artist }">
								<c:out value="${ melon.artist }" />
							</a>
							</p>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="dt-bottom">
								<div class="dt-pagination">
									<ul>
										<li class="pager"><a href="#" data-page="1">«</a></li>
										<li class="pager"><a href="#" data-page="1">‹</a></li>
										<li class="active"><a href="#" data-page="1">1</a></li>
										<li class=""><a href="#" data-page="2">2</a></li>
										<li class=""><a href="#" data-page="3">3</a></li>
										<li class=""><a href="#" data-page="4">4</a></li>
										<li class=""><a href="#" data-page="5">5</a></li>
										<li class=""><a href="#" data-page="6">6</a></li>
										<li class=""><a href="#" data-page="7">7</a></li>
										<li class="dt-ellipsis"><span>…</span></li>
										<li class=""><a href="#" data-page="10">10</a></li>
										<li class="pager"><a href="#" data-page="2">›</a></li>
										<li class="pager"><a href="#" data-page="10">»</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			<table id="genie">
				<thead>
					<tr>
						<td colspan="5" class="charttitle">지니차트 top 100</td>
					</tr>
					<tr class="time">
						<th colspan="5">기준 시간 : ${ bugstime }</th>
					</tr>
					<tr>
						<th colspan="5">
							<div class="dt-top">
								<div class="dt-search">
									<i class="bi bi-search"></i> <input class="dt-input"
										type="text">
								</div>
							</div>
						</th>
					</tr>
					<tr class="smalltitle">
						<th colspan="2">순위</th>
						<th colspan="3">곡 정보</th>
					</tr>
				</thead>
				<c:forEach items="${ genielist }" var="genie" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ genie.rank }" /></td>
						<td class="updown"><c:out value="${ genie.updown }" /></td>
						<td>
							<div class="image">
								<img class="albumArt" src="${ genie.albumArt }" />
							</div>
						</td>
						<td>
							<div class="title">
								<p class="overflow">
									<a href="./chartgenie.jsp?title=${ genie.title }"> <c:out
											value="${ genie.title }" />
									</a>
								</p>
								<p class="album overflow">
									<c:out value="${ genie.album }" />
								</p>
							</div>
						</td>
						<td class="artist">
							<p class="overflow">
								<a href="https://www.google.com/search?q=${ genie.artist }">
								<c:out value="${ genie.artist }" />
							</a>
							</p>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="dt-bottom">
								<div class="dt-pagination">
									<ul>
										<li class="pager"><a href="#" data-page="1">«</a></li>
										<li class="pager"><a href="#" data-page="1">‹</a></li>
										<li class="active"><a href="#" data-page="1">1</a></li>
										<li class=""><a href="#" data-page="2">2</a></li>
										<li class=""><a href="#" data-page="3">3</a></li>
										<li class=""><a href="#" data-page="4">4</a></li>
										<li class=""><a href="#" data-page="5">5</a></li>
										<li class=""><a href="#" data-page="6">6</a></li>
										<li class=""><a href="#" data-page="7">7</a></li>
										<li class="dt-ellipsis"><span>…</span></li>
										<li class=""><a href="#" data-page="10">10</a></li>
										<li class="pager"><a href="#" data-page="2">›</a></li>
										<li class="pager"><a href="#" data-page="10">»</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			<table id="bugs">
				<thead>
					<tr>
						<td colspan="5" class="charttitle">벅스차트 top 100</td>
					</tr>
					<tr class="time">
						<th colspan="5">기준 시간 : ${ bugstime }</th>
					</tr>
					<tr>
						<th colspan="5">
							<div class="dt-top">
								<div class="dt-search">
									<i class="bi bi-search"></i> <input class="dt-input"
										type="text">
								</div>
							</div>
						</th>
					</tr>
					<tr class="smalltitle">
						<th colspan="2">순위</th>
						<th colspan="3">곡 정보</th>
					</tr>
				</thead>
				<c:forEach items="${ bugslist }" var="bugs" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ bugs.rank }" /></td>
						<td class="updown"><c:out value="${ bugs.updown }" /></td>
						<td>
							<div class="image">
								<img class="albumArt" src="${ bugs.albumArt }" />
							</div>
						</td>
						<td>
							<div class="title">
								<p class="overflow">
									<a
										href="https://www.youtube.com/results?search_query=${ bugs.title }+${ bugs.artist }+official">
										<c:out value="${ bugs.title }" />
									</a>
								</p>
								<p class="album overflow">
									<c:out value="${ bugs.album }" />
								</p>
							</div>
						</td>
						<td class="artist">
							<p class="overflow">
							<a href="https://www.google.com/search?q=${ bugs.artist }">
								<c:out value="${ bugs.artist }" />
							</a>
							</p>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="dt-bottom">
								<div class="dt-pagination">
									<ul>
										<li class="pager"><a href="#" data-page="1">«</a></li>
										<li class="pager"><a href="#" data-page="1">‹</a></li>
										<li class="active"><a href="#" data-page="1">1</a></li>
										<li class=""><a href="#" data-page="2">2</a></li>
										<li class=""><a href="#" data-page="3">3</a></li>
										<li class=""><a href="#" data-page="4">4</a></li>
										<li class=""><a href="#" data-page="5">5</a></li>
										<li class=""><a href="#" data-page="6">6</a></li>
										<li class=""><a href="#" data-page="7">7</a></li>
										<li class="dt-ellipsis"><span>…</span></li>
										<li class=""><a href="#" data-page="10">10</a></li>
										<li class="pager"><a href="#" data-page="2">›</a></li>
										<li class="pager"><a href="#" data-page="10">»</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			<table id="flo">
				<thead>
					<tr>
						<td colspan="5" class="charttitle">FLO 24시간 차트</td>
					</tr>
					<tr class="time">
						<th colspan="5">기준 시간 : ${ floTime }</th>
					</tr>
					<tr>
						<th colspan="5">
							<div class="dt-top">
								<div class="dt-search">
									<i class="bi bi-search"></i> <input class="dt-input"
										type="text">
								</div>
							</div>
						</th>
					</tr>
					<tr class="smalltitle">
						<th colspan="2">순위</th>
						<th colspan="3">곡 정보</th>
					</tr>
				</thead>
				<c:forEach items="${ flolist }" var="flo" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ flo.rank }" /></td>
						<td class="updown"><c:out value="${ flo.updown }" /></td>
						<td>
							<div class="image">
								<img class="albumArt" src="${ flo.albumArt }" />
							</div>
						</td>
						<td>
							<div class="title">
								<p class="overflow">
									<a
										href="https://www.youtube.com/results?search_query=${ flo.title }+${ flo.artist }+official">
										<c:out value="${ flo.title }" />
									</a>
								</p>
								<p class="album overflow">
									<c:out value="${ flo.album }" />
								</p>
							</div>
						</td>
						<td class="artist">
							<p class="overflow">
								<a href="https://www.google.com/search?q=${ flo.artist }">
								<c:out value="${ flo.artist }" />
							</a>
							</p>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="dt-bottom">
								<div class="dt-pagination">
									<ul>
										<li class="pager"><a href="#" data-page="1">«</a></li>
										<li class="pager"><a href="#" data-page="1">‹</a></li>
										<li class="active"><a href="#" data-page="1">1</a></li>
										<li class=""><a href="#" data-page="2">2</a></li>
										<li class=""><a href="#" data-page="3">3</a></li>
										<li class=""><a href="#" data-page="4">4</a></li>
										<li class=""><a href="#" data-page="5">5</a></li>
										<li class=""><a href="#" data-page="6">6</a></li>
										<li class=""><a href="#" data-page="7">7</a></li>
										<li class="dt-ellipsis"><span>…</span></li>
										<li class=""><a href="#" data-page="10">10</a></li>
										<li class="pager"><a href="#" data-page="2">›</a></li>
										<li class="pager"><a href="#" data-page="10">»</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
			<table id="vibe">
				<thead>
					<tr>
						<td colspan="5" class="charttitle">Vibe 차트</td>
					</tr>
					<tr class="time">
						<th colspan="5">기준 시간 : ${ vibeTime }</th>
					</tr>
					<tr>
						<th colspan="5">
							<div class="dt-top">
								<div class="dt-search">
									<i class="bi bi-search"></i> <input class="dt-input"
										type="text">
								</div>
							</div>
						</th>
					</tr>
					<tr class="smalltitle">
						<th colspan="2">순위</th>
						<th colspan="3">곡 정보</th>
					</tr>
				</thead>
				<c:forEach items="${ vibelist }" var="vibe" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ vibe.rank }" /></td>
						<td class="updown"><c:out value="${ vibe.updown }" /></td>
						<td>
							<div class="image">
								<img class="albumArt" src="${ vibe.albumArt }" />
							</div>
						</td>
						<td>
							<div class="title">
								<p class="overflow">
									<a
										href="https://www.youtube.com/results?search_query=${ vibe.title }+${ vibe.artist }+official">
										${ vibe.title }
									</a>
								</p>
								<p class="album overflow">
									<c:out value="${ vibe.album }" />
								</p>
							</div>
						</td>
						<td class="artist">
							<p class="overflow">
								<a href="https://www.google.com/search?q=${ vibe.artist }">
								<c:out value="${ vibe.artist }" />
							</a>
							</p>
						</td>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
						<td colspan="5">
							<div class="dt-bottom">
								<div class="dt-pagination">
									<ul>
										<li class="pager"><a href="#" data-page="1">«</a></li>
										<li class="pager"><a href="#" data-page="1">‹</a></li>
										<li class="active"><a href="#" data-page="1">1</a></li>
										<li class=""><a href="#" data-page="2">2</a></li>
										<li class=""><a href="#" data-page="3">3</a></li>
										<li class=""><a href="#" data-page="4">4</a></li>
										<li class=""><a href="#" data-page="5">5</a></li>
										<li class=""><a href="#" data-page="6">6</a></li>
										<li class=""><a href="#" data-page="7">7</a></li>
										<li class="dt-ellipsis"><span>…</span></li>
										<li class=""><a href="#" data-page="10">10</a></li>
										<li class="pager"><a href="#" data-page="2">›</a></li>
										<li class="pager"><a href="#" data-page="10">»</a></li>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</section>
	</main>
	<script>
		new JSTable("#melon");
		new JSTable("#genie");
		new JSTable("#bugs");
		new JSTable("#flo");
		new JSTable("#vibe");
	</script>
</body>
</html>