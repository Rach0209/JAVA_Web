import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
	public static void main(String[] args) {
		String line = " (abc, 123) | (de, 6) | (qwer, 15)";
		// \\( => 문자열인 괄호 ( 를 나타내려고 적음.
		// ([a-zA-Z]+) => 하나의 그룹으로 만들어줌.
		Pattern p = Pattern.compile("\\(([a-zA-Z]+), ([0-9]+)\\)");
		Matcher m = p.matcher(line);
		
		while (m.find()) {
			// 그룹 문자열에 대한 값을 찾아줌.	([a-zA-Z]+) => 소문자 a~z와 대문자 A~Z가 1자 이상인 문자열이 한 그룹.		
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
	}
}
