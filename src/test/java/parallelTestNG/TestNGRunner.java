package parallelTestNG;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"parallelTestNG"},
		plugin = {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "timeline:test-output-thread"
		},
		monochrome = true
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
