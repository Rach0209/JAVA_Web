import java.util.regex.Pattern;

class Main5 {
	public static void main(String[] args) {
		// '{3,}'3자 이상 '{1,}' 1자 이상 '{0,}' 없어도됨.
		// + 1 1자이거나 이상(영문자로 이루어진것이면 true)
		// ? 0 이거나 1
		// * 0 이상
		
		// \w 문자
		// \d 숫자
		// \s 공백
		
		Pattern p = Pattern.compile("\\w?");
		Pattern p2 = Pattern.compile("\\d?");
	}
}
