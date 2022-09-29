package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.MyNetworkPage;
import setup.Base;
import utils.Utility;

public class VerifyConnectionPage extends Base {
	
	private WebDriver driver;
	private MyNetworkPage myNetwork;
	private LoginPage loginPage;
	private HomePage homePage;
	private LogOutPage logOutPage;
	private int testId;

	@Parameters ("browser")
	
	@BeforeTest
	public void openBrowser(String browserName) {
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver=openEdgeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createPOMClassObjects() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myNetwork = new MyNetworkPage(driver);
		logOutPage = new LogOutPage(driver);
	}

	@BeforeMethod 
	public void openMyNetworkPage() throws EncryptedDocumentException, IOException {
		driver.get("https://in.linkedin.com/");
		String email=Utility.fetchDataFromExcel("Dnyanu", 2, 1);
		String password=Utility.fetchDataFromExcel("Dnyanu", 2, 2);
		loginPage.completeLogin(email, password);
		homePage.openMyNetworkPage();
	}

	@Test 
	public void verifyConnectionsLink() throws InterruptedException {
		testId=123;
		Thread.sleep(1000);
		myNetwork.openConnectionsPage();
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.linkedin.com/mynetwork/invite-connect/connections/");
	}
	
	@Test
	public void verifyGroupsLink() throws InterruptedException {
		testId=124;
		Thread.sleep(1000);
		myNetwork.OpengroupsPage();;
		Thread.sleep(2000);
		String url =driver.getCurrentUrl();
		
		Assert.assertEquals(url,"https://www.linkedin.com/groups/");		
	}
	
	@AfterMethod
	public void logOutToApp(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenShot(driver, testId);
		}
		
		logOutPage.logOutApp();
	}

	@AfterClass
	public void clearPOMClassObjects() {
		loginPage =null;
		homePage = null;
		myNetwork = null;
		logOutPage =null;		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}

}
