import java.util.List;

import human.Human;
import human.HumanDAO;

public class TestDao {
	public static void main(String[] args) {
		HumanDAO dao = new HumanDAO();
		
		try {
			int result = dao.registHuman("adsf", "dddd", 10);
			System.out.println(result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		List<Human> list = null;
		try {
			list = dao.getHumanList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}
