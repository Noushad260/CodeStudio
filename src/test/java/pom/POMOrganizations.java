package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMOrganizations {

	public POMOrganizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Organizations'][1]")
	private WebElement organization;

	@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
	private WebElement orgplus;

	@FindBy(name = "accountname")
	private WebElement orgname;

	@FindBy(name = "button")
	private WebElement saveorg;

	public void organization() {
		organization.click();
	}

	public void orgcreate() {
		orgplus.click();
	}

	public void orgname(String orgname) {
		this.orgname.sendKeys(orgname);
	}

	public void saveorg() {
		saveorg.click();
	}



}
