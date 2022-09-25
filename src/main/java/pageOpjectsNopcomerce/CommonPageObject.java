package pageOpjectsNopcomerce;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUINopcomerce.CommonPageUI;
import pageUINopcomerce.UserRegisterPageUI;

public class CommonPageObject extends AbtractPage{
	WebDriver driver;
	public CommonPageObject(WebDriver mapDriver) {
		this.driver =mapDriver;
	}
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitToElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		senKeysToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void checkTocheckboxByID(WebDriver driver, String radioButtonID) {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
		clickToElement(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radioButtonID);
	}

	public void selectDropdownByName(WebDriver driver, String dropdownName, String value) {
		waitToElementVisible(driver, CommonPageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDropdown(driver, CommonPageUI.DYNAMIC_DROPDOWN_BY_NAME, value, dropdownName);
	}

	public void clickToButtonByClass(WebDriver driver, String buttonClass) {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON_BY_CLASS, buttonClass);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON_BY_CLASS, buttonClass);
	}

	public void clickToFooterLinkByClass(WebDriver driver, String footerLinkClass) {
		waitToElementClickable(driver, CommonPageUI.DYNAMIC_FOOTER_LINK_BY_CLASS, footerLinkClass);
		clickToElement(driver, CommonPageUI.DYNAMIC_FOOTER_LINK_BY_CLASS, footerLinkClass);
	}
	
	public String getRegisterMessageSuccess() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getElementText(driver, UserRegisterPageUI.REGISTER_MESSAGE_SUCCESS);
	}
}
