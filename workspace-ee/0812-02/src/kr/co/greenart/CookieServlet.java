package kr.co.greenart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makecookie")
public class CookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("yourname", "chunsik");
		Cookie c2 = new Cookie("korname", "춘식이");
		response.addCookie(c);
		response.addCookie(c2);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println("쿠키를 심었으니 브라우저를 살펴보렴");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
