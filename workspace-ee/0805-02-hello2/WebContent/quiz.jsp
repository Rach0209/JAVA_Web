<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {
	width: 300px;
	height: 300px;
}

div {
	display: none;
}

.on {
	display: block;
}
</style>
</head>
<body>
	<!-- action 속성 값을 설정하여
		submit 버튼을 누르면
		입력값을 처리할 수 있는 페이지(jsp)로 요청(이동)
		사용자 입력을 받을 수 있는 form을 구성하세요 
	-->
	<p>다음 문제의 답을 입력하세요.</p>
	<p>문제 : 인터라켄에 위치한 Top of Europe이라 불리는 산은?
	<form action="/baek/requestQuiz.jsp" method="post">
		<label>답 : <input name="answer" type="text" /></label> <label><input
			type="submit" /></label>
	</form>
	<p></p>
	<label><button id="hint">힌트</button></label>
	<div id="imageDiv">
		<img alt="산"
			src="https://cdn.san.chosun.com/news/photo/201906/12836_53967_97.jpg">
	</div>
</body>
<script type="text/javascript">
	let hint = document.getElementById("hint");
	hint.addEventListener("click", function() {
		document.getElementById("imageDiv").classList.toggle("on");
	});
</script>
</html>