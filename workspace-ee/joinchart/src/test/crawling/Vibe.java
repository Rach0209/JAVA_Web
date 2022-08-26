package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vibe {
	public static List<Music> crawlingVibe() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);

		String url = "https://vibe.naver.com/chart/total";

		// 크롤링하고싶은 대상 url 을 적는다
		List<Music> vibelist = new ArrayList<>();
		try {
			driver.get(url);
			Thread.sleep(2000);

			List<WebElement> el1 = driver.findElementsByCssSelector("div.title_badge_wrap>span>a");
			List<WebElement> el2 = driver.findElementsByCssSelector("td.artist");
			List<WebElement> el3 = driver.findElementsByCssSelector(".album>a");
			List<WebElement> el4 = driver.findElementsByCssSelector(".img_thumb");

			for (int i = 0; i < 100; i++) {
				int rank = i + 1;
				String title_temp = el1.get(i).getAttribute("title");
				String artist_temp = el2.get(i).getAttribute("title");
				String album_temp = el3.get(i).getAttribute("title");
				String albumArt_temp = el4.get(i).getAttribute("src");

				vibelist.add(new Music(rank, title_temp, artist_temp, album_temp, albumArt_temp));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

		return vibelist;

	}

	public static String vibeTime() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);
		String vibetime = null;
		try {
			String url5 = "https://vibe.naver.com/chart/total";
			driver.get(url5);
			Thread.sleep(2000);
			List<WebElement> el1 = driver.findElementsByCssSelector("#content > div.sub > span");
			vibetime = el1.get(0).getText();
			return vibetime;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return null;
	}
}