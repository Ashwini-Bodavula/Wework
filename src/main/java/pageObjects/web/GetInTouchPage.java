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
	
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='First Name*']")
	    public  WebElement firstName;
	    
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Last Name*']")
	    public  WebElement lastName;
	    
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Company Name*']")
	    public  WebElement companyName;
	   
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Company E-mail address*']")
	    public  WebElement companyEmail;
	    
	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Phone number*']")
	    public  WebElement phoneNumber;
	  
	    @FindBy(how = How.XPATH, using = "//div[@id='b8fbcae290c5'] ")
	    public  WebElement locationsDrpdwn;
	    
	    @FindBy(how = How.XPATH, using = "//div[@id='23aed78d1cbe'] ")
	    public  WebElement micromarketDrpdwn;
	    
	    @FindBy(how = How.XPATH, using = "//div[@id='3a50d6c27e95'] ")
	    public  WebElement buildingsDropdown;
	  
	    @FindBy(how = How.XPATH, using = "//div[@id='17ff382e499d'] ")
	    public  WebElement workspaceTypedrpdwn;
	  
	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
	    public  WebElement increaseNoOfDesk;
	    
	    @FindBy(how = How.XPATH, using = "//div[contains(text(),'-')]")
	    public  WebElement decreaseNoOfDesk;
	     
	    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Get in touch')]")
	    public  WebElement getInTouchBtn;
	    
	  
}
