package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath="(//li-icon[@type='chevron-down'])[4]")
	private WebElement hideMessangeButton;
	
	@FindBy (xpath="//span[text()='My Network']")
	private WebElement myNetworkTab;
	
	@FindBy (xpath="//span[text()='Notifications']")
	private WebElement myNotificationsTab;

	@FindBy (xpath="//h3[text()='Ashwini Kalbhor']")
	private WebElement selectChatAcc;
	
	@FindBy (xpath="//div[@role='textbox']")
	private WebElement enterMessage;
	
	@FindBy (xpath="//button[text()='Send']")
	private WebElement sendButton;
	
	@FindBy (xpath="(//li-icon[@type='cancel-icon'])[3]")
	private WebElement closeMessageTab;
	
	@FindBy (xpath="//span[text()='Discard']")
	private WebElement discardButton;
	
	
	//Initialisation
	public HomePage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	///use
	
	public void clickOnHideMessageButton() {
		hideMessangeButton.click();
	}
	
	public void openMyNetworkPage() {
		myNetworkTab.click();
	}
	
	public void openMyNotificationsPage() {
		myNotificationsTab.click();
	}
	
	public void OpenChatAcc() {
		selectChatAcc.click();
	}
	
	public void enterMessageInChat() {
		enterMessage.sendKeys("Hello");
	}
	
	public void clickOnSendButton() {
		sendButton.click();
	}
	
	public void clickOnCloseChat() {
		closeMessageTab.click();
	}
	
	public void clickOndiscardButton() {
		discardButton.click();
	}
}
