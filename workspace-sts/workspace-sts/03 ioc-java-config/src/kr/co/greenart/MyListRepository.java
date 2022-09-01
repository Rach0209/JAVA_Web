package kr.co.greenart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mylist")
public class MyListRepository implements MyDataRepository {
	@Autowired
	private List<Integer> list;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		return list;
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		
////		Iterator 사용하는거 까먹지 말기~
////		Iterator<Integer> iter = list.iterator();
////		while(iter.hasNext()) {
////			iter.next();
////		}
//		
//		return list;
	}
}
