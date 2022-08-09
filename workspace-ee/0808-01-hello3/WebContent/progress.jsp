<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<p>로그인 처리 요청이 전달되었나요?</p>
	<%
		String id = request.getParameter("userid");
		// 사용자가 전달을 요청한 요청에 대한 정보를 가진 객체
		// 없는 파라미터의 값을 담으면 out.println()했을 때 null로 출력
		
		// 입력값이 있으면 xx님 반갑습니다.
		// 해당 파라미터 값이 전달이 되었으나 입력값이 없으면 ""
		if (id.length() > 0) {
			out.println(id + "님  방가");
			// 값이 있을 때 출력
		} else {
			out.println("입력해주세요.");
			// 값이 없을 때 출력 값이 없으면 id 값 "" 빈 문자열로 출력
			response.sendRedirect("./login.jsp");
			// sendRedirect : 사용자에게 페이지를 이동하라고 응답을 보내주는 메소드
			// redirect가 일을 하면 buffer가 일을 하지 않아서 out.println()이 나오지 않음
			// 요청이 2번 일어남, redirect하라고 응답을 보내고 나면 연결이 끊기고 페이지 보여달라고 재요청하는 것
			// sendRedirect가 호출이 되면 flush가 되지 않음.
		}
	%>
</body>
</html>