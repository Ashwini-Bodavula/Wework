package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class EventsPage extends CommonOps
{

	

	public WebElement select(String locator) 
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));
		
	}
	public WebElement commonlocator(String locator) 
	{
		return driver.findElement(By.xpath("//li[text()='"+locator+"']"));
	}
	
	public WebElement opt(String locator) 
	{
		return driver.findElement(By.xpath("//input[@placeholder='"+locator+"']"));
	}
	
	public WebElement selectDate(String locator) 
	{
		return driver.findElement(By.xpath("//button[text()='"+locator+"']"));
	}
	
	public WebElement selectHour(String locator) 
	{
		return driver.findElement(By.xpath("//span[@aria-label='"+locator+"']"));
	}
	
	public WebElement selectMinute(String locator) 
	{
		return driver.findElement(By.xpath("//div //span[@aria-label='"+locator+"']"));
	}
	
	public WebElement selectlocation(String locator) 
	{
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
	}
	
	
	
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[1]")
    public WebElement yesRadioBtn1;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[2]")
    public WebElement noRadioBtn1;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[3]")
    public WebElement notSureRadioBtn;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[4]")
    public WebElement yesRadioBtn2;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[5]")
    public WebElement noRadioBtn2;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[6]")
    public WebElement yesRadioBtn3;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[7]")
    public WebElement noRadioBtn3;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[8]")
    public WebElement FAndBradioBtn;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[9]")
    public WebElement productionRadioBtn;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[10]")
    public WebElement otherRadioBtn;
    
    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public WebElement calendarIcon;
    
    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='ClockIcon']")
    public WebElement clockIcon;
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
    public WebElement plusIcon;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='ArrowDropDownIcon'])[1]")
    public WebElement cityDropdown;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='ArrowDropDownIcon'])[2]")
    public WebElement buildingDropdown;
    
    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='ArrowDropDownIcon'])[3]")
    public WebElement eventTypeDropdown;
	

}
