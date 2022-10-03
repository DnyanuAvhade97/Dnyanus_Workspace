package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@id='session_key']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='session_password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//a[text()='User Agreement']")
	private WebElement userAgreementLink;

	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement privacyPolicyLink;

	@FindBy(xpath = "//a[text()='Cookie Policy']")
	private WebElement cookiePolicyLink;

	// Initialisation
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/// use
	//Login in Single Method
	public void completeLogin(String emailId,String pass) {
		email.sendKeys(emailId);
		password.sendKeys(pass);
		submitButton.click();
	}

	public void sendEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}


	public void openUserAgreementLink() {
		userAgreementLink.click();
	}

	public void openPrivacyPolicyLink() {
		privacyPolicyLink.click();
	}

	public void openCookiePolicyLink() {
		cookiePolicyLink.click();
	}

}
