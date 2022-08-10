package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	// 필드(상태값)을 가지게 되면 여러 명의 사용자가 Servlet에 접속 했을 때, 상태값을 확인하기가 어렵다. 사용자마다 상태값이 바뀌기 때문이다.!!!!!
	// 상태값을 주고 Servlet을 만들면 이용에 매우 큰 어려움이 생김.
	private int some = 10;
	
	public HelloServlet() {
		super();
		System.out.println("헬로 서블릿 생성자는 언제 호출되나요?!");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// hello.jsp와는 다른 hello 입니다.!!!!!! web.xml에서 hello주소를 주고 그걸 찾아 오는데 매핑된것을 알아채고 연결해준것임~
		// 이 servlet은 자바 클래스이기 때문에, 주소를 하나 만들어 줘서 접근이 가능하게 만든 것. 
		//JSP나 Servlet이나 결국엔 똑같다. => class화 되고 instance화 되어 결국 html로 사용자에게 정보를 전달한다.
		some++;
		PrintWriter pw = resp.getWriter();
		pw.println(req.getRequestURI());
		pw.flush();
		System.out.println("필드값: " + some);
	}
	
}
