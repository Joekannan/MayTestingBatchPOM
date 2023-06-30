package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	WebDriver driver;
	WebDriverWait wait;
  
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://demo.guru99.com/test/newtours/");
  }
 
  @Test
  public void verifyLogin() {
	  
	  LoginPage objLogin = new LoginPage(driver);
	  objLogin.enterUsername("Caroline");
	  objLogin.enterPassword("Password123");
	  objLogin.clickSubmit();
	  wait.until(ExpectedConditions.urlContains("login_success"));
	  objLogin.verifySuccessfulLogin();
  }
 

  @AfterMethod
  public void tearDown() {
	  driver.close();
	  driver.quit();
  }

}
