package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.UserCustomerInforPageUI;

public class UserCustomerInforPO extends AbtractPage {
	public UserCustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isGenderMaleCheckboxIsSelected() {
		waitToElementVisible(driver,UserCustomerInforPageUI.GENDER_MALE_CHECKBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_CHECKBOX);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.NEWLETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.NEWLETTER_CHECKBOX);
	}
}
