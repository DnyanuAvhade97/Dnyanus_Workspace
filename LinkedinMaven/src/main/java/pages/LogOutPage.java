package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	@FindBy(xpath="//span[text()='Me']")
	private WebElement accTab;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutButton;
	
	@FindBy(xpath="//span[text()='Sign out']")
	private WebElement signOutConfirmButton;
	
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void logOutApp() throws InterruptedException {
		accTab.click();
		Thread.sleep(1000);
		signOutButton.click();
		Thread.sleep(1000);
//		signOutConfirmButton.click();
	}

}
