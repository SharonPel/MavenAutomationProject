package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LaTourEiffelPage extends MainPage{

	@FindBy (css=".poi-hero__title")
	private WebElement pageTitle;

	public LaTourEiffelPage(WebDriver driver) {
		super(driver);

	}

	public boolean isLaTourEiffel() {
		waitUntilElementToBeVisible(pageTitle);
		if(getText(pageTitle).equalsIgnoreCase("eiffel tour")) {
			return true;
		}
		return false;
	}	
}



