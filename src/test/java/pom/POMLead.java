package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMLead {
	
	@FindBy (xpath="//a[text()='Leads'][1]")
	private WebElement leadmodule;
	
	@FindBy(xpath="//img[@title=\"Create Lead...\"]")
	private WebElement leadplusicon;
	
	@FindBy(name="lastname")
	private WebElement lastnamelead;
	
   @FindBy(name="company")
   private WebElement companylead;
   
   @FindBy(name="button")
   private WebElement savelead;
   
   public POMLead(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void leadmodule()
   {
	   leadmodule.click(); 
   }
   
   public void leadplusicon()
   {
	   leadplusicon.click();
   }
   
   public void lastnamelead(String lastnamelead)
   {
	  this.lastnamelead.sendKeys(lastnamelead); 
   }
   
   public void companylead(String companylead)
   {
	   this.companylead.sendKeys(companylead);
   }
   
   public void save()
   {
	   savelead.click();
   }
   
   
   
}
