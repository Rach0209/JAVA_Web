package test.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flo222 extends HttpServlet {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "E:\\Coding\\JAVA\\BSS\\JAVA_Web\\__lib\\chromedriver.exe"; // 드라이버 경로

	public static List<Music> crawlingFlo() throws IOException {
		// 드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 크롬 설정을 담은 객체 생성
		ChromeOptions options = new ChromeOptions();
		// 브라우저가 눈에 보이지 않고 내부적으로 돈다.
		options.addArguments("--start-maximized"); // 최대크기
		options.addArguments("headless"); // 설정하지 않을 시 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
		options.addArguments("--disable-popup-blocking"); // 팝업 방지

		// 위에서 설정한 옵션은 담은 드라이버 객체 생성
		// 옵션을 설정하지 않았을 때에는 생략 가능하다.
		// WebDriver객체가 곧 하나의 브라우저 창이라 생각한다.
		WebDriver driver = new ChromeDriver(options);

		// 이동을 원하는 url
		String url = "https://www.music-flo.com/browse?chartId=1";

		// WebDriver을 해당 url로 이동한다.
		driver.get(url);

		// 브라우저 이동시 생기는 로드시간을 기다린다.
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		}

		// class="nav" 인 모든 태그를 가진 WebElement리스트를 받아온다.
		// WebElement는 html의 태그를 가지는 클래스이다.
		WebElement click = driver.findElement(By.xpath("//*[@id='browseRank']/div[2]/div/button"));

		click.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		List<WebElement> el1 = driver.findElements(By.className("tit__text"));
		List<WebElement> el2 = driver.findElements(By.className("album"));
		List<WebElement> el3 = driver.findElements(By.className("last"));
		List<WebElement> el4 = driver.findElements(By.tagName("img"));
//		List<WebElement> el5 = new ArrayList<WebElement>();
//		for (int i = 1; i <= 100; i++) {
//			el5.add(driver.findElement(By.xpath("//*[@id='browseRank']/div[2]/table/tbody/tr[" + i + "]/td[4]/div/div[1]/a/img")));
//		}

		List<Music> flolist = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			int rank = i + 1;
			String title_temp = el1.get(i).getText();
			String artist_temp = el3.get(i).getText();
			String album_temp = el2.get(i).getText();
			String albumArt_temp = el4.get(i).getAttribute("data-src");

			flolist.add(new Music(rank, title_temp, artist_temp, album_temp, albumArt_temp));
		}
//		System.out.println(flolist);
		try {
			// 드라이버가 null이 아니라면
			if (driver != null) {
				// 드라이버 연결 종료
				driver.close(); // 드라이버 연결 해제

				// 프로세스 종료
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return flolist;
	}
}
