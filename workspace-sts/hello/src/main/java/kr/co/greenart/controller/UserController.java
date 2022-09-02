package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.greenart.model.User;
import kr.co.greenart.model.UserService;

// 사용자의 정보를 입력 받아서 확인하기

// UserValidator를 Bean으로 등록해서 @Autowired를 사용해서 쓰기~
@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class); 
	
//	@Autowired
//	private UserValidator validator;
	
	@Autowired
	private UserService service;
	
//	annotation으로 모델 어트리뷰트를 설정함.
	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 1);
	}
	
	@GetMapping("/user")
	public String userForm(@ModelAttribute("user") User user) { // (Model model) @ModelAttribute설정을 해서 쓸 필요가 없어짐.
//		new User("기본값", 1)의 파라미터 안에 값을 넣으면 그 값이 그대로 연결되어 userForm.jsp로 전달(f:input 태그의 path:값)된다.
//		model.addAttribute("user", new User("기본값", 1)); // @ModelAttribute설정을 해서 쓸 필요가 없어짐.
		return "userForm";
	}
	
//	표현할 수 있는 클래스만 잘 만들어 놓으면, 입력값을 바인딩해서 사용할 수 있다.
//	입력에 대한 유효값이 없어서 만들어 주어야 한다. => @ModelAttribute사용하고, 유효값을 확인할 수 있는 객체를 만듦 : UserValidator.java
//	errors라는 객체를 달라고 요청하는 BindingResult. 
//	BindingResult는 Errors를 상속하고 있다.
//	@Valid Annotation으로 유효성 검사.
	@PostMapping("/user")
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {
		logger.info("입력 정보: " + user.toString());
		
//		validator.validate(user, errors);
//		hasErrors()는 하나라도 에러가 있다면 'true' 리턴.
		if (errors.hasErrors()) {
			logger.info(user.toString());
//			다시 입력 폼으로 보내기
			return "userForm";
		}
		service.add(user);
//		목록으로 바로 갈 수 있게끔 리다이렉트를 값을 설정해줌.
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "userlist";
	}
}