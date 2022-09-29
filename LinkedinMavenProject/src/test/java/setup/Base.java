package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABC\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ABC\\Documents\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\ABC\\Documents\\selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver  = new EdgeDriver();
		return driver;
	}
}
