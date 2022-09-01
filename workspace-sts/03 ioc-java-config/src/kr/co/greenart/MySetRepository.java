package kr.co.greenart;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 이름만 변경 해줌으로 쉽게 알아볼 수 있다.
@Repository("myset") 
//@Primary
public class MySetRepository implements MyDataRepository {
	@Autowired
	private Set<Integer> set;
	@Override
	public Iterable<Integer> getMyNumbers() {
//		Set<Integer> set = new HashSet<>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		set.add(5);
		return set;
	}
}
