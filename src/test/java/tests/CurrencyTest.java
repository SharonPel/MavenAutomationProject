package tests;

import org.testng.annotations.Test;

public class CurrencyTest extends ApplicationBaseTest {
	@Test
	public void tc_01SelectCurrency() {
		mainPage.closeCookies();
		mainPage.closePopUp();
		mainPage.chooseCurrency("euro");
	}
}
