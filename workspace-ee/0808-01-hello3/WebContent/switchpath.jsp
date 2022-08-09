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
		String choice = request.getParameter("radioB");
		
		if (choice == null || choice.length() == 0) {
			response.sendRedirect("./want.jsp?progress=failed");
			// 주소할 때 띄어쓰기도 하나의 문자로 파악하므로 다르게 적용됨
			// 쿼리문으로 실패했음을 전달, but 주소에 담기므로 사용자에게도 값이 그대로 노출
		} else if (choice.equals("fruit")) {
			response.sendRedirect("./fruit.jsp");
		} else if(choice.equals("person")){
			response.sendRedirect("./persons.jsp");
		}
		
	%>
 	
</body>
</html>