package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utility;

public class Demo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\ABC\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		
//		driver.get("https://in.linkedin.com/");
//		
//		
//		
//		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
//		                        .withTimeout(Duration.ofSeconds(10))
//		                        .pollingEvery(Duration.ofSeconds(2))
//		                        .ignoring(NoSuchElementException.class);
		
		
		String value =Utility.fetchDataFromExcel("Dnyanu", 7,0);

		System.out.println(value);
		
	}
}
