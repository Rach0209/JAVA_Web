<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		입력폼. 필수!!!!!
		사용자 이름
		사용자 나이
	 -->
	 <!-- 요청 =>>> 주소만 입력해서 값을 입력 할 수 있다!
	 	  일반 사용자를 위한 배려도 필요하지만, 로직처리에서 입력값을 검사해야한다.
	 	  !더블 체크! -->
	 <form action="personresult.jsp">
	 	사용자 이름 <input type="text" name="name" required>
	 	사용자 나이 <input type="number" name="age" required>
	 	<input type="submit" value="제출">
	 </form>
</body>
</html>