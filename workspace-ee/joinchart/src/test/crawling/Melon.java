package test.crawling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Melon {
	public static List<Music> crawlingMelon() throws IOException {
		String url = "https://www.melon.com/chart/index.htm";

		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();

		List<Music> melonlist = new ArrayList<>();

		Elements title = doc.select("div.rank01>span>a");
		Elements updown = doc.select("div.wrap > span.rank_wrap > span:nth-child(1)");
		Elements figure = doc.select("div.wrap > span.rank_wrap > span:nth-child(2)");
		Elements artist = doc.select("div.rank02>span");
		Elements album = doc.select("div.rank03>a");
		Elements albumArt = doc.select("div>a>img");

		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = title.get(i).text();
			String updown_temp = updown.get(i).text();
			String figure_temp = null;
			try {
				figure_temp = figure.get(i).text();
			} catch (IndexOutOfBoundsException e) {
				figure_temp = "";
			}
			switch (updown_temp) {
			case "순위 동일": {
				updown_temp = "-";
				figure_temp = "";
				break;
			}
			case "단계 상승": {
				updown_temp = "↑";
				break;
			}
			case "단계 하락": {
				updown_temp = "↓";
				break;
			}
			case "순위 진입": {
				updown_temp = "new";
				break;
			}
			}
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			melonlist.add(
					new Music(rank, updown_temp + figure_temp, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		return melonlist;
	}

	public static List<Graph> graphMelon(String tit) throws IOException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("YYYYMMdd");
		DateTimeFormatter hourformatter = DateTimeFormatter.ofPattern("HH");
		String date = now.format(dateformatter);
		String hour = now.format(hourformatter);
		int hourCount = 0;
		// 멜론 시간별 담은 리스트
		List<String> melonHourList = new ArrayList<>();
		// 멜론 시간별 담은 리스트를 시간별 담은 리스트ㅋㅋ
		List<List<String>> melonGraph = new ArrayList<>();
		// 시간별 순위를 담은 리스트
		List<Graph> graphList = new ArrayList<Graph>();

		for (int i = 0; i <= Integer.valueOf(hour); i++) {
			List<String> melonHourRank = new ArrayList<>();
			String hourCount2;
			
			hourCount++;
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

			String url = "https://www.melon.com/chart/index.htm?dayTime=" + date + hourCount2;
			Document doc = Jsoup.connect(url).get();
			Elements title = doc.select("div.rank01>span>a");

			for (int j = 0; j < 100; j++) {
				String title_temp = title.get(j).text();
				melonHourRank.add(title_temp);
			}
			melonGraph.add(melonHourRank);
		}

		// 타이틀로 노래명 검색
		String title = tit;
		for (int h = 0; h <= Integer.valueOf(hour); h++) {
			int count = 0;
			for (int j = 0; j < 100; j++) {
				String ss = String.valueOf((melonGraph.get(h).get(j)));

				if (title.equals(ss)) {
//					System.out.println(h + "시 " + (j + 1) + "위 노래는 : " + ss);
					graphList.add(new Graph(h, String.valueOf(j + 1)));
					count++;
				} else if (j == 99 && count == 0) {
					graphList.add(new Graph(h, null));
//					System.out.println(h + "시 에는 차트에 들지 못한 노래입니다.");
				}
			}
		}
		return graphList;
	}
}