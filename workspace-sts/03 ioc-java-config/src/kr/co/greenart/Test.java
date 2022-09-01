package kr.co.greenart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
//		3. 
//		ApplicationContext context = new ClassPathXmlApplicationContext("component-scan.xml");
//		component-scan.xml파일을 지우고, Annotationc component설정으로 불러오기 
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		MyConfig config = context.getBean(MyConfig.class);
		
		System.out.println("List : " + config.myList());
		System.out.println("Set : " + config.mySet());
		
//		1.
//		MyDataRepository repo = context.getBean("myset", MyDataRepository.class);
//		
////		구현체가 2개이상일 때, 찾지못해서 예외를 던져준다.
////		@Primary 또는 id값으로 찾아주면 된다.
//		System.out.println(repo.getMyNumbers());
		
//		2.
		MyService service = context.getBean(MyService.class);
		System.out.println(service.numberService()); // 변함없이 잘됨.
	}
}
