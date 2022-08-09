<!-- 
	입력 폼
	숫자1
	숫자2
	
	연산자 + - * / 선택
	전송
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
	<form action="./calcresult.jsp">
		숫자1<input type="number" name="number1" /> 
		숫자2<input type="number" name="number2" /> 
		연산자<select name="operator">
			<option value="none">=== 선택 ===</option>
			<option value="plus">+</option>
			<option value="minus">-</option>
			<option value="multiply">*</option>				
			<option value="divide">/</option>
		</select>
		<input type="submit" value="계산"/>
	</form>
</body>
</html>