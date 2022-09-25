package nopcomerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageOpjectsNopcomerce.CommonPageObject;
import pageOpjectsNopcomerce.PageGeneratorManage;
import pageOpjectsNopcomerce.UserHomePO;

public class CommonPageSteps {
	WebDriver driver;
	CommonPageObject commonPage;

	public CommonPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		commonPage = PageGeneratorManage.getCommonPageObject(driver);
	}

@When("^Click \"([^\"]*)\" link$")
public void clickLink(String fieldName)  {
    commonPage.clickToFooterLinkByClass(driver, fieldName);
}

@When("^check to \"([^\"]*)\" checkbox$")
public void checkToCheckbox(String checkboxvalue)  {
    commonPage.checkTocheckboxByID(driver, checkboxvalue);
}

@When("^Input to \"([^\"]*)\" textbox with value \"([^\"]*)\"$")
public void inputToTextboxWithValue(String fieldName, String inputvalue)  {
    commonPage.inputToTextboxByID(driver, fieldName, inputvalue);
}

@When("^Select \"([^\"]*)\" dropdown with value \"([^\"]*)\"$")
public void selectDropdownWithValue(String fieldName, String inputvalue)  {
    commonPage.selectDropdownByName(driver, fieldName, inputvalue);
}

@When("^Input to \"([^\"]*)\" textbox in LoginPage with value \"([^\"]*)\"$")
public void inputToTextboxInLoginPageWithValue(String fieldName, String inputvalue)  {
	commonPage.inputToTextboxByID(driver, fieldName, inputvalue);
}

@When("^Click to \"([^\"]*)\" button$")
public void clickToButton(String buttonValue)  {
	commonPage.clickToButtonByClass(driver, buttonValue);
}

@Then("^Verify Resgister Success with Dynamic locator$")
public void verifyResgisterSuccessWithDynamicLocator() {
    Assert.assertEquals(commonPage.getRegisterMessageSuccess(), "Your registration completed");
}

}
