package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestionsPage extends MainPage {

	@FindBy(css = ".trip-card__city")
	private List<WebElement> suggestionsList;

	public SuggestionsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseOneSuggestion(String name) {
		waiting(8000);
		for (WebElement suggestion : suggestionsList) {
			if (getText(suggestion).equalsIgnoreCase(name)) {
				click(suggestion);
				break;
			}
		}
	}
}
