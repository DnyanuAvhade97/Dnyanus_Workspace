package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyNetworkPage {
	
	@FindBy (xpath="//div[text()='Connections']")
	private WebElement connectionsLink;
	
	@FindBy (xpath="//div[text()='Contacts']")
	private WebElement contactsLink;
	
	@FindBy (xpath="//div[text()='People I Follow']")
	private WebElement peopleIFollowLink;

	@FindBy (xpath="//div[text()='Groups']")
	private WebElement groupsLink;
	
	@FindBy (xpath="//div[text()='Events']")
	private WebElement eventsLink;
	
	@FindBy (xpath="//div[text()='Pages']")
	private WebElement pagesLink;
	
	@FindBy (xpath="//div[text()='Newsletters']")
	private WebElement newslettersLink;
	
	@FindBy (xpath="//div[text()='Hashtag']")
	private WebElement hashtagLink;
	
	
	//Initialisation
	public MyNetworkPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	///use
	
	public void openConnectionsPage() {
		connectionsLink.click();
	}
	
	public void opencontactsPage() {
		contactsLink.click();
	}
	
	public void openPeopleIFollowPage() {
		peopleIFollowLink.click();
	}
	
	public void OpengroupsPage() {
		groupsLink.click();
	}
	
	public void openEventsPage() {
		eventsLink.click();
	}
	
	public void OpenPagesPage() {
		pagesLink.click();
	}
	
	public void openNewslettersPage() {
		newslettersLink.click();
	}
	
	public void openHashtagPage() {
		hashtagLink.click();
	}

}
