package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pom.POMLead;
import pom.POMLoginPage;
import pom.POMOrganizations;
import pom.WebDriverUtility;

public class StepDefination extends BaseClass {
	
	
	
//	@Before("Smoke")
//	public void sanity()
//	{
//		
//		System.out.println("sanity");
//	}
//
//	@Before(order=2)
//	public void priority()
//	{
//		System.out.println("priority =2");
//	}
	
	
	
	@Before(order=1)
	public void setup() {

		log1=LogManager.getLogger("StepDefination");
		System.out.println("priority=1");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		
	}

	@Given("Launch The Browser")
	public void launch_the_browser() {
		log1.info("setup -1");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Given("Navigate URL {string}")
	public void navigate_url(String url) {
		driver.get(url);
		log = new POMLoginPage(driver);
		lead = new POMLead(driver);
		org = new POMOrganizations(driver);
		log1.info("setup -2");

	}

	@When("Insert Valid Cradencial username {string} password {string}")
	public void insert_valid_cradencial_username_password(String user, String pwd) {
		log1.info("setup -3");

		log.username(user);
		log.pwd(pwd);
	}

	@When("Click On Login Icon")
	public void click_on_login_icon() {
		log.button();
	}

	@Then("HomePage Should Be Displayed")
	public void home_page_should_be_displayed() {
		
		WebDriverWait wait=new WebDriverWait(driver ,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Administrator"));
		WebElement admi=driver.findElement(By.xpath("//span[text()=' Administrator']"));
        String actualResult=  admi.getText();
       String expected="Administrator";
        Assert.assertEquals(actualResult, expected);
		
	}

	@Then("Logout Application")
	public void logout_application() {

		System.out.println("hii");
	}

/////////////////////lead////////////////////
	@Then("click on Lead Module")
	public void click_on_lead_module() {
		lead.leadmodule();
	}

	@Then("Create lead")
	public void create_lead() {
		lead.leadplusicon();
	}

	@Then("Insert lastname {string}  company {string}")
	public void insert_lastname_company(String lastname, String company) {
		lead.lastnamelead(lastname);
		lead.companylead(company);

	}

	@Then("Save Lead")
	public void save_lead() {
		lead.save();
	}

	//////////// Organization///////////

	@Then("click on Organizations Module")
	public void click_on_organizations_module() {
		org.organization();

	}

	@Then("Create Organizations")
	public void create_organizations() {
		org.orgcreate();

	}

	@Then("Insert Organizations name {string}")
	public void insert_organizations_name(String name) {
		web1 = new WebDriverUtility();
		org.orgname(web1.randomorganizationname());
	}

	@Then("Save organizations")
	public void save_organizations() throws InterruptedException {
    org.saveorg();

	}

	@After(order=1)
	public void teardown1(Scenario sc) throws IOException {
		
		if(sc.isFailed()==true)
		{
			TakesScreenshot screen=(TakesScreenshot)driver;
			File src= screen.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\eclipse\\VTigerFull\\Screenshot\\Error.jpg");
			Files.copy(src, trg);
			
		    }
		
		
		System.out.println("order=1");
		log.mouse(driver);
		log.signout();
		driver.close();
	}
	
//	@After(order=2)
//	public void teardown2() {
//		System.out.println("order=2");


//	}

//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("Befor Step");
//	}
//
//	@AfterStep
//	public void afterstep() {
//		System.out.println("After step");
//	}
	@AfterStep
	public void takescreenshot(Scenario scenario)
	{
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/jpg", scenario.getName());
	
	}
	

}
