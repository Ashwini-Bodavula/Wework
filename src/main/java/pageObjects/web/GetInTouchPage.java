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
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}
	public WebElement commonlocator(String locator)
	{
		return driver.findElement(By.xpath("//li[text()='"+locator+"']"));
	}

	public WebElement opt(String locator)
	{
		return driver.findElement(By.linkText(locator));
	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//button[@aria-label='"+locator+"']"));
	}

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Full Name*']")
    public WebElement fullName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Work Email*']")
    public WebElement workEmail;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Phone Number*']")
    public WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "(//div[@aria-haspopup='listbox'])[2]")
    public  WebElement companySizeDrpdwn;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[1]")
    public  WebElement CompanySize50;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[2]")
    public  WebElement CompanySize100;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[3]")
    public  WebElement CompanySize200;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[4]")
    public  WebElement CompanySize500;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[5]")
    public  WebElement CompanySize1000;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[7]")
    public  WebElement yesRadioBtn;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[8]")
    public  WebElement noRadioBtn;

    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[2]")
    public  WebElement getInTouchButton;

}
