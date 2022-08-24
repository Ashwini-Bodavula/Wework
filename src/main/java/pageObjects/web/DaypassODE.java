package pageObjects.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class DaypassODE extends CommonOps
{
	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//option[contains(text(),'"+locator+"')]"));

	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//p[text()='"+locator+"']"));

	}
	
	public WebElement selectBuilding(String locator)
	{
		return driver.findElement(By.xpath("//p[text()='"+locator+"']"));

	}
	    
	    @FindBy(how = How.XPATH, using = "//select[@placeholder='Select City']")
		public WebElement city;

		@FindBy(how = How.XPATH, using = "//select[@id='building-selection']")
		public WebElement location;

		@FindBy(how = How.XPATH, using = "//div[@class='search_icon_holder']")
		public WebElement search;
		
		@FindBy(how = How.XPATH, using = "//h3[contains(@class, 'ray-text--h3')]")
	    public WebElement dialogue;
		
		@FindBy(how = How.XPATH, using = "//h3[contains(text(), 'Select a Building')]")
	    public WebElement building_pop;
		
		@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Continue')]")
	    public WebElement Continue;

		@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Cancel')]")
	    public WebElement cancel;

		@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Skip')]")
	    public  WebElement skipPay;
		
		@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Back')]")
	    public WebElement back;
		
		@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Finish')]")
	    public WebElement finish;		
		
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Discard')]")
	    public WebElement discard;
		
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Others')]")
	    public WebElement others;
		
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Myself')]")
	    public WebElement mySelf;
				
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'success')]")
	    public WebElement msg;
		
		@FindBy(how = How.XPATH, using = "//span[@class='MuiIconButton-label']")
	    public WebElement msg_close;
		
		@FindBy(how = How.XPATH, using = "(//button[contains(@class, 'MuiPickersCalendar')])[2]/span")
	    public WebElement nxt_month;
		
		@FindBy(how = How.XPATH, using = "//p[contains(@class, 'MuiTypography-alignCenter')]")
	    public WebElement monthName;
		
		@FindBy(how = How.XPATH, using = "//input[@id='searchtextfield']")
	    public WebElement otherssearch;
		
		@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	    public WebElement otherssel;
		
		@FindBy(how = How.XPATH, using = "(//button[@class='csaf9s-1 hiLBpD'])[1]")
	    public WebElement blackPlus;
		
		@FindBy(how = How.XPATH, using = "(//button[@class='csaf9s-1 hiLBpD'])[2]")
	    public WebElement colourPlus;
		
		@FindBy(how = How.XPATH, using = "(//button[@class='csaf9s-1 aENih'])[1]")
	    public WebElement blackMin;
		
		@FindBy(how = How.XPATH, using = "(//button[@class='csaf9s-1 aENih'])[2]")
	    public WebElement colourMin;
		
		//building pages locators
		
		public WebElement selLoc(String locator)
		{
			return driver.findElement(By.xpath("//li[text()='"+locator+"']"));

		}
		@FindBy(how = How.XPATH, using ="//h2[@class='ray-text--h2']")
		public WebElement locname;
		
		@FindBy(how = How.XPATH, using ="//div[@class='ray-card__heading card-product-title']")
		public List<WebElement> buildingname;
		
		//@FindBy(how = How.XPATH, using ="//button[@class='ray-button ray-button--primary card-btn individual-card-btn']")
		public WebElement buildingBookbtn(int j)
		{
			return driver.findElement(By.xpath("(//button[contains(@class, 'card-btn')])['"+j+"']"));
		}
		
		@FindBy(how = How.XPATH, using ="//h1[contains(@class, 'ray-text--h1')]")
		public WebElement buildinginfo;
		
		@FindBy(how = How.XPATH, using ="//button[contains(text(), 'Day Pass')]")
		public WebElement building_Daypass;
		
		@FindBy(how = How.XPATH, using ="//button[contains(text(), 'Conference')]")
		public WebElement building_Conference;
		
}
