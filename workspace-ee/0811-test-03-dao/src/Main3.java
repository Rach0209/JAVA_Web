import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
	public static void main(String[] args) {
		String line = "193 He282llo. 37 Wor64ld! 54";
		
		// {길이값} 중괄호는 길이값을 줄 수 있다. 범위도 가능.{최소길이, 최대길이} 중괄호 안에 공백(띄어쓰기) 불가.
		Pattern p = Pattern.compile("[0-9]{2,3}");
		Matcher m = p.matcher(line);
		
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
		
		m.find();
		System.out.println(m.start());
		System.out.println(m.end());
	}
}
