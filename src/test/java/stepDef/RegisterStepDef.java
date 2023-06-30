package stepDef;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.github.javafaker.Faker;

import driverHooks.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;

public class RegisterStepDef extends BaseClass {
	
	Faker faker;
	String userName;
	RegistrationPage register;
	
	@When("I provide the required details for registraion")
	public void i_provide_the_required_details_for_registraion() {
		faker = new Faker();
		userName = faker.name().firstName();
		register = new RegistrationPage(driver);
		register.clickRegister();
		register.enterFirstName(userName);
		register.enterLastName(faker.name().lastName());
		register.enterPhone(faker.phoneNumber().phoneNumber());
		register.enterEmail(userName.concat("@gmail.com"));
		register.enterAddress(faker.address().buildingNumber());
		register.enterCity(faker.address().city());
		register.enterState(faker.address().state());
		register.enterPostCode(faker.address().zipCode());
		register.selectCountry();
		register.enterUsername(userName);
		register.enterPassword("Password123");
		register.enterConfirmPassword("Password123");
	  	register.clickSubmit();
	  	wait.until(ExpectedConditions.urlContains("register_sucess"));
	  	
		
	}

	@Then("I should be registered successfully")
	public void i_should_be_registered_successfully() {
		register.verifySuccessfulRegistraion();
	}

}
