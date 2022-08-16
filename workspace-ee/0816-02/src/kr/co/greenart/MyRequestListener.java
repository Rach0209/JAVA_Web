package kr.co.greenart;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("요청 객체에 attribute가 설정되었음.");
		System.out.println(srae.getName() + srae.getValue()); // 보안상의 문제가 있을 수 있으니 테스트용으로만!!!
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("사용자 요청이 발생했을 때 이벤트~");
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println(req.getRequestURI() + "를 요청하였음.");
	}
	
}
