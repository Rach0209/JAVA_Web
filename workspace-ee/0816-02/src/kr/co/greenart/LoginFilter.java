package kr.co.greenart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	// javax.servlet의 인터페이스인 Filter를 implements해줌.
	// filter의 흐름을 확인하기!!!
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 서블릿이 요청 객체를 다루기전
		System.out.println("doFilter 전!!~");
		
		// doFilter위에서 문장을 적으면, Servlet이 전달 받기 전.
		// 원래 흐름을 그대로 이어가게끔. 해주는 chain.doFilter
		// 원래의 서블릿인 BoardServlet으로 이동한다
		System.out.println("세션 값을 확인합니다.");
		// 자식으로 형변환 해주어야 함.
		HttpSession session = ((HttpServletRequest) req).getSession();
		Object loginid = session.getAttribute("loginid");
		
		if (loginid != null) {
		chain.doFilter(req, resp);
		} else {
			System.out.println("로그인 되지 않은 유저.");

			((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED);// 응답코드 401. -> 인증이 되지 않았을 때, 응답으로 보내줄 수 있는 코드
//			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// setStatus를 해주면, forward를 해주어야 연결이 됨. 
//			setStatus는 코드에러는 나타내지만 이동은 발동되지않는다고 설명되어있음.
//			req.getRequestDispatcher("./needlogin.jsp").forward(req, resp);
		}
		
		// 서블릿이 요청을 처리하고 응답 보내기 전
		System.out.println("doFilter 후!!");
		
	}
	
}
