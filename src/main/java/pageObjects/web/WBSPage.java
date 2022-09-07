package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class WBSPage extends CommonOps{
	
	public WebElement selectCity(String locator) 
	{
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));

	}
	
	public WebElement selectService(String locator) 
	{
		return driver.findElement(By.xpath("//label[contains(text(),'"+locator+"')]"));

	}

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Full name*'])")
	public WebElement fullName;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Company name*'])")
	public WebElement companyName;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Company email*'])")
	public WebElement companyEmail;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Phone number*'])")
	public WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//div[@aria-haspopup='listbox']")
	public WebElement locationDropdwon;
	    
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Get in touch')])[2]")
	public WebElement getInTouch;  
	    						

}