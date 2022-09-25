package nopcomerce.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageOpjectsNopcomerce.PageGeneratorManage;
import pageOpjectsNopcomerce.UserLoginPO;

public class LoginPage {
	public LoginPage() {
		driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManage.getLoginPageOject(driver);
	}

	WebDriver driver;
	UserLoginPO loginPage;
	RegisterPageSteps registerPageSteps;
	@Then("^Input to Email textbox in LoginPage$")
	public void inputToEmailTextboxInLoginPage()  {
		loginPage.inputToEmailTextbox("phanthuy12333@gmail.com");
	    
	}

	@Then("^Input to Password textbox in LoginPage$")
	public void inputToPasswordTextboxInLoginPage()  {
	   loginPage.inputToPasswordTextbox("123456");
	    
	}

	@Then("^Click to Login Button$")
	public void clickToLoginButton()  {
	    loginPage.clickToLoginButton();
	}
}
