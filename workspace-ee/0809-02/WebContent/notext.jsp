<% 
	int result = 1 + 1;
	request.setAttribute("result", result);
	// 두 페이지의 흐름을 하나로 합치기.
	// redirect는 페이지 이름이 바뀌었지만 이건 그대로 유지
	// 여기에서 바로 WEB-INF안의 viewPage를 요청시켜놓으면, 흐름이 전달된다.
	// 하지만 사용자가 viewPage.jsp를 바로 요청 할 수 없게 막을 수 있다.
	request.getRequestDispatcher("/WEB-INF/viewPage.jsp").forward(request, response);
%>