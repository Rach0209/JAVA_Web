package human;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String lastName = req.getParameter("lastName");
		String firstName = req.getParameter("firstName");
		int age = Integer.valueOf(req.getParameter("age"));
		System.out.println(lastName);
		System.out.println(firstName);
		System.out.println(age);
		
		try {
			HumanDAO dao = new HumanDAO();
			dao.registHuman(lastName, firstName, age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("./humanlist");
	}
}
