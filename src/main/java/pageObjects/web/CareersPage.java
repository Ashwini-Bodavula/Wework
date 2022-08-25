package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class CareersPage extends CommonOps{

	public WebElement selectWorkspace(String locator) 
	{
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
		
	}
	
	
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Join Us')]")
    public  WebElement joinUsBtn;
    
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Openings')]")
    public  WebElement viewopeningsBtn;
    
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'MuiCheckbox')]")
    public  WebElement jobOportunitiescheckBox; 
  
    @FindBy(how = How.XPATH, using = "(//button[@type='submit'])[1]")
    public  WebElement submitButton; 
	
    @FindBy(how = How.XPATH, using = "//input[@placeholder='First Name*']")
    public  WebElement firstName; 
    
  
    
}