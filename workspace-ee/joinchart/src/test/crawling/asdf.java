package test.crawling;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class asdf {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);

		String url = "https://www.music-flo.com/browse";

		try {
			driver.get(url);
			Thread.sleep(2000);
			WebElement flotime = driver.findElementByCssSelector("p.update>span");

			String flotime_temp = flotime.getText();
			System.out.println(flotime_temp);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}
}
