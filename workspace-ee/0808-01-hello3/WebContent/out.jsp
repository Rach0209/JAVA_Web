<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     	out.println("<DOCTYPE html");
    	// 아래를 이렇게 알아서 해석해줌
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 기본객체</title>
</head>
<body>
	<h1>정적 텍스트</h1>
	<%= 1 + 2 + 3 %><br />
	
	<%
		out.println(1 + 2 + 3);
		out.println("<br />");
	%>
	
	<p>jsp의 모든 텍스트는 아웃 객체가 출력합니다.</p>
	
	<%
		boolean someBool = true;
	
		if (someBool) {
			out.println("<p>참일 때 출력해야하는 값</p>");
			// 문자열을 그대로 출력할 수 있는 객체
		} else {
			out.println("<p>거짓일 때 출력해야하는 텍스트</p>");
		}
		
		// out.flush(); // 명시적으로 flush 써줘서 buffer 내보내기
	%>
</body>
</html>