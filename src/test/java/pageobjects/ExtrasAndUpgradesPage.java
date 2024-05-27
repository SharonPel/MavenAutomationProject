package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtrasAndUpgradesPage extends MainPage {

	@FindBy(css = ".hidden-sm.hidden-xs .your_rental_car_type > span")
	private WebElement carSelected;

	public ExtrasAndUpgradesPage(WebDriver driver) {
		super(driver);
	}

	public String getSelectedCarName() {
		waitUntilElementToBeClickable(carSelected);
		return getText(carSelected);
	}
}
