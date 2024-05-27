package tests;

import org.testng.annotations.BeforeMethod;
import pageobjects.BasicsPage;
import pageobjects.CarRentalPage;
import pageobjects.DestinationsPage;
import pageobjects.ExploreDestinationPage;
import pageobjects.ExtrasAndUpgradesPage;
import pageobjects.InterestsPage;
import pageobjects.JourneyDatesPage;
import pageobjects.LaTourEiffelPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.SelectCarPage;
import pageobjects.SignupPage;
import pageobjects.SuggestionsPage;
import pageobjects.TripPurposePage;

public class ApplicationBaseTest extends BaseTest{

	protected BasicsPage basicsPage;
	protected CarRentalPage carRentalPage;
	protected DestinationsPage destinationsPage;
	protected ExploreDestinationPage exploreDestinationPage;
	protected ExtrasAndUpgradesPage extrasAndUpgradesPage;
	protected InterestsPage interestsPage;
	protected JourneyDatesPage journeyDatesPage;
	protected LaTourEiffelPage laTourEiffelPage;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected SelectCarPage selectCarPage;
	protected SignupPage signupPage;
	protected SuggestionsPage suggestionsPage;
	protected TripPurposePage tripPurposePage;

	@BeforeMethod
	public void setupPageObjects() {
		basicsPage = new BasicsPage(driver);
		carRentalPage = new CarRentalPage(driver);
		destinationsPage = new DestinationsPage(driver);
		exploreDestinationPage = new ExploreDestinationPage(driver);
		extrasAndUpgradesPage = new ExtrasAndUpgradesPage(driver);
		interestsPage = new InterestsPage(driver);
		journeyDatesPage = new JourneyDatesPage(driver);
		laTourEiffelPage = new LaTourEiffelPage(driver);
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		selectCarPage = new SelectCarPage(driver);
		signupPage = new SignupPage(driver);
		suggestionsPage = new SuggestionsPage(driver);
		tripPurposePage = new TripPurposePage(driver);
	}
}
