import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");
//		5.
//주석용	MyStatefulObj fourth = context.getBean(MyStatefulObj.class);
//		에러 발생 => 똑같은 타입 2개가 있다.(third, fourth)
//		bean에서 고유하게 준 id를 사용해 해결할 수 있음. 혹은 primary="true"값을 줌.
//		primary는 주요 bean으로 사용하겠다는 의미. "fourth"인자를 넣지 않아도 된다.
		MyStatefulObj fourth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fourth.toString()); 
		
		
//		4.
//		MyStatefulObj 테스트.
		MyStatefulObj third = context.getBean(MyStatefulObj.class);
		System.out.println(third.toString()); // 필드 값들은 기본값으로 되어있다(name=null number=0) => 기본생성자를 호출한 것.
//		myconfing.xml에 생성자의 파라미터 순서대로 값을 넣어주기.
//		<constructor-arg value="my-name"></constructor-arg>
//		<constructor-arg value="100"></constructor-arg> 
//		toSting 반환값 : MyStatefulObj [name=my-name, number=100]
		
//		상태 변화주기
		third.setName("new-name");
		third.setNumber(200);
		
		MyStatefulObj oneMoreTime = context.getBean(MyStatefulObj.class);
		System.out.println(oneMoreTime.toString());
//		third 와 oneMoreTime은 같은 참조다. 
//		Singleton pattern (싱글턴 패턴)이 적용되어있음. => 객체의 인스턴스가 오직 1개만 생성되는 패턴을 의미한다.
		System.out.println(third == oneMoreTime);
//		<bean class="mybeans.MyStatefulObj" id="third" scope="prototype">
//		scope="prototype" attribute를 추가해주면 실행값이 달라진다. 참조가 달라짐.=> 싱글턴 패턴 X
//		달라고 할때마다 new를 해서(인스턴스) 새롭게 만들어 준다. => IOC 관리대상에서 제외됨.(달라 할때마다 만들어주기때문에 개발자가 직접 관리해야함)
		
		
//		3.
//		MyLogic 테스트. myconfig.xml에 bean 등록.
		MyLogic logic = context.getBean(MyLogic.class);
		logic.someMethod();
		
		
//		2.
//		MyBean 테스트.
		MyBean b = context.getBean(MyBean.class);
//		new로 인스턴스를 만들지 않았지만, Spring에서 객체를 관리하여 바로 실행함.
//		MyBean.class 타입으로만 접근이 가능함.
		b.hello();
		
		
//		1.
//		myconfig.xml에서 설정한 Attribute의 id로도 불러 올 수 있다.
//		기본적으로 Object형태로 반환.
//		MyBean b2 = (MyBean) context.getBean("first"); -> 오브젝트 형태반환
		
//		파라미터 인자로 MyBean.class를 써주면 Object에서 MyBean.class타입으로 다운캐스팅 됨.
		MyBean b2 = context.getBean("first", MyBean.class);
		
		b2.hello();
		
//		참조가 같은지 확인. 참조가 같다면 하나만 받기위함.
		System.out.println(b == b2);
	}
}
