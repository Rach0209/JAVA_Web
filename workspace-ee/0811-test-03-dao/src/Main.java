import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String line = "This is a book.";
		// 패턴 객체.
		// 정규표현식 하나를 표현하는 객체..?
		Pattern p = Pattern.compile("is");
		// 매쳐는 패턴 객체로 생성할 수 있다.
		// 검사 하고자 하는 문장을 넣어준다.
		Matcher m = p.matcher(line);
		
		// lookingAt() => 시작 부분이 같은가 확인한다.
		// 시작 일치할 때 true
//		System.out.println(m.lookingAt());
		
		// Matcher가 찾고 표시를 하고 있다.
		boolean find = m.find();
//		System.out.println(find);
		if (find) {
			System.out.println(m.start()); // 일치되는 위치의 인덱스
			System.out.println(m.end()); // 마지막으로 일치되는 위치의 인덱스 + 1
		}
		
		find = m.find();
		if (find) {
			System.out.println(m.start()); 
			System.out.println(m.end()); 
		}
		
		find = m.find();
		if (!find) {
			System.out.println("없음"); 
		}
	}

}
