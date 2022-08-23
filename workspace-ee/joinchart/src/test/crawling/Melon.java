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

public class Melon extends HttpServlet {
	public static List<Music> crawlingMelon() throws IOException {
		String url="https://www.melon.com/chart/index.htm";

	       //크롤링하고싶은 대상 url 을 적는다 
			Document doc=Jsoup.connect(url).get();

			List<Music> melonlist = new ArrayList<>();
			
			Elements title = doc.select("div.rank01>span>a");
			Elements artist = doc.select("div.rank02>span");
			Elements album = doc.select("div.rank03>a");
			Elements albumArt = doc.select("div>a>img");
			
			for(int i = 0; i < 100; i++) {
				int rank = i + 1;
				String title_temp = title.get(i).text();
				String artist_temp = artist.get(i).text();
				String album_temp = album.get(i).text();
				String albumArt_temp = albumArt.get(i).attr("src");
				
				melonlist.add(new Music(rank,title_temp,artist_temp,album_temp,albumArt_temp));
			}
			return melonlist;
			
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