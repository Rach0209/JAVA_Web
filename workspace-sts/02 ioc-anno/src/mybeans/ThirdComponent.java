package mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // (value = "prototype") 상수로 정의되어 있음.
@Primary
public class ThirdComponent {
	private String value;
	private int num;
//	특정 값을 집어 넣는 @Value 어노테이션 (property 'value ='는 생략 가능.)
	public ThirdComponent(@Value(value = "vvvv") String value, @Value("100") int num) {
		this.value = value;
		this.num = num;
	}
	
	public void printValue() {
		System.out.println(value);
		System.out.println(num);
	}
}
