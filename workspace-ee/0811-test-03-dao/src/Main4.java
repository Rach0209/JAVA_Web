import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
	public static void main(String[] args) {
		String line1 = "lowercase";
		String line2 = "UPPERCASE";
		String line3 = "1q2w3e";

//		// 문자에 대한 범위 소문자 a~z의 문자가 9개인 패턴!
//		Pattern p = Pattern.compile("[a-z]{9}");
//		Matcher m = p.matcher(line1);
//		
//		Pattern p2 = Pattern.compile("[A-Z]{9}");
//		Matcher m2 = p2.matcher(line2);
//		// matches() => 해당 정규 표현식과 비교하는 문자열의 표현이 일치 할 때 true
//		System.out.println(m.matches());
//		System.out.println(m2.matches());
//
//		Pattern p = Pattern.compile("[0-9a-z]{6}");
//		Matcher m = p.matcher(line3);
//		System.out.println(m.matches());

		// 아이디는 영소문자 또는 숫자로 이루어져야하고 최소 6자, 최대 10자임 (영문자로 시작해야합니다.)
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		String id = scan.nextLine();
		Pattern p = Pattern.compile("[a-z][a-z0-9]{5,9}");
		Matcher m = p.matcher(id);
		if (!m.matches()) {
			System.out.println("올바르지 않은 입력값입니다.");
		} else {
			System.out.println("올바른 아이디군요 잘했어요^-^");
		}

		// 올바른 전화번호 (010-####-####)
		boolean phone = true;
		while (phone) {
			System.out.println("전화번호를 입력하세요");
			String phoneNumber = scan.nextLine();
			Pattern p2 = Pattern.compile("010-[0-9]{4}-[0-9]{4}");
			Matcher m2 = p2.matcher(phoneNumber);
			if (m2.matches()) {
				System.out.println("감사");
				phone = false;
			} else {
				System.out.println("전화번호는 010-####-####형식으로 입력해주세요.");
			}
		}

	}
}
