package test.crawling;

import java.io.IOException;
import java.util.List;

public class Paging {
	
	public static List<Music> Paging(List<Music> musicList, int i) {
		int startIdx = ((i - 1) * 10);
		int endIdx = i * 10;
		List<Music> list = musicList.subList(startIdx, endIdx);

		return list;
	}

	public static void main(String[] args) {
		try {
			List<Music> list = Paging(Melon.crawlingMelon(), 8);
			for (Music m : list) {
				System.out.println(m);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
