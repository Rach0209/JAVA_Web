package Music.UpAndDown;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import test.crawling.Music;

public class MelonUAD {
	static LocalDateTime now = LocalDateTime.now();
	static int Now = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("yyyyMMddHH")));

	public static List<Music> MelonUad() throws IOException {
		String url1 = "https://www.melon.com/chart/index.htm?dayTime=" + Now;
		String url2 = "https://www.melon.com/chart/index.htm?dayTime=" + (Now - 1);

		Document doc1 = Jsoup.connect(url1).get();
		Document doc2 = Jsoup.connect(url2).get();

		List<Music> curList = new ArrayList<>();
		List<Music> preList = new ArrayList<>();
		List<Music> ranklist = new ArrayList<>();
//		HashMap<String, List<Music>> UADlist = new HashMap<>();

		Elements title1 = doc1.select("div.rank01>span>a");
		Elements title2 = doc2.select("div.rank01>span>a");

//		Elements updown = doc.select("div.wrap > span.rank_wrap > span:nth-child(1)");
//		Elements figure = doc.select("div.wrap > span.rank_wrap > span:nth-child(2)");
//		int rank_temp1 = 0;
//		int rank_temp2 = 0;
		
		String title_temp1;
		String title_temp2;
//		String updown_temp;

		for (int i = 0; i < 100; i++) {
			title_temp1 = title1.get(i).text();
			title_temp2 = title2.get(i).text();

			curList.add(new Music(title_temp1));
			preList.add(new Music(title_temp2));
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
			if (curList.get(i).equals(preList.get(j))) {
				if (i == j) {
					String s = "-";
					System.out.println(i + s);
					ranklist.add(new Music(i, s));
				} else if (i < j) {
					int a = j - i;
					String s = "↓";
					System.out.println(a + s);
					ranklist.add(new Music(a, s));
				} else if (i > j) {
					int a = i - j;
					String s = "↓";
					System.out.println(a + s);
					ranklist.add(new Music(a, s));
				}
			}
		}

//		switch (updown_temp) {
//		case "순위 동일": {
//			updown_temp = "-";
//			figure_temp = "";
//			break;
//		}
//		case "단계 상승": {
//			updown_temp = "↑";
//			break;
//		}
//		case "단계 하락": {
//			updown_temp = "↓";
//			break;
//		}
//		case "순위 진입": {
//			updown_temp = "new";
//			break;
//		} 
//
//		}
		}
		return ranklist;

	}

	public static void main(String[] args) {
		MelonUAD m = new MelonUAD();
		try {
			System.out.println(m.MelonUad());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}