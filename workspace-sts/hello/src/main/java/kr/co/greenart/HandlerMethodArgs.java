package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/handle")
public class HandlerMethodArgs {
//	쿠키값 보기
	@GetMapping("/cookie")
	public @ResponseBody String args(@CookieValue(name = "JSESSIONID") String jsessionid) {
		return jsessionid;
	}
	
//	헤더값 ( accept값 끌어오기 )
	@GetMapping("/header")
	public @ResponseBody String head(@RequestHeader("Accept") String accept) {
		return accept;
	}
	
//	주소 자체를 변수 처럼 사용하기.
	@GetMapping("/{path1}/{path2}")
	public @ResponseBody String paths(@PathVariable String path1, @PathVariable String path2) {
		return path1 + path2;
	}
}
