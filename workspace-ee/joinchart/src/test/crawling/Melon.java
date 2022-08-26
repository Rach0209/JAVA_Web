package test.crawling;

import java.io.IOException;
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
			case "순위 동일" : {
				updown_temp = "-";
				figure_temp = "";
				break;
			}
			case "단계 상승" : {
				updown_temp = "↑";
				break;
			}
			case "단계 하락" : {
				updown_temp = "↓";
				break;
			}
			case "순위 진입" : {
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

}