package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserHomePageUI;

public class UserHomePO extends AbtractPage{
	WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return pageOpjectsNopcomerce.PageGeneratorManage.getUserRegisterPageObject(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return pageOpjectsNopcomerce.PageGeneratorManage.getLoginPageOject(driver);
	}

	public boolean isMyAcountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInforPO clickToMyAcountLink() {
		waitToElementClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);	
		return pageOpjectsNopcomerce.PageGeneratorManage.getUserCustomerInforPageObject(driver);
	}

	public boolean isRegisterLinkUnDisplayed() {
		waitToElementInVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkUnDisplayed() {
		waitToElementInVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

	public boolean isRegisterLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}

}
