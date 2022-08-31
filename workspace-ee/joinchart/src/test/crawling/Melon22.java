package test.crawling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Melon22 {
	static LocalDateTime now = LocalDateTime.now();
	static DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("YYYYMMdd");
	static DateTimeFormatter hourformatter = DateTimeFormatter.ofPattern("HH");
	static String date = now.format(dateformatter);
	static String hour = now.format(hourformatter);
	static int hourCount = 0;
	static List<String> melonHourList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		List<List<String>> melonGraph = new ArrayList<>();
		// 시간별 순위를 담은 리스트
		List<Graph> graphList = new ArrayList<Graph>();

		for (int i = 0; i <= Integer.valueOf(hour); i++) {
			List<String> melonHourRank = new ArrayList<>();
			String hourCount2;

			if (hourCount < 10) {
				hourCount2 = "0" + String.valueOf(hourCount);
				melonHourList.add(hourCount2);
			} else if (hourCount == 0) {
				hourCount2 = "00";
				melonHourList.add(hourCount2);
			} else {
				hourCount2 = String.valueOf(hourCount);
				melonHourList.add(hourCount2);
			}
			hourCount++;

			String url = "https://www.melon.com/chart/index.htm?dayTime=" + date + hourCount2;
			Document doc = Jsoup.connect(url).get();
			Elements title = doc.select("div.rank01>span>a");

			for (int j = 0; j < 100; j++) {
				String title_temp = title.get(j).text();
				melonHourRank.add(title_temp);
			}
			melonGraph.add(melonHourRank);
		}
		//타이틀로 노래명 검색
		String title = "Sparkling";
		for (int h = 0; h <= Integer.valueOf(hour); h++) {
			int count = 0;
			for (int j = 0; j < 100; j++) {
				String ss = String.valueOf((melonGraph.get(h).get(j)));
				
				if (title.equals(ss)) {
					System.out.println(h + "시 " + (j + 1) + "위 노래는 : " + ss);
					graphList.add(new Graph(h, String.valueOf((j + 1))));
					count++;
				} else if (j == 99 && count == 0){
					graphList.add(new Graph(h, "-"));
					System.out.println(h + "시 에는 차트에 들지 못한 노래입니다.");
				}
			}
		}
		System.out.println(graphList);
	}
	
	public static List<List<Integer>> melonRank() throws IOException {
		List<List<Integer>> melonGraph2 = new ArrayList<>();
		List<Integer> melonHourRank = new ArrayList<>();
		for (int j = 0; j < 100; j++) {
			int rank = j + 1;
			melonHourRank.add(rank);
		}
		melonGraph2.add(melonHourRank);
		return melonGraph2;
	}

	public static List<String> melonHour() throws IOException {
		return melonHourList;
	}
}