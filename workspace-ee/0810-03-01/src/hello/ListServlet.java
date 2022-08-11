package hello;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.Person;
import person.PersonDAO;

public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonDAO dao = new PersonDAO();
		List<Person> list;
		try {
			list = dao.selectAll();
			req.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("list.jsp")
			.forward(req, resp);
	}
}
