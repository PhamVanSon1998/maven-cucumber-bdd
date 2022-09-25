package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserLoginPageUI;

public class UserLoginPO extends AbtractPage {
	
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		senKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		senKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return pageOpjectsNopcomerce.PageGeneratorManage.getHomePageOjectt(driver);
	}

}
