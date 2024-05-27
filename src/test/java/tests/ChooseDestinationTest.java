package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ChooseDestinationTest extends ApplicationBaseTest{
	
	@Test
	public void tc_01ChooseDestination() {
		destinationsPage.closePopUp();
		mainPage.closeCookies();
		mainPage.moveToDestination();
		destinationsPage.searchForDestination("paris");
		destinationsPage.scrollToDestination();
		destinationsPage.findDestinationName("paris, france");
		exploreDestinationPage.moveToOption("top places");
		exploreDestinationPage.choosePlace("la tour eiffel");
		exploreDestinationPage.moveToEiffelTourWindow();
		Assert.assertTrue(laTourEiffelPage.isLaTourEiffel());
		
	}
}
