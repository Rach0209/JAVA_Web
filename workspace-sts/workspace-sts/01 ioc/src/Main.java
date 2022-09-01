import mybeans.MyBean;
import mybeans.MyLogic;

public class Main {
	public static void main(String[] args) {
//		기존의 방식. 객체 생성후, 메소드 불러오기. 직접 객체관리.
		MyBean obj = new MyBean();
		obj.hello();
		
//		설정하기 전에 실행하면, NullPointerException 발생
		MyLogic logic = new MyLogic(new MyBean());
		logic.someMethod();
	}
}
