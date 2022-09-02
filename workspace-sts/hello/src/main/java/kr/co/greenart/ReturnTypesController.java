package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypesController {
	@GetMapping("/viewname")
	public String viewname() {
		return "hello";
	}
	
	@GetMapping("/respbody")
	public @ResponseBody String body() {
		return "body 내용";
	}
	
	@GetMapping("/mv")
	public ModelAndView mv() {
		ModelAndView mv = new ModelAndView(); // 직접 생성해도 됨. or 파라미터에 ModelAndView mv
		mv.addObject("result", "모델앤뷰 객체로 설정"); // ModelAndView는 객체의 형태로 반환해준다
		mv.setViewName("plusresult"); // view 이름 설정
		return mv;
	}
	
	@GetMapping("/respentity")
	public ResponseEntity<String> entity() {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8").body("바디ㅣㅣㅣㅣ 내    용");
//		String body = "바디 내용입니다";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/pain; charset=utf-8");
//		ResponseEntity<String> en = new ResponseEntity<>(body, headers, HttpStatus.OK);
//		return en;
	}
	
	@GetMapping("/red")
	public String redirect() {
		return "redirect:/";
	}
}
