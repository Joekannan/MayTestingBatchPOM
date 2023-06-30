package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import driverHooks.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources",
        glue="stepDef",
        plugin = { "json:target/cucumber-reports/cucumber.json",
                "pretty", "html:target/html-report/cucumber-html-reports.html",
                "junit:target/cucumber-reports/cucumber.xml" }
        )


public class CucumberRunner extends AbstractTestNGCucumberTests {

	@BeforeMethod
	public void setUp() {
		BaseClass.driverCreation();
	}
	
	@AfterMethod
	public void tearDoiwn() {
		BaseClass.driverClosure();
	}
}
