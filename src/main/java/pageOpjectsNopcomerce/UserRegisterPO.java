package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserRegisterPageUI;

public class UserRegisterPO extends AbtractPage {
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToGenderMaleCheckbox() {
		waitToElementClickable(driver, UserRegisterPageUI.GENDER_MALE_CHECKBOX);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_CHECKBOX);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		senKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_CHECKBOX);
		senKeysToElement(driver, UserRegisterPageUI.LASTNAME_CHECKBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		senKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
		senKeysToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.COMFIRM_PASSWORD_TEXTBOX);
		senKeysToElement(driver, UserRegisterPageUI.COMFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegisterMessageSuccess() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getElementText(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS);
	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return pageOpjectsNopcomerce.PageGeneratorManage.getHomePageOjectt(driver);
	}

}
