package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // 부가 설명을 위해 Component 이름만 변경 
public class MyService {
	@Autowired
	@Qualifier("mylist") // id값을 주고 해당하는 객체의 이름(Bean으로 등록할 때의 이름)으로서 주입할 때.
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
