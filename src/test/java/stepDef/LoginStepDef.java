package stepDef;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import driverHooks.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDef extends BaseClass {
	
	LoginPage objLogin;
	
	
	@Given("User is on homepage")
	@Given("I am on homepage")
	public void user_is_on_homepage() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Welcome: Mercury Tours"));
	}

	@When("User enters valid crendentials")
	public void user_enters_valid_crendentials() {
		objLogin = new LoginPage(driver);
		objLogin.enterUsername("Caroline");
		objLogin.enterPassword("Password123");
		objLogin.clickSubmit();
		wait.until(ExpectedConditions.urlContains("login_success"));
		
	}

	
	@When("User enters {string} and {string}")
	@When("I enter {string} and {string}")
	public void user_enters_and(String username, String password) {
		objLogin = new LoginPage(driver);
		objLogin.enterUsername(username);
		objLogin.enterPassword(password);
		objLogin.clickSubmit();
		wait.until(ExpectedConditions.urlContains("login_success"));
	}
	
	
	@Then("User should be logged in successfully")
	@Then("I should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		objLogin.verifySuccessfulLogin();
	}
	
}
