package kr.co.greenart;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginservice")
public class loginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		if (password != null && password.equals("qwer")) {
			// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("loginid", id);
		} else {
			// 로그인 실패
			
		}
		req.getRequestDispatcher("./loginresult.jsp").forward(req, resp);
	}
}
