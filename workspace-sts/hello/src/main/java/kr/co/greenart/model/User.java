package kr.co.greenart.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class User {
//	@NotBlank = 값이 없거나 공백으로만 이루어져 있을 때 에러발생.
//	@Size = 문자열값의 길이
	@NotBlank(message = "이름을 입력해주세요")
	@Size(min = 1, max = 4, message = "이름은 1 ~ 4자 사이여야합니다.")
	private String name;
//	@Positive = 양수만
//	@Max = 최대값
	@Positive(message = "양수를 입력해주세요")
	@Max(value = 100, message = "최대값(100)을 초과했습니다.")
	private int age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
