package human;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class humanListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HumanDAO dao = new HumanDAO();
		List<Human> list = null;
			try {
				list = dao.getHumanList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("./humanList.jsp").forward(req, resp);
	}
}
