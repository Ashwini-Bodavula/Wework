package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class EnterprisePage extends CommonOps
{
	public WebElement selectCity(String locator)
	{
		return driver.findElement(By.xpath("(//div[contains(@class,'city_card')] //p[contains(text(),'"+locator+"')])[2]"));

	}

	public WebElement selectLocation(String locator)
	{
		return driver.findElement(By.xpath("(//a[@class='building_container_list']//p[contains(text(),'"+locator+"')])[2]"));

	}

	public WebElement selectNoOfPeople(String locator)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'"+locator+"')]"));

	}
	public WebElement selectCompanySize(String locator)
	{
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));

	}

	@FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiTab-iconWrapper'])[2]")
    public WebElement enterpriseBtn;
	
	
	
	 public WebElement selectDropdown(int index)
	{
		return driver.findElement(By.xpath("(//div[@class='ray-dropdown'])["+index+"]"));
	}

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Explore Solutions')]")
    public  WebElement exploreSolnBtn;
    
    public WebElement selectEnterpriseType(int index)
	{
		return driver.findElement(By.xpath("(//div[contains(@class,'MuiGrid-grid-xs-3.7')])["+index+"]"));
	}

    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Get in touch')])[2]")
    public  WebElement getInTouchBtnForSoln;

    public WebElement enter(String locator)
   	{
   		return driver.findElement(By.xpath("//input[@placeholder='"+locator+"*']"));

   	}
 
    @FindBy(how = How.XPATH, using = "//div[@id='09effc33c4f7']")
    public  WebElement companySizeDrpdwn;
    
    
    public WebElement selectRadioButton(String locator)
   	{
    	if(locator.equalsIgnoreCase("yes"))
    	{
    		return driver.findElement(By.xpath("(//span[contains(@class,'PrivateSwitchBase-root')])[2]"));
    	}
    	else
    	{
    		return  driver.findElement(By.xpath("(//span[contains(@class,'PrivateSwitchBase-root')])[3]"));
    	}
   	}
    
    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[2]")
    public  WebElement getInTouchButtonForSumbtn;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='close']")
    public  WebElement closeBtn;

}
