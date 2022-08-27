package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Bugs{

	public static List<Music> crawlingBugs() throws IOException {
		String url = "https://music.bugs.co.kr/chart";

		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();

		List<Music> bugslist = new ArrayList<>();

		Elements title = doc.select("tbody>tr>th>p.title>a");
		Elements updown = doc.select("div.ranking>p.change");
		Elements artist = doc.select("tbody>tr>td.left>p.artist>a").not(".more");
		Elements album = doc.select("tbody>tr>td.left>a.album");
		Elements albumArt = doc.select("tbody>tr>td>a>img");

		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = title.get(i).text();
			String updown_temp = null;
			switch (updown.get(i).className()) {
			case "change none": {
				updown_temp = "-";
				break;
			}
			case "change up": {
				updown_temp = "↑" + doc.select("div.ranking>p.change>em").get(i).text();
				break;
			}
			case "change down": {
				updown_temp = "↓" + doc.select("div.ranking>p.change>em").get(i).text();
				break;
			}
			case "change new": {
				updown_temp = "new";
				break;
			}
			case "change renew": {
				updown_temp = "renew";
				break;
			}
			};
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			bugslist.add(new Music(rank, updown_temp ,title_temp, artist_temp, album_temp, albumArt_temp));
		}
		return bugslist;
	}
}
