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

public class Bugs extends HttpServlet {

	public static List<Music> crawlingBugs() throws IOException {
		String url = "https://music.bugs.co.kr/chart";

		// 크롤링하고싶은 대상 url 을 적는다
		Document doc = Jsoup.connect(url).get();

		List<Music> bugslist = new ArrayList<>();

		Elements title = doc.select("tbody>tr>th>p.title>a");
		Elements artist = doc.select("tbody>tr>td.left>p.artist>a");
		Elements album = doc.select("tbody>tr>td.left>a.album");
		Elements albumArt = doc.select("tbody>tr>td>a>img");

		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = title.get(i).text();
			String artist_temp = artist.get(i).text();
			String album_temp = album.get(i).text();
			String albumArt_temp = albumArt.get(i).attr("src");

			bugslist.add(new Music(rank, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		return bugslist;
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
