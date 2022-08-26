package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test extends HttpServlet {
	
	private static ChartDriver conn = new ChartDriver();
	private static ChromeDriver driver = new ChromeDriver();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setAttribute("flolist", crawlingTest());
			conn.closeDriver(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Music> crawlingTest() throws Exception {
		driver = conn.connectionDriver();
		String url = "https://www.music-flo.com/browse?chartId=1";
		List<Music> flolist = new ArrayList<>();
		
		
		driver.get(url);
		Thread.sleep(2000);
		WebElement click = driver.findElement(By.xpath("//*[@id='browseRank']/div[2]/div/button"));
		click.sendKeys(Keys.ENTER);

		List<WebElement> title = driver.findElementsByClassName("tit__text");
//		List<WebElement> updown = driver.findElementsByCssSelector("td.rank");
//		List<WebElement> figure = driver.findElementsByCssSelector("td.rank > span");
		List<WebElement> artist = driver.findElementsByClassName("last");
		List<WebElement> album = driver.findElementsByClassName("album");
		List<WebElement> albumArt = driver.findElementsByTagName("img");

		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = title.get(i).getText();
//			String updown_temp = null;
//			if (updown.get(i).getText().equals("")) {
//				updown_temp = "-";
//			} else if (figure.get(i).getAttribute("class").equals("up")) {
//				updown_temp = "↑" + updown.get(i).getText();
//			} else if (figure.get(i).getAttribute("class").equals("down")) {
//				updown_temp = "↓" + updown.get(i).getText();
//			}
			String artist_temp = artist.get(i).getText();
			String album_temp = album.get(i).getText();
			String albumArt_temp = albumArt.get(i).getAttribute("data-src");

			flolist.add(new Music(rank, title_temp, artist_temp, album_temp, albumArt_temp));
		}
		
		return flolist;

	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(crawlingTest());
//	}
}
