package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class ReferralsPage extends CommonOps{
	
	public WebElement selectLocation(String locator) 
	{
		return driver.findElement(By.xpath(" (//li[contains(text(),'"+locator+"')])[2]"));
		
	}
	
	public WebElement selectWorkspace(String locator) 
	{
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
		
	}

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'How does the WeWork Referral program work?')]")
    public  WebElement FAQ1;
  
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'https://wework.co.in/referrals')]")
    public  WebElement referralLinkInFAQ1;
  
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Get Started')]")
    public  WebElement getStartedBtn;
    
    public WebElement select(String locator) 
	{
		return driver.findElement(By.xpath("//input[@placeholder='"+locator+"*']"));
		
	}
    
    @FindBy(how = How.XPATH, using = "//div[@id='a2d9703f3cb9']")
    public  WebElement preferredOfficeLocationDropdwon;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ce84839b1f45']")
    public  WebElement workspaceIntrestedInDrpdwn;
    
    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'+')])[1]")
    public  WebElement increaseNoOfDesk;
    
    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'-')])[1]")
    public  WebElement decreaseNoOfDesk;
     
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add Referral')]")
    public  WebElement addReferralBtn;
    		
    @FindBy(how = How.XPATH, using = "//div[@class='error_field active']")
    public  WebElement errorMessage;	
	

}
