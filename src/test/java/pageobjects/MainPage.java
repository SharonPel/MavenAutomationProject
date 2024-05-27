package pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	// cookies banner
	@FindBy(css = ".cookies-policy-banner")
	private WebElement cookiesArea;

	// got it Btn
	@FindBy(css = ".cookies-policy-banner > button")
	private WebElement gotItBtn;

	// main
	@FindBy(css = ".nav-right__user>.btn")
	private WebElement signinBtn;

	// sign-up
	@FindBy(css = ".sign-in-form__signup-button>a>span")
	private WebElement signupBtn;

	// back to login page
	@FindBy(css = ".sign-up-form__login-button>span")
	private WebElement backToLoginBtn;

	// build you own trip Btn
	@FindBy(css = ".btn-blue-outlined.btn.btn-link")
	private WebElement buildYourTripBtn;

	// close Hunnuka popUP
	@FindBy(css = "[alt='Close']")
	private WebElement closePopUpBtn;

	@FindBy(css = ":nth-child(2) > div.footer-list.footer-list--large > ul > li:nth-child(5) > a")
	private WebElement carRentalBtn;

	@FindBy(css = ".app-header__desktop > nav > div > a:nth-child(1)")
	private WebElement destinationsBtn;

	@FindBy(css = ".nav-right__toggle")
	private WebElement globeBtn;

	@FindBy(css = "button.locale-settings-list__item span")
	private List<WebElement> langaugeList;

	@FindBy(css = "button:nth-child(2) > div.locale-settings__tab-title")
	private WebElement currencyBtn;

	@FindBy(css = "button.locale-settings-list__item ")
	private List<WebElement> currencyList;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void closeCookies() {
		click(gotItBtn);
	}

	public void moveToLogIn() {
		click(signinBtn);
	}

	public void moveToSignup() {
		click(signupBtn);
	}

	public void backToLogin() {
		click(backToLoginBtn);
	}

	public void buildYourOwnTrip() {
		click(buildYourTripBtn);
	}

	public void scrollToCarRentalSlowly() {
		for (int i = 0; i < 10; i++) {
			((JavascriptExecutor) driver).executeScript(("window.scrollBy(0, 200)"));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", carRentalBtn);
	}

	public void closePopUp() {
		waitUntilElementToBeClickable(closePopUpBtn);
		click(closePopUpBtn);
	}

	public void clickCarRental() {
		click(carRentalBtn);
	}

	public void moveToDestination() {
		click(destinationsBtn);
	}

	public void hoverOverGlobeBtn() {
		waiting(700);
//		waitUntilElementToBeClickable(globeBtn);
		act.moveToElement(globeBtn);
		act.build().perform();
	}

	public void chooseLanguage(String langaugeName) {
		for (WebElement language : langaugeList) {
			if (getText(language).equalsIgnoreCase(langaugeName)) {
				click(language);
				break;
			}
		}
	}

	public void chooseCurrency(String currencyName) {
		hoverOverGlobeBtn();
		click(currencyBtn);
		for (WebElement currency : currencyList) {
			if (getText(currency).toLowerCase().contains(currencyName)) {
				click(currency);
				break;
			}
		}
	}

	// method to move to CAR RENTAL PAGE
	public void moveToCarRentalPage() {
		ArrayList<String> carWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(carWindow.get(1));
	}
}
