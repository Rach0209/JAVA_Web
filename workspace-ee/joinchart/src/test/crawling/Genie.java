package test.crawling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Genie {
	static LocalDateTime now = LocalDateTime.now();
	static DateTimeFormatter weekformatter = DateTimeFormatter.ofPattern("YYYYMMdd");
	static DateTimeFormatter monthformatter = DateTimeFormatter.ofPattern("YYYYMM");
	static DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd");

	static String week = now.format(weekformatter);
	static String week2 = now.format(weekformatter);
	static String month = now.format(monthformatter);
	static String date = now.format(dateformatter);

	public static List<Music> crawlingGenie() throws IOException {
		String url = "https://www.genie.co.kr/chart/top200";
		String url2 = "https://www.genie.co.kr/chart/top200?pg=2";
		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();
		Document doc2 = Jsoup.connect(url2).get();

		List<Music> genielist = new ArrayList<>();

		// 순위 1~50
		Elements title = doc.select("table.list-wrap").select("a.title");
		Elements updown = doc.select("table.list-wrap").select("td.number>span>span>span");
		Elements artist = doc.select("table.list-wrap").select("a.artist.ellipsis");
		Elements album = doc.select("table.list-wrap").select("a.albumtitle.ellipsis");
		Elements albumArt = doc.select("table.list-wrap").select("img");

		// 순위 51~100
		Elements title2 = doc2.select("table.list-wrap").select("a.title");
		Elements updown2 = doc.select("table.list-wrap").select("td.number>span>span>span");
		Elements artist2 = doc2.select("table.list-wrap").select("a.artist.ellipsis");
		Elements album2 = doc2.select("table.list-wrap").select("a.albumtitle.ellipsis");
		Elements albumArt2 = doc2.select("table.list-wrap").select("img");

		for (int i = 0; i < 50; i++) {
			// int rank_temp = Integer.valueOf((rank.get(i).text()));
			int rank_temp = i + 1;
			String title_temp = title.get(i).text();
			String updown_temp = null;
			switch (updown.get(i).className()) {
			case "rank-none": {
				updown_temp = "-";
				break;
			}
			case "rank-up": {
				updown_temp = "↑" + updown2.get(i).text().substring(0, 1);
				break;
			}
			case "rank-down": {
				updown_temp = "↓" + updown2.get(i).text().substring(0, 1);
				break;
			}
			case "rank-new": {
				updown_temp = "new";
				break;
			}
		};
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			genielist.add(new Music(rank_temp, updown_temp, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		for (int i = 0; i < 50; i++) {
			// int rank_temp = Integer.valueOf((rank.get(i).text()));
			int rank_temp = i + 51;
			String title_temp = title2.get(i).text();
			String updown_temp = null;
			switch (updown.get(i).className()) {
			case "rank-none": {
				updown_temp = "-";
				break;
			}
			case "rank-up": {
				updown_temp = "↑" + updown.get(i).text().substring(0, 1);
				break;
			}
			case "rank-down": {
				updown_temp = "↓" + updown.get(i).text().substring(0, 1);
				break;
			}
			case "rank-new": {
				updown_temp = "new";
				break;
			}
			}
			;
			String artist_temp = artist2.get(i).text();
			String album_temp = album2.get(i).text();
			String albumArt_temp = albumArt2.get(i).attr("src");

			genielist.add(new Music(rank_temp, updown_temp, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		return genielist;
	}

	public static List<String> weekGenie() throws IOException {
		List<String> dateList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			week = now.minusDays(7 * i + 6).format(weekformatter);
			week2 = now.minusDays(7 * i).format(weekformatter);
			dateList.add(week2 + "~" + week);
		}
		return dateList;
	}

	public static List<Graph> graphGenie(String tit) throws IOException {
		int hourCount = 0;
		List<String> genieHourList = new ArrayList<>();
		List<List<String>> genieGraph = new ArrayList<>();
		List<Graph> graphList = new ArrayList<Graph>();

		for (int i = 0; i <= 20; i++) {
			List<String> genieDateRank = new ArrayList<>();
			String dayCount;

			dayCount = now.minusDays(i).format(weekformatter);
//			genieHourList.add(dayCount);

			String url = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=" + dayCount + "&hh=09&rtm=N&pg=1";
			String url2 = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=" + dayCount + "&hh=09&rtm=N&pg=2";
			Document doc = Jsoup.connect(url).get();
			Document doc2 = Jsoup.connect(url2).get();
			Elements title = doc.select("table.list-wrap").select("a.title");
			Elements title2 = doc2.select("table.list-wrap").select("a.title");

			for (int j = 0; j < 50; j++) {
				String title_temp = title.get(j).text();
				genieDateRank.add(title_temp);
			}
			for (int j = 0; j < 50; j++) {
				String title_temp = title2.get(j).text();
				genieDateRank.add(title_temp);
			}
//			System.out.println(dayCount + ": " + genieDateRank);
			genieGraph.add(genieDateRank);

			// 타이틀로 노래명 검색
			String musictitle = tit;
			int count = 0;
			for (int j = 0; j < 100; j++) {
				String ss = String.valueOf((genieGraph.get(i).get(j)));

				if (musictitle.equals(ss)) {
//					System.out.println(i + "시 " + (j + 1) + "위 노래는 : " + ss);
					graphList.add(new Graph(i, String.valueOf(j + 1)));
					count++;
				} else if (j == 99 && count == 0) {
					graphList.add(new Graph(i, null));
//					System.out.println(i + "시 에는 차트에 들지 못한 노래입니다.");
				}
			}
		}
		return graphList;
	}
}