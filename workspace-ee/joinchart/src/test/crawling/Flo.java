package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Flo extends HttpServlet {

	public static List<Music> crawlingFlo() throws IOException {
		String url = "https://www.music-flo.com/browse?chartId=1";

		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();

		List<Music> flolist = new ArrayList<>();

		Elements title = doc.select("#app>table.track_list_table>tr>td.info>div.txt_area>span.tit__inner>strong.tit__text");
		Elements artist = doc.select("#app>table.track_list_table>tr>td.artist>p>span.artist_link>a");
		Elements album = doc.select("#app>table.track_list_table>tr>td.info>div.txt_area>div.desc>a>p.album");
		Elements albumArt = doc.select("#app>table.track_list_table>tr>td.info>div.thumb>img");

		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = title.get(i).text();
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			flolist.add(new Music(rank, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		System.out.println(flolist);
		return flolist;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
