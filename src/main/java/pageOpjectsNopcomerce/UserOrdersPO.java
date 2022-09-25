package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserMyProductReViewPageUI;
import pageUINopcomerce.UserOrdersPageUI;

public class UserOrdersPO extends AbtractPage {
	WebDriver driver;
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
}
