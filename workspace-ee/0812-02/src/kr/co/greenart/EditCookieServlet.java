package kr.co.greenart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//쿠키의 삭제 개념 : 기간이 만료 되었을 때, 삭제됨.
@WebServlet("/editcookie")
public class EditCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c = new Cookie("yourname", "edit");
		resp.addCookie(c);
		Cookie c2 = new Cookie("korname", "");
		c2.setMaxAge(0); // 만료 기간을 초 단위로 설정 해줄 수 있다. 3600 : 한시간.
		
		resp.addCookie(c2);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
