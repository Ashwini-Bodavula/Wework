package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class VirtualOfficePage extends CommonOps
{
	 @FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	    public  WebElement nextBtn;

	    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
	    public  WebElement checkoutBtn;

//	    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'jss801')])[1]")
//	    public  WebElement planfor6Months;
//
//	    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'jss801')])[2]")
//	    public  WebElement planfor12Months;
//
//	    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'jss801')])[3]")
//	    public  WebElement planfor24Months;

	    public WebElement verifyLocation(String locator)
		{
			return driver.findElement(By.xpath("(//*[contains(text(),'"+locator+"')])[1]"));

		}


}
