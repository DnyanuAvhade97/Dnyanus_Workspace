package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver openChromeBrowser() {
//		System.setProperty("webdriver.chrome.driver",
//				"src\\test\\resources\\Browsers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
//		System.setProperty("webdriver.gecko.driver",
//				"src\\test\\resources\\Browsers\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver openEdgeBrowser() {
//		System.setProperty("webdriver.edge.driver",
//				"src\\test\\resources\\Browsers\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver  = new EdgeDriver();
		return driver;
	}
}
