package mybeans;

import org.springframework.stereotype.Component;

// Annotation으로 Bean 설정하기.
// @Component를 적어주기.
// value = 생략가능
@Component(value = "firstComp")
public class FirstComponent {
	public void hello() {
		System.out.println("어노테이션으로 Bean 설정하기 연습~~~~!");
	}
}
