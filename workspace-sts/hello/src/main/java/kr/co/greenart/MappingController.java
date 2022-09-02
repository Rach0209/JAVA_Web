package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
//	인코딩 오류; => @ResponseBody에서 바디를 만들어주는데 HttpServletResponse 에서 설정해도 되지만 'produces'를 사용하면 간편.
	@GetMapping(value = "/??.two", produces = "text/plain; charset=utf-8")
	public @ResponseBody String two() { // 파라미터에 HttpServletResponse resp 주고,
//		resp.setContentType("text/plain", "charset=utf-8"); 설정해도 됨.
		return "두글자 매핑";
	}
	
	@GetMapping("/*.do")
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}
	
//	http://localhost:8080/greenart/mapping/ppp?com= 하면 화면이 나옴
//	'com' 이라는 파라미터가 존재해야 실행
//	'!com' 을 넣으면 부정표현, 'com' 파라미터가 없어야 실행된다.
	@GetMapping(value = "/ppp", params = "com")
//	@GetMapping(value = "/ppp", params = "!com")
	public @ResponseBody String ppp(@RequestParam(defaultValue = "default") String com) {
		return "com";
	}
	
	
}
