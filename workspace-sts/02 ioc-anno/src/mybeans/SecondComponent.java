package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
//	필드 위에 @Autowired 선언해주면 알아서 찾아줌. -> 해당 타입의 Bean을 찾아간다.
	@Autowired
	private FirstComponent need;
	
//	의존성을 위해 생성자 or 세터 만들기
//	생성자 or 세터를 xml을 통해 annotation에 의존성 넣기 @Autowired 설정. 여러번 적어도 됨.
//	Bean은 타입을 통해서 가져올 수 있다.(FirstComponent need)
//	@Autowired
	public SecondComponent(FirstComponent need) {
		super();
		this.need = need;
	}
	
//	@Autowired
	public void setNeed(FirstComponent need) {
		this.need = need;
	}

	public void myServiceMethod() {
		System.out.println("의존성이 필요함.! @Autowired로 의존성을 주었다!");
		need.hello();
	}
}
