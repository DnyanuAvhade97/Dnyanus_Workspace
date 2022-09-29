package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.MyNetworkPage;
import utils.Utility;

public class VerifyPeopleIFollowPage {

	private WebDriver driver;
	private MyNetworkPage myNetwork;
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABC\\Documents\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod 
	public void openMyNetworkPage() throws EncryptedDocumentException, IOException   {
		driver.get("https://in.linkedin.com/");
		
		loginPage = new LoginPage(driver);
		String email=Utility.fetchDataFromExcel("Dnyanu", 2, 1);
		String password=Utility.fetchDataFromExcel("Dnyanu", 2, 2);
		loginPage.completeLogin(email, password);

		homePage = new HomePage(driver);
		homePage.openMyNetworkPage();
		myNetwork = new MyNetworkPage(driver);
	}

	@Test
	public void verifyPeopleIFollowLink() throws InterruptedException {
		Thread.sleep(1000);
		myNetwork.openPeopleIFollowPage();;
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
	
		Assert.assertEquals(url, "https://www.linkedin.com/feed/following/?filterType=member");
	}
	
	@AfterMethod
	public void logOutToApp() throws InterruptedException {
		LogOutPage logOutPage = new LogOutPage(driver);
		logOutPage.logOutApp();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
