package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// "/print" GET 요청 -> text 입력 가능 form으로 forward
// form.jsp submit시 
// "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward


@Controller
@RequestMapping(value = "/print") // value 값이 같을 때, 클래스 위에 선언해주면 value값을 동일하게 할 수 있고, method방식 처리에 맞춰 따라감.
public class PrintController {
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "form";
	}
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String print(@RequestParam String text, Model model) {
		model.addAttribute("print", text);
		return "print";
	}
}
