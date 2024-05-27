package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TripPurposeTest extends ApplicationBaseTest {

	@Test
	public void tc_01ChoosePurpose() {
		mainPage.closeCookies();
//		mp.hoverOverGlobeBtn();
//		mp.chooseLanguage("english");
		mainPage.closePopUp();
		mainPage.buildYourOwnTrip();
		basicsPage.inspireMe();
		journeyDatesPage.setFlexDates();
		try {
			tripPurposePage.chooseTripPurpose("ספורט");
		} catch (Exception e) {
		}
		try {
			tripPurposePage.chooseTripPurpose("Sport");
		} catch (Exception e) {
		}
		interestsPage.rateInterest(1, 2, 3, 4, 5, 6, 7, 8);
		interestsPage.showResults();
		suggestionsPage.chooseOneSuggestion("mykonos");
		String expected = "Your personalized trip to London";
		String actual = destinationsPage.getOopsMsg();
		Assert.assertEquals(actual, expected);
	}
}
