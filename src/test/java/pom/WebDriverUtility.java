package pom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	public WebDriver driver;
	public Actions action;
	public void movetoelement(WebDriver driver,WebElement Element)
	{
		action=new Actions(driver);
		action.moveToElement(Element).perform();
	}

	public String randomorganizationname()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}


	
	
}
