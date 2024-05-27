package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripPurposePage extends BasePage {

	// list area
	@FindBy(css = ".search-purpose__item")
	List<WebElement> areaPurposeList;

	// next Btn
	@FindBy(css = ".btn-blue.btn")
	private WebElement nextBtn;

	public TripPurposePage(WebDriver driver) {
		super(driver);
	}

	public void chooseTripPurpose(String name) {
		for (WebElement area : areaPurposeList) {
			WebElement titleEl = area.findElement(By.tagName("span"));
			if (getText(titleEl).equalsIgnoreCase(name)) {
				click(titleEl);
				click(nextBtn);
				break;
			}
		}
	}

	public void goToInterestsPage() {
		click(nextBtn);
	}
}
