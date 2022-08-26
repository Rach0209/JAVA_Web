package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flo {
	public static List<Music> crawlingFlo() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);

		String url = "https://www.music-flo.com/browse?chartId=1";

		List<Music> flolist = new ArrayList<>();

		try {
			driver.get(url);
			Thread.sleep(2000);
			WebElement click = driver.findElement(By.xpath("//*[@id='browseRank']/div[2]/div/button"));
			click.sendKeys(Keys.ENTER);

			List<WebElement> title = driver.findElementsByClassName("tit__text");
			List<WebElement> updown = driver.findElementsByCssSelector("td.rank");
			List<WebElement> figure = driver.findElementsByCssSelector("td.rank > span");
			List<WebElement> artist = driver.findElementsByClassName("last");
			List<WebElement> album = driver.findElementsByClassName("album");
			List<WebElement> albumArt = driver.findElementsByTagName("img");

			for (int i = 0; i < 100; i++) {
				int rank = i + 1;
				String title_temp = title.get(i).getText();
				String updown_temp = null;
				if (updown.get(i).getText().equals("")) {
					updown_temp = "-";
				} else if (figure.get(i).getAttribute("class").equals("up")) {
					updown_temp = "↑" + updown.get(i).getText();
				} else if (figure.get(i).getAttribute("class").equals("down")) {
					updown_temp = "↓" + updown.get(i).getText();
				}
				String artist_temp = artist.get(i).getText();
				String album_temp = album.get(i).getText();
				String albumArt_temp = albumArt.get(i).getAttribute("data-src");

				flolist.add(new Music(rank, updown_temp, title_temp, artist_temp, album_temp, albumArt_temp));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return flolist;
	}

	public static String floTime() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);
		try {
			String url4 = "https://www.music-flo.com/browse";
			
			driver.get(url4);
			Thread.sleep(2000);
			WebElement flotime = driver.findElementByCssSelector("p.update>span");

			String flotime_temp = flotime.getText();
//			System.out.println(flotime_temp);
			return flotime_temp;
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			driver.quit();
		}
		return null;
	}

//	public static void main(String[] args) {
//		try {
//			List<Music> list = crawlingFlo();
//			for (Music m : list) {
//				System.out.println(m);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}