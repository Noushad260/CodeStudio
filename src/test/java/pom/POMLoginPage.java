package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMLoginPage {
	public WebDriverUtility web;
	
  WebDriver driver;
	@FindBy(name = "user_name")
	private WebElement user;

	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement button;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement home;

	@FindBy(xpath = "(//td[@class=\"genHeaderSmall\"]/following-sibling::td[@class=\"small\"])[1]")
	private WebElement signoutmouse;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;

	public POMLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	     }


	public void username(String username) {
		user.sendKeys(username);
         }

	public void pwd(String pwd1) {
		pwd.sendKeys(pwd1);
	}

	public void button() {
		this.button.click();
	}

	public void mouse(WebDriver driver) {
		web=new WebDriverUtility();
		web.movetoelement(driver,signoutmouse );
        }

	public void signout() {
		signout.click();
	}

}
