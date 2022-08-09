<!-- 
	계산 결과 출력 페이지
 -->
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
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		String operator = request.getParameter("operator");
		
		if (operator.equals("plus")) {
			out.println(num1 + num2); 
		} else if (operator.equals("minus")) {
			out.println(num1 - num2); 
		} else if (operator.equals("multiply")) {
			out.println(num1 * num2); 
		} else if (operator.equals("divide") && num2 != 0) {
				out.println(num1 / num2); 
			} else {
				response.sendRedirect("./calcform.jsp");
			}
	%>
</body>
</html>