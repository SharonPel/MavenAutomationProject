package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

	//	sign in
	@FindBy (css=".nav-right__user .btn-dark-blue")
	private WebElement signinBtn;
	//	fill  email
	@FindBy (css="#email")
	private WebElement emailField;
	//	 fill password
	@FindBy (css="[type='password']")
	private WebElement passwordField;
	//	login button
	@FindBy(css=".btn-blue.btn-fluid")
	private WebElement loginBtn;

	@FindBy(css = ".sign-in-form__signup-button>a>span")
	private WebElement signupBtn;

	@FindBy(css = ".nav-right__user-profile >.btn")
	private WebElement successMesg;
	
	@FindBy(css = ".form-error")
	private WebElement errorPass;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {
		fillTextClearAllText(emailField, email);
		fillTextClearAllText(passwordField, password);
		click(loginBtn);
	}

	public String loginSuccessMsg() {
		waitUntilElementToBeClickable(successMesg);
		return getText(successMesg);
	}
	
	public String errorMesg() {
		waitUntilElementToBeClickable(errorPass);
		return getText(errorPass);
	}
	
	public void moveToSignin() {
		click(signinBtn);
	}
}