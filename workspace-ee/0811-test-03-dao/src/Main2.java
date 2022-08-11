import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

	public static void main(String[] args) {
		String line = "19 He28llo. 37 Wor4ld! 5";
		
		// 정규식 표현 [0-9]
		// [] 안에 문자에 대한 범위를 설정할 수 있다.
		// 하나씩 찾아감.
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(line);
		
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		m.find();
		System.out.println(m.start());
		
	}

}
