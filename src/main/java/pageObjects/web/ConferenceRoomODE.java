package pageObjects.web;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.qameta.allure.Step;
import utilities.CommonOps;

public class ConferenceRoomODE extends CommonOps {
	
	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//option[contains(text(),'"+locator+"')]"));

	}
	
	public WebElement selectDate(String locator) 
	{
		return driver.findElement(By.xpath("//p[text()= '"+locator+"']"));

	}
	
	public WebElement selectTime(String locator) 
	{
		return driver.findElement(By.xpath("//span[contains(text(),"+locator+"')]"));
		
	}
	
	public WebElement seater(String locator) 
	{
		return driver.findElement(By.xpath("//div[@class='slick-track'] //span[contains(text(),'"+locator+"')]"));
		
	}
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'Conference Room')]")
    public WebElement ConferenceRoom;
	    
	    @FindBy(how = How.XPATH, using = "//select[@placeholder='Select City']")
		public WebElement city;
	    
	    @FindBy(how = How.XPATH, using = "//select[@id='building-selection']")
		public WebElement location;

		@FindBy(how = How.XPATH, using = "//div[@class='search_icon_holder']")
		public WebElement search;
		
		
		@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter No. of Hrs']")
	    public WebElement numberofhours;
		
		@FindBy(how = How.XPATH, using = "//input[@type='button']")
	    public WebElement date;
		
		@FindBy(how = How.XPATH, using = "(//button[contains(@class, 'MuiButtonBase-root-1821 MuiIconButton-root-1813 MuiPickersCalendarHeader-iconButton-1810')]")
	    public WebElement nxt_month;
		
		@FindBy(how = How.XPATH, using = "//p[contains(@class, 'MuiTypography-root-1838 MuiTypography-body1-1840 MuiTypography-alignCenter-1854')]")
	    public WebElement monthName;
		
		
		
		@FindBy(how = How.XPATH, using = "//div[@type='button'] //span[contains(text(),'-')]")
	    public WebElement decreaseHour;
		
		@FindBy(how = How.XPATH, using = "//div[@type='button'] //span[contains(text(),'+')]")
	    public WebElement increaseHours;
	
		@FindBy(how = How.XPATH, using = "//span[@class='MuiIconButton-label-3481']")
		public WebElement calendericon;
		
		
		@FindBy(how = How.XPATH, using = "//div[@class='jss2364'] //span[contains(text(),'Add')]")
	    public WebElement addBtn;

  
}
