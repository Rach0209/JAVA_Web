package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
//	사용자가 주소값으로"/hello"를 입력했을 때,
//	문자열 반환 메소드 만들기

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	get방식 요청하면 실행된다.
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String hi() {
		return "hello";
	}
}
