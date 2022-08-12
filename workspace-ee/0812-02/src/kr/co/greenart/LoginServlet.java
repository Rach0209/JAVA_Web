package kr.co.greenart;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet은 Login페이지로 보내버리기.
		response.sendRedirect(request.getContextPath() + "/idremember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");
		Cookie[] cookies = request.getCookies();
	      if (cookies != null) {
	         for(Cookie c : cookies){
	            if(c.getName().equals("rememberme") && c.getValue().equals(id)){
	               request.getRequestDispatcher("./testlogin.jsp").forward(request, response);
	            }
	         }
	      } else {
	    	  if (password.equals("1234")) {
	    		  // 로그인 성공
	    		  // 쿠키(아이디)를 담은 성공메세지 응답
	    		  if (rememberme != null && rememberme.equals("on")) {
	    			  // Chrome은 자동으로 URL인코딩 처리를 해줌.
	    			  Cookie c = new Cookie("rememberme", URLEncoder.encode(id, "utf-8"));
	    			  
	    			  c.setMaxAge(60 * 60 * 24); // 기간 : 하루로 설정
	    			  
	    			  response.addCookie(c);
	    		  }
	    		  request.getRequestDispatcher("ok.jsp").forward(request, response);
	    	  } else {
	    		  // 실패
	    		  
	    	  }
	      }
		
	}

}
