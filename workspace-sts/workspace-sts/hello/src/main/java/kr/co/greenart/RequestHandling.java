package kr.co.greenart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);
	
	@RequestMapping(value = "/req", method = RequestMethod.GET)        
//	Spring에서 Attribute 값들을 관리해주는 객체 => Model.
	public String req(@RequestParam int param, @RequestParam int param2, Model model) {
//	public String req(HttpServletRequest request) {
////		요청을 살펴보고 싶을 때, 요청을 파라미터값에 넣어줌.
//		String param = request.getParameter("param");
//		String param2 = request.getParameter("param2");
//		http://localhost:8080/greenart/req?param=vvv
//		URL에서 & 값 나타내기 => %26
//		logger로 값 확인하기.
//		logger.info(param);
		
//		두개의 요청 파라미터 값을 연산하기.
//		http://localhost:8080/greenart/req?param=25&param2=30
		logger.info(String.valueOf(param + param2));
//		INFO : kr.co.greenart.RequestHandling - 55 를 반환해줌
		
//		Attribute값을 심어주기.
		model.addAttribute("result", param + param2);
//		URL주소창에 http://localhost:8080/greenart/req?param=535235&param2=343 입력하면
//		plusresult.jsp 화면으로 넘어가서 덧셈 결과를 준다. 535578
		
		
		return "plusresult";
	}
}
