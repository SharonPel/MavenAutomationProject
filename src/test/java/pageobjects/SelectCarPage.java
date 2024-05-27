package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectCarPage extends MainPage {

	@FindBy(css = ".col-xs-12.col-sm-12.col-md-3 .carType-container-desktop > div:nth-child(2)  label")
	private WebElement title;

	@FindBy(css = ".col-xs-12.col-sm-12.col-md-3 .carType-container .car_group_check .checkbox > label")
	private List<WebElement> carTypeArea;

	@FindBy(css = "#chooseCar29D10")
	private WebElement bookCarBtn;

	public SelectCarPage(WebDriver driver) {
		super(driver);
	}

	public void waitForTheNewPage() {
		waitUntilElementToBeClickable(title);
		getText(title);
		waiting(3000);
	}

	public void changeCarType(String type) {
		for (WebElement cType : carTypeArea) {
			if (cType.getText().equalsIgnoreCase(type)) {
				click(cType);
				break;
			}
		}
	}

	public void changeCarTypes(String carType, String carType1, String carType2, String carType3) {
		changeCarType(carType);
		changeCarType(carType1);
		changeCarType(carType1);
		changeCarType(carType2);
		changeCarType(carType2);
		changeCarType(carType3);
		// break;
	}
	// }

	// choose premium car group
	public void bookCar() {
		waitUntilElementToBeClickable(bookCarBtn);
		click(bookCarBtn);
	}
}
