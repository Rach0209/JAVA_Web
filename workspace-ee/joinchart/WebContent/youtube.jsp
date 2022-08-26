<%@page import="test.crawling.YoutubeMusic"%>
<%@page import="test.crawling.Music"%>
<%@page import="java.util.List"%>
<%@page import="test.crawling.Youtube"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유튜브 차트 연습</title>
<style type="text/css">
img {
	width: 50px;
	height: 50px;
}
</style>
</head>
<body>
	<%
		List<YoutubeMusic> youlist = Youtube.crawlingYoutube();
		request.setAttribute("youlist", youlist);
	%>
	<table>
            <tr>
               <td colspan="4" class="charttitle">24시간 차트</td>
            </tr>
            <tr class="time">
               <th colspan="5">기준 시간 : 매일 9시</th>
            </tr>
            <tr class="smalltitle">
               <th colspan="2">순위</th>
               <th colspan="2">곡 정보</th>
            </tr>
            <c:forEach items="${ youlist }" var="youtube" varStatus="i">
               <tr>
                  <td class="rank"><c:out value="${ youtube.rank }" /></td>
                  <td><img class="albumArt" src="${ youtube.albumArt }" /></td>
                  <td class="title">
                     <p>
                        <a
                           href="https://www.youtube.com/results?search_query=${ youtube.title }+${ youtube.artist }+official">
                          <c:out value="${ youtube.title }" />
                        </a>
                     </p>
                  </td>
                  <td class="artist"><c:out value="${ youtube.artist }" /></td>
               </tr>
            </c:forEach>
            </table>
</body>
</html>