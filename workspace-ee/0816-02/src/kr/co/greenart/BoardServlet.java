package kr.co.greenart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private final static Logger logger = LoggerFactory.getLogger(BoardServlet.class);
	
	private BoardService service; // 객체 의존성... servlet은 service가 필요, service는 DAO가 필요..
	
	
	// BoardService에서 DAO 생성자 만들어주기
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new BoardService(new BoardDAO());
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("사용자가 GET방식의 요청을 하였습니다. (게시판 목록)");
//		System.out.println();보다 log를 선호해서 사용하기!!!@#!@#@!#@!#!#
		logger.info("logger를 통해 메세지를 남깁니다.");
		logger.info("사용자가 게시판 목록을 요청하였습니다.(게시판목록)");
		// slf4j - FATAL / ERROR / WARN / INFO / DEBUG
		
		System.out.println("로그인 확인 되었습니다.");
		List<BoardArticle> articles = service.게시글목록보기서비스();
		req.setAttribute("articles", articles);

		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);

	}

}
