package nopcomerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageOpjectsNopcomerce.PageGeneratorManage;
import pageOpjectsNopcomerce.UserRegisterPO;
import uitilities.FakerCofig;

public class RegisterPageSteps {

	WebDriver driver;
	UserRegisterPO registerPage;
	FakerCofig datatest;
	public String email, password;
	public RegisterPageSteps() {
		driver =Hooks.openAndQuitBrowser();
		registerPage = PageGeneratorManage.getUserRegisterPageObject(driver);
		datatest=FakerCofig.getData();
		email = "phanthuy12333@gmail.com";
		password = "123456";
	}
	
	@When("^check to Gender Male$")
	public void checkToGenderMale() {
	    registerPage.clickToGenderMaleCheckbox();
	}

	@When("^Input to firstName textbox$")
	public void inputToFirstNameTextbox() {
	    registerPage.inputToFirstNameTextbox(datatest.getFirstName());
	    
	}

	@When("^Input to LastName textbox$")
	public void inputToLastNameTextbox() {
	    registerPage.inputToLastNameTextbox(datatest.getLastName());
	}

	@When("^Select Date dropdown$")
	public void selectDateDropdown() {
		registerPage.selectDayDropdown("28");
	}

	@When("^Select Month dropdown$")
	public void selectMonthDropdown() {
		registerPage.selectMonthDropdown("November");
	}

	@When("^Select Year dropdown$")
	public void selectYearDropdown() {
		registerPage.selectYearDropdown("1998");
	    
	}

	@When("^Input to Email textbox$")
	public void inputToEmailTextbox() {
		registerPage.inputToEmailTextbox(email);
	}

	@When("^Input to CompanyName textbox$")
	public void inputToCompanyNameTextbox() {
	    registerPage.inputToCompanyTextbox(datatest.getCompanyName());
	}

	@When("^Input to Password textbox$")
	public void inputToPasswordTextbox() {
		registerPage.inputToPasswordTextbox(password);
	}

	@When("^Input to Confirm Password textbox$")
	public void inputToConfirmPasswordTextbox() {
		registerPage.inputToConfirmPasswordTextbox(password);
	}

	@When("^Click Register Button$")
	public void clickRegisterButton() {
		registerPage.clickToRegisterButton();
	}

	@Then("^Verify Resgister Success$")
	public void verifyResgisterSuccess() {
	    Assert.assertEquals(registerPage.getRegisterMessageSuccess(),"Your registration completed");
	}
	

	@Then("^Click Logout link$")
	public void clickLogoutLink() {
	   registerPage.clickToLogoutLink();
	}
}
