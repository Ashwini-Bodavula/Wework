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
		return driver.findElement(By.xpath("(//div[contains(@class,'building_container')] //p[contains(text(),'"+locator+"')])"));

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

	@FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[1]")
	public WebElement locationDropdown;

    @FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[2]")
    public  WebElement noOfPplDrpdwn;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Explore Solutions')]")
    public  WebElement exploreSolnBtn;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'MuiGrid-grid-xs-3.7')])[1]")
    public  WebElement dayPassForTeam;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'MuiGrid-grid-xs-3.7')])[2]")
    public  WebElement readyToMoveInrivateOffice;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'MuiGrid-grid-xs-3.7')])[3]")
    public  WebElement allAccessForTeam;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'MuiGrid-grid-xs-3.7')])[4]")
    public  WebElement managedOffices;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'MuiGrid-grid-xs-3.7')])[5]")
    public  WebElement customBuiltSpaces;

    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Get in touch')])[2]")
    public  WebElement getInTouchBtn;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Full Name*']")
    public  WebElement fullName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Work Email*']")
    public  WebElement workEmail;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Phone Number*']")
    public  WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "(//div[@aria-haspopup='listbox'])[2]")
    public  WebElement companySizeDrpdwn;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[7]")
    public  WebElement yesRadioBtn;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[8]")
    public  WebElement noRadioBtn;

    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[2]")
    public  WebElement getInTouchButton;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='close']")
    public  WebElement closeBtn;




}
