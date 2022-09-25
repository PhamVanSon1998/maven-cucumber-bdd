package nopcomerce.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageOpjectsNopcomerce.PageGeneratorManage;
import pageOpjectsNopcomerce.UserHomePO;

public class HomePageSteps {
	WebDriver driver;
	UserHomePO homepage;

	public HomePageSteps() {
		driver = Hooks.openAndQuitBrowser();
	}

	@Given("^Open Home page$")
	public void openHomePage() {
		homepage=PageGeneratorManage.getHomePageOjectt(driver);
	}

	@When("^Click Register link$")
	public void clickRegisterLink() {
	    homepage.clickToRegisterLink();
	    
	}

	@Then("^Click Login link$")
	public void clickLoginLink() {
	   homepage.clickToLoginLink();
	}

}
