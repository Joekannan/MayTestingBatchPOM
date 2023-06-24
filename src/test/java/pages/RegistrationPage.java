package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
	
	WebDriver driver;
	
	public By lnkRegister = By.linkText("REGISTER");
	public By txtFirstName = By.name("firstName");
	public By txtLastName = By.name("lastName");
	public By txtPhone = By.name("phone");
	public By txtEmail = By.name("userName");
	public By txtAddress = By.name("address1");
	public By txtCity = By.name("city");
	public By txtState = By.name("state");
	public By txtPostalCode = By.name("postalCode");
	public By lstCountry = By.name("country");
	public By txtUserName = By.name("email");
	public By txtPassword = By.name("password");
	public By txtConfirmPassword = By.name("confirmPassword");
	public By btnSubmit = By.name("submit");
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegister() {
		driver.findElement(lnkRegister).click();	
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(txtFirstName).sendKeys(firstName);	
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(txtLastName).sendKeys(lastName);	
	}
	
	public void enterPhone(String phone) {
		driver.findElement(txtPhone).sendKeys(phone);	
	}
	
	public void enterEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);	
	}
	
	public void enterAddress(String address) {
		driver.findElement(txtAddress).sendKeys(address);	
	}
	
	public void enterCity(String city) {
		driver.findElement(txtCity).sendKeys(city);	
	}
	
	public void enterState(String state) {
		driver.findElement(txtState).sendKeys(state);	
	}
	
	public void enterPostCode(String postCode) {
		driver.findElement(txtPostalCode).sendKeys(postCode);	
	}
	
	public void selectCountry() {
		Select objCountry = new Select(driver.findElement(lstCountry));
		objCountry.selectByIndex(10);
	}

	public void enterUsername(String username) {
		driver.findElement(txtUserName).sendKeys(username);	
	}
	public void enterPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);	
	}
	public void enterConfirmPassword(String password) {
		driver.findElement(txtConfirmPassword).sendKeys(password);	
	}
	public void clickSubmit() {
		driver.findElement(btnSubmit).click();
	}
	
	public void verifySuccessfulRegistraion() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("register_sucess"));
	}
	
}
