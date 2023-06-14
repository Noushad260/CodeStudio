package TestRunner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"./src/test/resources/feature/Lead.feature","./src/test/resources/feature/LogInpageVTiger.feature"},
		glue= {"StepDefinition"},
		tags="@Smoke",
		dryRun=false,
		//plugin={"pretty","html:target/cucumber-reports/reports_html.html","json:target/cucumber-reports/json_report.json","junit:target/cucumber-reports/reports_xml.xml"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}  
		
		)
public class LogInTestRunner extends AbstractTestNGCucumberTests{

}
 