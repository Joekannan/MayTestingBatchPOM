package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RegistrationPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {
	
	WebDriver driver;
	Faker faker;
	String userName;
	WebDriverWait wait;
  

	@BeforeMethod
	public void setUp() {
		  faker = new Faker();
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://demo.guru99.com/test/newtours/");
	}

  @Test
  public void verifyRegistraion() {
	  userName = faker.name().firstName();
	  RegistrationPage register = new RegistrationPage(driver);
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
	  register.verifySuccessfulRegistraion();
  }
  
 
  @AfterMethod
  public void tearDown() {
	  driver.close();
	  driver.quit();
  }

}
