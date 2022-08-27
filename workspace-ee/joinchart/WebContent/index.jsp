<%@page import="test.crawling.Vibej"%>
<%@page import="test.crawling.YoutubeMusic"%>
<%@page import="test.crawling.Youtube"%>
<%@page import="test.crawling.Vibe"%>
<%@page import="test.crawling.Floj"%>
<%@page import="org.openqa.selenium.WebElement"%>
<%@page import="org.openqa.selenium.chrome.ChromeDriver"%>
<%@page import="org.openqa.selenium.chrome.ChromeOptions"%>
<%@page import="io.github.bonigarcia.wdm.WebDriverManager"%>
<%@page import="test.crawling.Flo"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>크롤링 테스트</title>
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/main.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&family=Rubik&display=swap"
	rel="stylesheet">
</head>
<body>
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
	/* List<YoutubeMusic> youtubelist = Youtube.crawlingYoutube();
	request.setAttribute("youtubelist", youtubelist); */

	String url1 = "https://www.melon.com/chart/index.htm";
	String url2 = "https://www.genie.co.kr/chart/top200";
	String url3 = "https://music.bugs.co.kr/chart";
	String url4 = "https://www.music-flo.com/browse";
	String url5 = "https://vibe.naver.com/chart/total";

	 //크롤링하고싶은 대상 url 을 적는다 
	Document doc = Jsoup.connect(url1).get();
	Elements melontime = doc.select("div.calendar_prid>span");
	request.setAttribute("melontime", melontime);

	/*WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-popup-blocking");
	options.addArguments("--start-maximized");
	options.addArguments("headless");
	options.addArguments("--disable-gpu");
	options.addArguments("--blink-settings=imagesEnabled=false");
	ChromeDriver driver = new ChromeDriver(options);

	String genietime = null;
	String genietime2 = null;

	try {
		driver.get("https://www.genie.co.kr/chart/top200");
		Thread.sleep(2000);
		List<WebElement> el = driver.findElementsById("inc_date");
		List<WebElement> el2 = driver.findElementsById("inc_time");
		genietime = el.get(0).getText() + " " + el2.get(0).getText();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	request.setAttribute("genietime", genietime); */

	Document doc3 = Jsoup.connect(url3).get();
	String bugstime = doc3.select("time").text().substring(0, 16);
	request.setAttribute("bugstime", bugstime);

	/* try {
		driver.get(url4);
		Thread.sleep(2000);
		WebElement flotime = driver.findElementByCssSelector("p.update>span");

		String flotime_temp = flotime.getText();
		System.out.println(flotime_temp);
		request.setAttribute("flotime", flotime_temp);

	} catch (Exception e) {
		e.printStackTrace();
	} */

	String vibeTime = Vibej.vibeTime();
	request.setAttribute("vibeTime", vibeTime);
	%>
	<main>
		<section class="chart">
			<table>
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
				<c:forEach items="${ melonlist }" var="melon" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ melon.rank }" /></td>
						<td class="updown"><c:out value="${ melon.updown }" /></td>
						<td><img class="albumArt" src="${ melon.albumArt }" /></td>
						<td class="title">
							<p>
								<a
									href="https://www.youtube.com/results?search_query=${ melon.title }+${ melon.artist }+official">
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
					<td colspan="5" class="charttitle">지니차트 top 100</td>
				</tr>
				<tr class="time">
					<th colspan="5">기준 시간 : ${ bugstime }</th>
				</tr>
				<tr class="smalltitle">
					<th colspan="2">순위</th>
					<th colspan="3">곡 정보</th>
				</tr>
				<c:forEach items="${ genielist }" var="genie" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ genie.rank }" /></td>
						<td class="updown"><c:out value="${ genie.updown }" /></td>
						<td><img class="albumArt" src="${ genie.albumArt }" /></td>
						<td class="title">
							<p>
								<a
									href="https://www.youtube.com/results?search_query=${ genie.title }+${ genie.artist }+official">
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
					<td colspan="5" class="charttitle">벅스차트 top 100</td>
				</tr>
				<tr class="time">
					<th colspan="5">기준 시간 : ${ bugstime }</th>
				</tr>
				<tr class="smalltitle">
					<th colspan="2">순위</th>
					<th colspan="3">곡 정보</th>
				</tr>
				<c:forEach items="${ bugslist }" var="bugs" varStatus="i">
					<tr>
						<td \class="rank"><c:out value="${ bugs.rank }" /></td>
						<td class="updown"><c:out value="${ bugs.updown }" /></td>
						<td><img class="albumArt" src="${ bugs.albumArt }" /></td>
						<td class="title">
							<p>
								<a
									href="https://www.youtube.com/results?search_query=${ bugs.title }+${ bugs.artist }+official">
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
			<%-- 	<table>
				<tr>
					<td colspan="4" class="charttitle">Youtube 주간 인기곡 차트</td>
				</tr>
				<tr class="time">
					<th colspan="5">기준 시간 :</th>
				</tr>
				<tr class="smalltitle">
					<th colspan="2">순위</th>
					<th colspan="3">곡 정보</th>
				</tr>
				<c:forEach items="${ youtubelist }" var="youtube" varStatus="i">
					<tr>
						<td class="rank">
							<c:out value="${ youtube.rank }" />
						</td>
						<td>
							<a href="${ youtube.link }">
								<img class="albumArt" src="${ youtube.albumArt }" />
							</a>
						</td>
						<td class="title">
							<p>
								<c:out value="${ youtube.title }" />
							</p>
						</td>
					</tr>
				</c:forEach>
			</table> --%>
			<table>
				<tr>
					<td colspan="5" class="charttitle">FLO 24시간 차트</td>
				</tr>
				<tr class="time">
					<th colspan="5">기준 시간 : ${ flotime }</th>
				</tr>
				<tr class="smalltitle">
					<th colspan="2">순위</th>
					<th colspan="3">곡 정보</th>
				</tr>
				<c:forEach items="${ flolist }" var="flo" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ flo.rank }" /></td>
						<td class="rank"><c:out value="${ flo.updown }" /></td>
						<td><img class="albumArt" src="${ flo.albumArt }" /></td>
						<td class="title">
							<p>
								<a
									href="https://www.youtube.com/results?search_query=${ flo.title }+${ flo.artist }+official">
									<c:out value="${ flo.title }" />
								</a>
							</p>
							<p class="album">
								<c:out value="${ flo.album }" />
							</p>
						</td>
						<td class="artist"><c:out value="${ flo.artist }" /></td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td colspan="5" class="charttitle">Vibe 차트</td>
				</tr>
				<tr class="time">
					<th colspan="5">기준 시간 : ${ vibeTime }</th>
				</tr>
				<tr class="smalltitle">
					<th colspan="2">순위</th>
					<th colspan="3">곡 정보</th>
				</tr>
				<c:forEach items="${ vibelist }" var="vibe" varStatus="i">
					<tr>
						<td class="rank"><c:out value="${ vibe.rank }" /></td>
						<td class="rank"><c:out value="${ vibe.updown }" /></td>
						<td><img class="albumArt" src="${ vibe.albumArt }" /></td>
						<td class="title">
							<p>
								<a
									href="https://www.youtube.com/results?search_query=${ vibe.title }+${ vibe.artist }+official">
									<c:out value="${ vibe.title }" />
								</a>
							</p>
							<p class="album">
								<c:out value="${ vibe.album }" />
							</p>
						</td>
						<td class="artist"><c:out value="${ vibe.artist }" /></td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</main>
</body>
</html>