package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicsPage extends BasePage {

	// I know what I want to do
	@FindBy(css = "div:nth-child(2) > div.flows__item-btn.hide-xs.show-md > button")
	private WebElement inspireMeBtn;

	// I know my destination
	@FindBy(css = "div:nth-child(1) > div.flows__item-btn.hide-xs.show-md > button")
	private WebElement startPlanningBtn;

	public BasicsPage(WebDriver driver) {
		super(driver);
	}

	public void inspireMe() {
		click(inspireMeBtn);
	}
}
