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
	<!-- form에 메소드를 줄 수 있는데, 기본값은 get이다.
	get 방식은 기본적으로 body가 없고, 사용자의 요청쿼리파라미터가 주소에 표현된다. ==> 사용자에게 노출된다. 
	post 방식 URL에 노출되지 않고, 전송방식은 post로 변경된다. URL은 한글을 표현할 수 없기 때문에, 눈에보여도 실제로는 한글이 아니다.
	크롬에서 URL에 한글이 나타나는 이유는 크롬이 해석해서 나타내주기 때문.
	URL Encoding 이라는 작업을 통해서 한글을 주소표현에 한글정보를 담을 수 있게끔 변환하는 작업을 해준다.
	원래 문자로 돌아갈 수 있게끔, -Decoding- 작업을 해주면, 다시 한글을 나타낼 수 있는데, encoding과 decoding은 똑같은 방법으로
	실행이 되어야 한다. (예; '가 => %a' 면 '%a => 가' 로 바꿔줘야함)
	Decoding은 정보를 살펴보는 request 페이지에서 해준다.
	-->
	
	<form action="/baek/requestInfo.jsp" method="post" >
		<label>이름<input id="name" name="name" type="text" placeholder="이름 입력" /></label>
		<label>나이<input id="age" name="age" type="text" placeholder="나이 입력" /></label>
		<label><input name="gender" type="radio" value="Male" />Male</label>
		<label><input class="gender" name="gender" type="radio" value="Female" />Female</label>
		<label><input type="checkbox" name="hobby" value="java" />자바</label>
		<label><input type="checkbox" name="hobby" value="html" />하이퍼 텍스트 마크업 랭귀지</label>
		<label><input type="checkbox" name="hobby" value="css" />캐스캐이딩 스타일 시트</label>
		<label><input type="checkbox" name="hobby" value="javascript" />자바스크립트</label>
		<label><input id="submit" type="submit" value="입력 완료" /></label>
	</form>
</body>
<script type="text/javascript">
	let name = document.getElementById("name");
	let age = document.getElementById("age");
	document.getElementById("submit").addEventListener("click", function () {
		window.alert("이름: " + name.value + " 나이: " + age.value);
	})
</script>
</html>