<%@page import="java.util.Random"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%
	String alphabet = request.getParameter("alphabet"); 
	// 입력값에 따라 페이지 이동
	// a페이지: 현재 서버 시간 표시
	// b페이지: 현재 서버 날짜 표시
	// c페이지: 랜덤 정수 숫자 표시
	Random random = new Random();
	int number = random.nextInt(101);
	
	if (alphabet.equals("a")) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a hh:mm:ss.SSS");
		request.setAttribute("time", LocalDateTime.now().format(formatter));
		request.getRequestDispatcher("./A.jsp").forward(request, response);
	} else if (alphabet.equals("b")) {
		request.setAttribute("date", LocalDate.now());
		request.getRequestDispatcher("./B.jsp").forward(request, response);
		 
	} else if (alphabet.equals("c")) {
		request.setAttribute("random", number);
		request.getRequestDispatcher("./C.jsp").forward(request, response);
	}
%>