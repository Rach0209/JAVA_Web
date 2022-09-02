package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml을 삭제하고 만든 클래스
// Component인데 설정을 가지고 있는 Component. xml에서 했던 설정들을 해줄 수 있다.
@Configuration
@ComponentScan(value = "kr.co.greenart") // xml에서 base-package=값임. 
public class MyConfig {
//	리턴 타입에 등록하고자 하는 Bean의 타입을 적어주고, id(빈의 이름)를 메소드 이름으로 적어준다.
	@Bean
	public List<Integer> myList() {
		return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
	}  
	
	@Bean
	public Set<Integer> mySet() {
		return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
	}
}
