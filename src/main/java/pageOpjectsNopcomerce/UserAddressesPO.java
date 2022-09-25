package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserAddressesPageUI;

public class UserAddressesPO extends AbtractPage {
	WebDriver driver;
	private Object OrderPageUI;
	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}
}
