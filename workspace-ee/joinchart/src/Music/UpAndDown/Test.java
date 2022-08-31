package Music.UpAndDown;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import test.crawling.Music;

public class Test {
	static LocalDateTime now = LocalDateTime.now();
	static int Now = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("yyyyMMddHH")));
	static int b1 = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
	static int b2 = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("HH")));

	public static void main(String[] args) throws IOException {
		//멜론 주소
//		String url1 = "https://www.melon.com/chart/index.htm?dayTime=" + Now;
//		String url2 = "https://www.melon.com/chart/index.htm?dayTime=" + (Now - 1);
		
		//지니
		//벅스
		String url1 = "https://music.bugs.co.kr/chart/track/realtime/total?chartdate=" + b1 + "&charthour=" + b2;
		String url2 = "https://music.bugs.co.kr/chart/track/realtime/total?chartdate=" + b1 + "&charthour=" + (b2-1);;

//		Document doc1 = Jsoup.connect(url1).get();
//		Document doc2 = Jsoup.connect(url2).get();
		Document doc1 = Jsoup.connect(url1).get();
		Document doc2 = Jsoup.connect(url2).get();

//		List<String> curList = new ArrayList<>();
//		List<String> preList = new ArrayList<>();
		Map<Integer, String> curList = new HashMap<>();
		Map<Integer, String> preList = new HashMap<>();
		Map<Integer, String> ranklist = new HashMap<>();

        // 키 값으로 오름차순 정렬
//		Elements title1 = doc1.select("div.rank01>span>a");
//		Elements title2 = doc2.select("div.rank01>span>a");
		//벅스 노래제목 값
		Elements title1 = doc1.select("tbody>tr>th>p.title>a");
		Elements title2 = doc2.select("tbody>tr>th>p.title>a");

		for (int i = 0; i < 100; i++) {
			String title_temp1 = title1.get(i).text();
			String title_temp2 = title2.get(i).text();
			curList.put(i, title_temp1);
			preList.put(i, title_temp2);
		}
		
		Object[] mapkey = curList.keySet().toArray();
		Arrays.sort(mapkey);
		Object[] mapkey2 = preList.keySet().toArray();
		Arrays.sort(mapkey2);
		
//		for (int i = 0; i < 100; i++) {
//			if (curList.get(i).equals(preList.get(i))) {
//				String s = "-";
//				ranklist.put(i, s);
//				curList.remove(i);
//				preList.remove(i);
//			}
//		}
		
			
		int i = 0;
		for (i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (curList.get(i).equals(preList.get(j))) {
					if (i == j) {
						String s = "-";
						ranklist.put(i, s);
						System.out.println((i+1) + "위" + s);
						i++;
						break;
					} else if (i < j) {
						int rankDif = j - i;
						String s = "↑";
						ranklist.put(rankDif, s);
						System.out.println((i+1)+ "위" + rankDif + s);
						i++;
					} else if (i > j) {
						int rankDif = i - j;
						String s = "↓";
						ranklist.put(rankDif, s);
						System.out.println((i+1)+ "위" + rankDif + s);
						i++;
					}
				} 
				
//				System.out.println(ranklist);
//				else if (!preList.get(i).equals(curList.get(j))){
//						String s = "New";
//						ranklist.add(new Music(0, s));
//						System.out.println((i+1)+ "위" + s);
//						break;
//				}
			}
		}
//		
//		try {
//			for (int i = 0; i < 100; i++) {
//				System.out.println(ranklist);
//			}
//	    } catch (Exception e) {
//	         e.printStackTrace();
//	    }
	}
}