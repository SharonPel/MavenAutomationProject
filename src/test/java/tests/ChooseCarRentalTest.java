package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;


@Epic("Renting a Car")
public class ChooseCarRentalTest extends ApplicationBaseTest {

	@Story("As a User I should be able to move from the main website to the carRental website and order a rental car")
	@Test(priority = 1, description = "Choose a Rental Car")
	@Description(" Choose: rental dates, Car Type, pickup and drop-off location and times, eventually Choose Specific Car to Rent")
	public void tc_01ChooseCarRental() {
		mainPage.closeCookies();
		mainPage.hoverOverGlobeBtn();
		mainPage.chooseLanguage("hebrew");
		mainPage.hoverOverGlobeBtn();
		mainPage.chooseLanguage("english");
		mainPage.scrollToCarRentalSlowly();
		mainPage.closePopUp();
		mainPage.clickCarRental();
		mainPage.moveToCarRentalPage();
		carRentalPage.selectPickUpDate("11", "March 2024");
		carRentalPage.selectReturnDate("18", "March 2024");
		carRentalPage.carRentalInfo("Ireland", "Dublin Airport", "11:00", "Medium", "Dublin Airport", "14:00", "44");
		selectCarPage.waitForTheNewPage();
		selectCarPage.changeCarTypes("Medium", "Large", "Station Wagon", "Premium");
		selectCarPage.bookCar();
		String expected = "Bmw 3";
		String actual = extrasAndUpgradesPage.getSelectedCarName();
		Assert.assertEquals(actual, expected);
	}
}