package human;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HumanDAO {
	public List<Human> getHumanList() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Human> list = new ArrayList<>();
		
		// try (여기) {} <<< 괄호 안에 resource를 적어 주면, try문이 끝나면 사라진다.
		// 외부자원인 connection이나 statement 등을 넣을 수 있다.
		try {
			String query = "SELECT * FROM human";
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int age = rs.getInt("age");
				list.add(new Human(lastName, firstName, age));
			}
			
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	public int registHuman(String lastName, String firstName, int age) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "INSERT INTO human (lastName, firstName, age) VALUES (?, ?, ?)";
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setInt(3, age);
			
			return pstmt.executeUpdate(); 
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
