package hello;

import java.awt.Window;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.Person;
import person.PersonDAO;
import person.PersonValidator;

public class PersonServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 깨짐 방지 (form method를 post로 받을 때)
		req.setCharacterEncoding("utf-8");

		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String age = req.getParameter("age");
		String email = req.getParameter("email");

		// 유효한 입력값 받기.
		PersonValidator validator = new PersonValidator();
		Map<String, String> errors = new HashMap<String, String>();
		errors.putAll(validator.isValidName(firstName));
		errors.putAll(validator.isValidName(lastName));
		errors.putAll(validator.isValidAge(age));
		errors.putAll(validator.isValidEmail(email));

		if (errors.size() > 0) {
			// 그러면 잘못된 값일 때 사용자에게 뭐라고 알려줌????
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("form.jsp").forward(req, resp);
		} else {

			PersonDAO dao = new PersonDAO();
			try {
				dao.insert(new Person(firstName, lastName, Integer.valueOf(age), email));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// 나중에 목록 페이지로 보낼 거임~;
			resp.sendRedirect(req.getContextPath() + "/list");
		}
	}
}
