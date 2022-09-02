import mybeans.MyBean;
import mybeans.MyLogic;

public class Main {
	public static void main(String[] args) {
//		기존의 방식. 객체 생성후, 메소드 불러오기. 직접 객체관리.
		MyBean obj = new MyBean();
		obj.hello();
		
//		설정하기 전에 실행하면, NullPointerException 발생
//		Spring Framework에서는 의존성의 역전을 통해 필요할때마다 설정만 해주면 사용할 수 있다.
		MyLogic logic = new MyLogic(new MyBean());
		logic.someMethod();
	}
}
