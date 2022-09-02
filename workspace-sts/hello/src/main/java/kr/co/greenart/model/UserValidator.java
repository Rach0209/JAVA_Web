package kr.co.greenart.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Spring에서 지원해주는 유효값 검사용 인터페이스

// Bean으로 등록해서 사용할 수 있게 하기.
@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

//	Errors에 메세지를 줄 것임. 오류에 대한 정보.
//	
	@Override
	public void validate(Object target, Errors errors) {
//		ValidationUtils 안에 static 한 메소드가 존재한다.
//		비어있거나 공백체크(space로만 되어있는 것)하는 메소드.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요");
		
		User user = (User) target;
		if (user.getName().length() > 5) {
//			필드 이름을 적어주어야 path에서 가져 올 수 있음. errorCode는 임의로 적어주면 됨.
			errors.rejectValue("name", "name.toolong", "이름이 너무 깁니다");
		}
		if (user.getAge() > 200) {
			errors.rejectValue("age", "age.tooold", "나이 범위를 초과했습니다");
		}
	}
}
