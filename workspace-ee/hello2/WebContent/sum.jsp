<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
/* 선언부. 메소드 정의 표현만 가능하다. */
	public int getSum(int lastNumber) {
		int sum = 0;
		for (int i = 0; i <= lastNumber; i++) {
			sum += i;
		}
		return sum;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>jsp scriptlet을 활용한 합계 구하기</p>
	<%
		// 메소드를 미리 정의해놓고 호출하는 방식으로 사용 할 수 있다. %!를 사용하면 선언부를 만들 수 있다! 3번째 라인 참고.
	int sum = 0;
	for (int i = 0; i <= 10; i++) {
		sum += i;
	}
	%>
	<p>
		0부터 10까지 더한 합계 =
		<%=sum%></p>
	<p><%=1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10%></p>
	<!-- 메소드 호출해서 사용해보기 -->
	<p>0 ~ 100 까지의 합 : <%= getSum(100) %></p>
	<p><%="문자열값"%></p>
	<p><%=true%></p>
	<!-- 굳이 이렇게 할 필요 없음. 그냥 적으면 됨~ -->
	<p>123.456</p>

</body>
</html>