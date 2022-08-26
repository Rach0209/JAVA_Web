package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Youtube {
	public static List<YoutubeMusic> crawlingYoutube() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);
		
		String url = "https://charts.youtube.com/charts/TopSongs/kr?hl=ko";
		List<YoutubeMusic> youtubeList = new ArrayList<>();
		try {
			driver.get(url);
			Thread.sleep(5000);
			List<WebElement> title_temp = new ArrayList<>();
			List<WebElement> artist_temp = new ArrayList<>();
			List<WebElement> albumArt_temp = new ArrayList<>();
			for (int i = 1; i <= 100; i++) {
				title_temp.add(driver.findElementByXPath("//*[@id=\""+ i +"\"]/div[3]/div[1]/ytmc-ellipsis-text/div/span"));
				artist_temp.add(driver.findElementByXPath("//*[@id=\""+ i + "\"]/div[3]/div[2]/ytmc-artists-list/div/span"));
				albumArt_temp.add(driver.findElementByXPath("//*[@id=\""+ i +"\"]/div[2]/img"));
			}
			
			for (int i = 0; i < 100; i++) {
				int rank = i + 1;
				String title = title_temp.get(i).getText();
				String artist = artist_temp.get(i).getText();
				String albumArt = albumArt_temp.get(i).getAttribute("src");
	
				youtubeList.add(new YoutubeMusic(rank, title, artist, albumArt));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return youtubeList;
		
	}
	
//	public static void main(String[] args) {
//	      try {
//	         List<YoutubeMusic> list = crawlingYoutube();
//	         for (YoutubeMusic m : list) {
//	            System.out.println(m);
//	         }
//	      } catch (IOException e) {
//	         e.printStackTrace();
//	      }
//	   }
}
