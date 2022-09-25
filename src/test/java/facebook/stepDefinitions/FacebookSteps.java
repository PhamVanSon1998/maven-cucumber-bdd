package facebook.stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSteps {
	WebDriver driver;
	@Before()
	public void openFacebookApplication()  {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@After()
	public void closeApplications()  {
		driver.quit();
	}

	@When("^Input to email textbox$")
	public void inputToEmailTextbox()  {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("phanthuy@gmail.com");
	}

	@When("^Input to password textbox$")
	public void inputToPasswordTextbox()  {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("281198");
	}

	@When("^Input to email textbox with \"([^\"]*)\"$")
	public void inputToEmailTextboxWith(String email)  {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
	}

	@When("^Input to password textbox with \"([^\"]*)\"$")
	public void inputToPasswordTextboxWith(String password)  {
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@When("^Input to email textbox with \"([^\"]*)\" and password with \"([^\"]*)\"$")
	public void inputToEmailTextboxWithAndPasswordWith(String email, String password)  {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	@When("^Input to email and password$")
	public void inputToEmailAndPassword(DataTable table)  {
		List<Map<String, String>> customer = table.asMaps(String.class, String.class);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(customer.get(0).get("username"));
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(customer.get(0).get("password"));
	
		for(Map<String, String> loginInfor:table.asMaps(String.class, String.class)) {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(loginInfor.get("username"));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(loginInfor.get("password"));
		}
	}

	@When("^Click to submit button$")
	public void clickToSubmitButton()  {
	   driver.findElement(By.name("login")).click();
	}

}
