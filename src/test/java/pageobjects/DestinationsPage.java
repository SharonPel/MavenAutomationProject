package pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends MainPage {

	@FindBy(css = "div.destinations-header > div > form > div > div > div > input")
	private WebElement searchField;

	@FindBy(css = ".destinations-header__btn.btn")
	private WebElement searchDestinationsBtn;

	@FindBy(css = "div.destinations-page-item__desc > div")
	private List<WebElement> destinationsList;

	@FindBy(css = ".destinations-page-item__title")
	private WebElement scrollDownToCity;

	@FindBy(css = ".empty-state__message")
	private WebElement oopsMsg;

	public DestinationsPage(WebDriver driver) {
		super(driver);
	}

	public void searchForDestination(String cityName) {

		click(searchField);
		fillTextClearAllText(searchField, cityName);
		click(searchDestinationsBtn);
	}

	public void scrollToDestination() {
		for (int i = 0; i < 10; i++) {
			((JavascriptExecutor) driver).executeScript(("window.scrollBy(0, 50)"));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollDownToCity);
	}

	public void findDestinationName(String name) {
		try {
			for (WebElement cityName : destinationsList) {
				if (getText(cityName).equalsIgnoreCase(name)) {
					click(cityName);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public String getOopsMsg() {
		waitUntilElementToBeClickable(oopsMsg);
		return getText(oopsMsg);
	}

}
