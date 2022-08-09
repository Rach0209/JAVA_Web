<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<% 
	// db연결
	// select
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<String> list = new ArrayList<>();
	/* preparedstatement와 statement의 차이
		동적인 파라미터 값이 있을 때, preparedstatement를 사용 할 수 있음.*/
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT name FROM country");
		
		while (rs.next()) {
			String name = rs.getString("name");
			list.add(name);
		}
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	request.setAttribute("countries", list);
	request.getRequestDispatcher("viewcountry.jsp").forward(request, response);

%>