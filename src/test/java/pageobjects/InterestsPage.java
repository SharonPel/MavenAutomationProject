package pageobjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterestsPage extends BasePage {

	@FindBy(css = ".interests-list__item--slider")
	List<WebElement> interestsList;

	@FindBy(css = ".btn-blue.btn")
	private WebElement showResultsBtn;

	public InterestsPage(WebDriver driver) {
		super(driver);
	}

	// move sliders by level of interest
	public void rateInterest(int gallery, int Attrac, int show, int gastro, int shop, int night, int recreation,
			int sport) {
		List<Integer> list = Arrays.asList(gallery, Attrac, show, gastro, shop, night, recreation, sport);
		for (int counter = 0; counter < list.size(); counter++) {
			WebElement el = interestsList.get(counter);
			int slider_rail_width = el.findElement(By.cssSelector(".rc-slider-rail")).getSize().width;
			act.clickAndHold(el.findElement(By.cssSelector(".rc-slider-handle"))).pause(Duration.ofMillis(400)).build()
					.perform();
			act.moveByOffset(slider_rail_width / 10 * list.get(counter) - 6, 0).build().perform();
			act.release().build().perform();
		}
	}

	public void showResults() {
		click(showResultsBtn);
	}
}
