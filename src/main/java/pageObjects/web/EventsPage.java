package pageObjects.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class EventsPage extends CommonOps
{

	public WebElement select(String locator) 
	{
		return driver.findElement(By.xpath("//*[name()='svg'][@data-testid='"+locator+"']"));
		
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
		return driver.findElement(By.xpath("//li[@data-value='"+locator+"']"));
	}
	
	public WebElement selectRadioBtn(int index) 
	{
		return driver.findElement(By.xpath("(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])["+index+"]"));
	}
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
    public WebElement plusIcon;
    
    public WebElement selectdropDown(String locator) 
	{		
		return driver.findElement(By.xpath("//label[contains(text(),'"+locator+"')]/following-sibling::div//*[name()='svg'][@data-testid='ArrowDropDownIcon']"));		
	}
    
    public WebElement selectRadioButton(String locator, String value)
   	{
    	return driver.findElement(By.xpath("//div/p[contains(text(),'"+locator+"')]/following-sibling::div/div/label/span/input[@value='"+value+"']/following-sibling::span//*[name()='svg'][1]"));  		
   	}
    
    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Workshops')]")
    public WebElement selectWorkshops;
    
    @FindBy(how = How.XPATH, using = "//input[@placeholder='dd/mm/yyyy']")
    public WebElement dateField;
    
    @FindBy(how = How.XPATH, using = "//input[@placeholder='hh:mm (a|p)m']")
    public WebElement timeField;
   
    
}
