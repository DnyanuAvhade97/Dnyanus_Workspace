package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class VerifyMyNetworkPage extends Base{

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

	@Test (priority=1)
	public void verifyConnectionsLink() throws InterruptedException {
		testId=001;
		Thread.sleep(1000);
		myNetwork.openConnectionsPage();
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.linkedin.com/mynetwork/invite-connect/connections/");
//		if (url.equals("https://www.linkedin.com/mynetwork/invite-connect/connections/")) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Fail");
//		}
	}

	@Test (priority=2)
	public void verifyContactsLink() throws InterruptedException {
		testId=002;
		Thread.sleep(1000);
		myNetwork.opencontactsPage();;
		Thread.sleep(3000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/mynetwork/import-contacts/saved-contacts/")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@Test (priority=3)
	public void verifyPeopleIFollowLink() throws InterruptedException {
		testId=003;
		Thread.sleep(1000);
		myNetwork.openPeopleIFollowPage();;
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/feed/following/?filterType=member")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
		@Test (priority=4)
		public void verifyGroupsLink() throws InterruptedException {
			testId=004;
			Thread.sleep(1000);
			myNetwork.OpengroupsPage();;
			Thread.sleep(2000);
			String url =driver.getCurrentUrl();
			if (url.equals("https://www.linkedin.com/groups/")) {
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
		}
		
	@Test (priority=5)
	public void verifyEventsLink() throws InterruptedException {
		testId=005;
		Thread.sleep(1000);
		myNetwork.openEventsPage();;
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/mynetwork/network-manager/events/")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@Test (priority=6)
	public void verifyPagesLink() throws InterruptedException {
		testId=006;
		Thread.sleep(1000);
		myNetwork.OpenPagesPage();
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/mynetwork/network-manager/company/")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@Test (priority=7)
	public void verifyNewslettersLink() throws InterruptedException {
		testId=007;
		Thread.sleep(1000);
		myNetwork.openNewslettersPage();
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/mynetwork/network-manager/newsletters/")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	
	@Test (priority=8)
	public void verifyHashtagLink() throws InterruptedException {
		testId=8;
		Thread.sleep(1000);
		myNetwork.openHashtagPage();
		Thread.sleep(1000);
		String url =driver.getCurrentUrl();
		if (url.equals("https://www.linkedin.com/mynetwork/network-manager/hashtags/")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
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
