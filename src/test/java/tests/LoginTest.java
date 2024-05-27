package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//import pageobjects.LoginPage;

public class LoginTest extends ApplicationBaseTest {

	@Test
	public void tc_01LoginPassFail() {
		loginPage.closePopUp();
		loginPage.closeCookies();
		loginPage.moveToSignin();
		loginPage.login("sharon@gmail.com", "blabla5555");
		String expected = "Unable to log in with provided credentials.";
		String actual = loginPage.errorMesg();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void tc_02Login() {
		loginPage.login("sharoni@gmail.com", "Shalom11");
		String actual = loginPage.loginSuccessMsg();
		String expected = "Hi, Sharon";
		Assert.assertEquals(actual, expected);
	}
}
