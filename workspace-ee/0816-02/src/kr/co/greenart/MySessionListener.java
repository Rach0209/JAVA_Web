package kr.co.greenart;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionBindingListener, HttpSessionIdListener, HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(se.getSession().getId() + " 세션이 생성됨.");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(se.getSession().getId() + " 세션이 소멸됨.");
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		System.out.println(oldSessionId + " - 세션 아이디 변경 => " + event.getSession().getId());
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("세션 객체에 attribute가 설정되었음.");
		System.out.println(event.getName() + " : " + event.getValue());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("세션 객체에 attribute가 unbound되었음.");
		System.out.println(event.getName() + " : " + event.getValue());
	}
	
}
