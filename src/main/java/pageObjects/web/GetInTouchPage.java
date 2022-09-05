package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class GetInTouchPage extends CommonOps
{

		public WebElement select(String locator)
		{
			return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
		}
		
		public WebElement enter(String locator)
		{
			return driver.findElement(By.xpath("//input[@placeholder='"+locator+"*']"));
		}
	    
	    public WebElement selectDropdown(int locator)
		{
			return driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])["+locator+"]"));
		}
	  
	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
	    public  WebElement increaseNoOfDesk;
	    
	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'-')]")
	    public  WebElement decreaseNoOfDesk;
	     
	    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Get in touch')]")
	    public  WebElement getInTouchBtn;
	    
	  
}
