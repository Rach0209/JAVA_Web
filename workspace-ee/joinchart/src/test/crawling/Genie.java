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

import test.crawling.Music;

public class Genie extends HttpServlet {
	public static List<Music> crawlingGenie() throws IOException {
		String url = "https://www.genie.co.kr/chart/top200";
		String url2 = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20220823&hh=16&rtm=Y&pg=2";
		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();
		Document doc2 = Jsoup.connect(url2).get();

		List<Music> genielist = new ArrayList<>();

		// 순위 1~50
		Elements title = doc.select("table.list-wrap").select("a.title");
		Elements artist = doc.select("table.list-wrap").select("a.artist.ellipsis");
		Elements album = doc.select("table.list-wrap").select("a.albumtitle.ellipsis");
		Elements albumArt = doc.select("table.list-wrap").select("img");

		// 순위 51~100
		Elements title2 = doc2.select("table.list-wrap").select("a.title");
		Elements artist2 = doc2.select("table.list-wrap").select("a.artist.ellipsis");
		Elements album2 = doc2.select("table.list-wrap").select("a.albumtitle.ellipsis");
		Elements albumArt2 = doc2.select("table.list-wrap").select("img");

		for (int i = 0; i < 50; i++) {
			// int rank_temp = Integer.valueOf((rank.get(i).text()));
			int rank_temp = i + 1;
			String title_temp = title.get(i).text();
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			genielist.add(new Music(rank_temp, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		for (int i = 0; i < 50; i++) {
			// int rank_temp = Integer.valueOf((rank.get(i).text()));
			int rank_temp = i + 51;
			String title_temp = title2.get(i).text();
			String artist_temp = artist2.get(i).text();
			String album_temp = album2.get(i).text();
			String albumArt_temp = albumArt2.get(i).attr("src");

			genielist.add(new Music(rank_temp, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		return genielist;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}