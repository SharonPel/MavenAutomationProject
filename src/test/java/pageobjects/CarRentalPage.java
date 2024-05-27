package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarRentalPage extends BasePage {
	// Country
	@FindBy(css = "#sCountry-button")
	private WebElement selectCountry;
	@FindBy(css = "#sCountry-menu >li")
	private List<WebElement> areaCountry;

	// PickUpLocation
	@FindBy(css = "#sPickup-button")
	private WebElement pickUpDDM;
	@FindBy(css = "#sPickup-menu >li")
	private List<WebElement> areaPickUp;

	// pickUpTime
	@FindBy(css = "#sPickupTime-button")
	private WebElement pickUpTimeDDM;
	@FindBy(css = "#sPickupTime-menu li")
	private List<WebElement> areaPickUpTime;

	// Dropoff
	@FindBy(css = "#sDropoff-button")
	private WebElement dropOffDDM;
	@FindBy(css = "#sDropoff-menu li")
	private List<WebElement> areaDropOff;

	// dropOffTime
	@FindBy(css = "#sDropoffTime-button")
	private WebElement dropOffTimeDDM;
	@FindBy(css = "#sDropoffTime-menu li")
	private List<WebElement> areaDropOffTime;

	// driverAge
	@FindBy(css = "#driverAge")
	private WebElement DriverAge;

	// selectPickUpDate
	@FindBy(css = "#txtPickup")
	private WebElement calanderPickUpBtn;

	// dropOff
	@FindBy(css = "#drop_off")
	private WebElement calanderDropOffBtn;

	// date title
	@FindBy(css = ".ui-datepicker-title")
	private WebElement monthTitle;
	@FindBy(xpath = "/html/body/form/div[3]/div[4]/div/div[1]/div[2]/div/div/div/div/div/div/div")
	private WebElement returnMonthTitle;

	// selectCarType
	@FindBy(css = "#sCarType-button")
	private WebElement selectCarTypeDDM;
	@FindBy(css = "#sCarType-menu>li")
	private List<WebElement> carTypeList;

	// searchForCars
	@FindBy(css = "[title='search for cars']")
	private WebElement searchForCarsBtn;

	public CarRentalPage(WebDriver driver) {
		super(driver);
	}

	public void chooseCountryName(String name) {
		click(selectCountry);
		try {
			for (WebElement countryNames : areaCountry) {
				if (getText(countryNames).equalsIgnoreCase(name)) {
					click(countryNames);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void choosePickUpLocation(String name) {
		click(pickUpDDM);
		try {
			for (WebElement pickUpLocation : areaPickUp) {
				if (getText(pickUpLocation).equalsIgnoreCase(name)) {
					click(pickUpLocation);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void choosePickUpTime(String time) {
		click(pickUpTimeDDM);
		try {
			for (WebElement pickUpTime : areaPickUpTime) {
				if (getText(pickUpTime).equalsIgnoreCase(time)) {
					click(pickUpTime);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void chooseDropOffLocation(String location) {
		click(dropOffDDM);
		try {
			for (WebElement DropOffLocation : areaDropOff) {
				if (getText(DropOffLocation).equalsIgnoreCase(location)) {
					click(DropOffLocation);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void chooseDropOffTime(String time) {
		click(dropOffTimeDDM);
		try {
			for (WebElement DropOffTime : areaDropOffTime) {
				if (getText(DropOffTime).equalsIgnoreCase(time)) {
					click(DropOffTime);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void setDriverAge(String age) {
		fillText(DriverAge, age);
	}

	public void searchForCars() {
		click(searchForCarsBtn);
	}

	public void selectPickUpDate(String exDay, String exMonthAndYear) {
		click(calanderPickUpBtn);
		waitUntilElementToBeVisible(monthTitle);

		while (true) {
			String text = monthTitle.getText();
			// keep searching for the name of the month until there is a match
			if (text.equals(exMonthAndYear)) {
				break;
			} else {
				driver.findElement(By.cssSelector(".ui-corner-right a.ui-datepicker-next.ui-corner-all")).click();
			}
		}
		List<WebElement> allDays = driver.findElements(By.cssSelector(".ui-datepicker-group-first .ui-state-default"));

		for (WebElement ele : allDays) {
			String exDayText = ele.getText();

			if (exDayText.equals(exDay)) {
				ele.click();
				break;
			}
		}
	}

	public void selectReturnDate(String exDay, String exMonthAndYear) {
		click(calanderDropOffBtn);
		waitUntilElementToBeVisible(returnMonthTitle);
		while (true) {
			String text = returnMonthTitle.getText();
			// keep searching for the name of the month until there is a match
			if (text.equals(exMonthAndYear)) {
				break;
			} else {
				driver.findElement(
						By.xpath("/html/body/form/div[3]/div[4]/div/div[1]/div[2]/div/div/div/div/div[2]/div/a"))
						.click();
			}
		}
		List<WebElement> allDays = driver.findElements(By.xpath(
				"//body[1]/form[1]/div[3]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td/a[1]"));
		for (WebElement ele : allDays) {
			String exDayText = ele.getText();
			if (exDayText.equals(exDay)) {
				ele.click();
				break;
			}
		}
	}

	public void selectCarType(String type) {
		click(selectCarTypeDDM);
		try {
			for (WebElement carType : carTypeList) {
				if (getText(carType).equalsIgnoreCase(type)) {
					click(carType);
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	public void carRentalInfo(String country, String pickUpLocation, String pickUpTime, String carType,
			String dropOffLocation, String dropOffTime, String age) {
		chooseCountryName(country);
		choosePickUpLocation(pickUpLocation);
		choosePickUpTime(pickUpTime);
		selectCarType(carType);
		chooseDropOffLocation(dropOffLocation);
		chooseDropOffTime(dropOffTime);
		setDriverAge(age);
		click(searchForCarsBtn);
	}
}
