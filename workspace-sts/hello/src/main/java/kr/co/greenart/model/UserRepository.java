package kr.co.greenart.model;

import java.util.List;

public interface UserRepository {
	public int add(User user);
	public List<User> list();
}
