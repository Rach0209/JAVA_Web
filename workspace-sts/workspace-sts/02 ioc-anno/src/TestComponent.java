import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.FirstComponent;
import mybeans.SecondComponent;
import mybeans.ThirdComponent;

public class TestComponent {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
		System.out.println("3. ThirdComponent Test");
//		3. ThirdComponent Test
		ThirdComponent third = context.getBean(ThirdComponent.class);
		third.printValue();
		
		System.out.println();
		System.out.println("2. SecondComponent Test");
//		2. SecondComponent Test
		SecondComponent second = context.getBean(SecondComponent.class);
		System.out.println(second);
		
//		구식 방법.
//		FirstComponent comp = context.getBean(FirstComponent.class);
//		second.setNeed(comp);
//		xml에서 설정하기. context:annotation-config를 통해 의존성을 줄 수 있다.
		
		second.myServiceMethod();
		
		System.out.println();
		System.out.println("1. FirstComponent Test");
//		1. FirstComponent Test
		FirstComponent comp = context.getBean(FirstComponent.class);
		comp.hello();
		
		FirstComponent byName = context.getBean("firstComp", FirstComponent.class);
		byName.hello();
		
		System.out.println(comp == byName);
	}
}
