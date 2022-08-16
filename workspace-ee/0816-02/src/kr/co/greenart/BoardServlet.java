package kr.co.greenart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 GET방식의 요청을 하였습니다. (게시판 목록)");

		System.out.println("로그인 확인 되었습니다.");
		List<String> articles = new ArrayList<>(Arrays.asList("글1", "글2", "글3"));
		req.setAttribute("articles", articles);

		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);

	}

}
