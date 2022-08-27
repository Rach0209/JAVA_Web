package test.crawling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChartDriver {
	public ChromeDriver connectionDriver() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--start-maximized");
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);
		
		return driver;
	}
	
	public void closeDriver(ChromeDriver driver) throws Exception {
		driver.quit();
	}
}
