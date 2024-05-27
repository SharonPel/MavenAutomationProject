package pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExploreDestinationPage extends MainPage {

	@FindBy(css = ".tabs .tabs__item")
	private List<WebElement> optionsArea;

	@FindBy(css = ".poi-card2__heading")
	private List<WebElement> placesArea;

	public ExploreDestinationPage(WebDriver driver) {
		super(driver);
	}

	// options to experience a destination
	public void moveToOption(String optionName) {
		waiting(2000);
		for (WebElement option : optionsArea) {
			if (getText(option).equalsIgnoreCase(optionName)) {
				click(option);
				break;
			}
		}
	}
	public void moveToEiffelTourWindow() {
	ArrayList<String> eiffelTourWindow = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(eiffelTourWindow.get(1));
	}
	// choose attraction
	public void choosePlace(String placeName) {
		waiting(1400);
		for (WebElement place : placesArea) {
			if (getText(place).equalsIgnoreCase(placeName)) {
				click(place);
				// System.out.println(getText(experience));
				break;
			}
		}
	}
}
