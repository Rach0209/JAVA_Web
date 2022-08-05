<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력 페이지</title>
</head>
<body>
<!--
// jsp 페이지에
// 사용자의 이름(name)과 나이(age)
// 성별(gender)을 입력받을 수 있는
// <form> 양식을 작성해보세요~~~
-->
	<form action="/baek/requestInfo.jsp">
		<label>이름<input id="name" name="name" type="text" placeholder="이름 입력" /></label>
		<label>나이<input id="age" name="age" type="text" placeholder="나이 입력" /></label>
		<label><input name="gender" type="radio" value="Male" />Male</label>
		<label><input class="gender" name="gender" type="radio" value="Female" />Female</label>
		<input id="submit" type="submit" value="입력 완료" />

	</form>
</body>
<script type="text/javascript">
	let name = document.getElementById("name");
	let age = document.getElementById("age");
	let gender = document.getElementsByName("gender");
	document.getElementById("submit").addEventListener("click", function () {
		window.alert("이름: " + name.value + " 나이: " + age.value + " 성별: ");
	})
</script>
</html>