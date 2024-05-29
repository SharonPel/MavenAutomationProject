package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SignupTest extends ApplicationBaseTest {

	@Test
	public void tc_01MoveToSignIn() {
		mainPage.closePopUp();
		mainPage.moveToLogIn();
		loginPage.moveToSignup();
	}

	@Test(dataProvider = "getData", description = "use incorect login information")
	public void tc_02TestCases(String firstName, String lastName, String email, String password, String expected) {
		// login fail
		// using the variables we get from the @DataProvider method
		signupPage.signup1(firstName, lastName, email, password);
		String actual = signupPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { 
				{ "1234", "dana", "s@g.com", "Sh123456", "This field should not contain digits" },
				{ "gal", "&*^%", "rssss@gmail.com", "Sh123456", "This field cannot contain only special characters" },
				{ "yonit", "david", "sharongmail.com", "Sh123456", "Please enter a valid email address" },
				{ "gal", "david", "rstttt@gmail.com", "123", "Incorrect password" },	
		};
		return myData;
	}

	@Test
	public void tc_06SignUpSuccessful() {
		mainPage.moveToLogIn();
		loginPage.moveToSignup();
		signupPage.signup1("Sharon", "Pel", "shar123@gmail.com", "Shalom11");
		String expected = "Confirmation was sent";
		String actual = signupPage.confirmationMsg();
		Assert.assertEquals(actual, expected);
	}
}
