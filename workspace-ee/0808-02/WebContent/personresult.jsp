<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* 유효한 값인지 꼭 확인하는 절차가 있어야 한다!! 
		값을 가져와서 올바른 타입인지 아닌지, 타입 값 가져와서 값이 올바른지 아닌지,
		잘못된 값이면 사용자가 알 수 있게끔 잘못된 요청이라는 것으로 응답 보내기,
		항상 체크하기*/
		/* trim() = 공백 자르기 */
	String name = request.getParameter("name");
	name = name.trim();

	String ageStr = request.getParameter("age");

	/* 잘못된 요청 응답해주기. */
	if (ageStr == null || ageStr.trim().length() == 0) {
		/* 응답 코드는 상수로 정의되어 있다. */
		response.setStatus(400);
		out.println("잘못된 입력");
	} else {
		int age = Integer.parseInt(request.getParameter("age"));

		if (name.length() == 0) {
			response.sendRedirect("./person.jsp");
		} else {
			out.print("(" + name + ", " + age + ")님 환영합니다.");
		}
	}
	%>
</body>
</html>