import person.PersonValidator;

public class TestValidator {
	public static void main(String[] args) {
		PersonValidator v = new PersonValidator();
		v.isValidName("테스트");
		v.isValidName("테스트1숫자");
		v.isValidName("특수문자!@#$");
		v.isValidName("");
		v.isValidName(null);
		v.isValidName("asdfsdafasdfdsafdasfasdfasd");
		v.isValidName("공백 ");
	}
}
