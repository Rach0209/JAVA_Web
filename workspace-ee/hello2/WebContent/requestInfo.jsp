<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라이언트 및 서버 정보</title>
</head>
<body>
	클라이언트IP(IPv6) = <%= request.getRemoteAddr() %> <br>
	요청정보길이 = <%= request.getContentLength() %> <br>
	요청정보 인코딩 = <%= request.getCharacterEncoding() %> <br>
	요청정보 컨텐츠타입 = <%= request.getContentType() %> <br>
	요청정보 프로토콜 = <%= request.getProtocol() %> <br>
	요청정보 전송방식 = <%= request.getMethod() %> <br>
	요청 URI = <%= request.getRequestURI() %> <br>
	컨텍스트 경로 = <%= request.getContextPath() %> <br>
	서버이름 = <%= request.getServerName() %> <br>
	서버포트 = <%= request.getServerPort() %> <br>
	----------------------------------<br />
	<% 
// 	불러 올 때, URLDecoder 클래스의 decode(decoding할 값, decoding 형식)로 디코딩 해준다.
// 	가 먹히지 않아서. request정보를 읽어오기 전에 setCharacterEncoding으로 디코딩을 한 후 불러오기 성공.
	
		request.setCharacterEncoding("UTF-8");
	%>
	<%= request.getRequestURL() %><br />
	<%= request.getQueryString() %><br />
	사용자 이름 = <%= request.getParameter("name") %><br />
	사용자 나이 = <%= request.getParameter("age") %><br />
	사용자 성별 = <%= request.getParameter("gender") %><br />
	<!-- 값이 여러개일 때, 여러개 값을 출력하기~ -->
	사용자 취미 = <%= Arrays.toString(request.getParameterValues("hobby")) %><br />
	<% /* 자바 표현으로 맵을 엔트리셋으로 돌려주는데, 출력하는 부분은 자바코드 부분에서 제외한 후 for문의 중괄호를 다시 닫아줌 */
	Map<String, String[]> map = request.getParameterMap();
	for (Entry<String, String[]> e : map.entrySet()) {
		String key = e.getKey();
		String[] value = e.getValue();
	%>	
		<%= key %><br />
		<%= Arrays.toString(value) %><br />
	<%
	} /* 포문의 중괄호를 닫기. */
	%><br />
</body>
</html>