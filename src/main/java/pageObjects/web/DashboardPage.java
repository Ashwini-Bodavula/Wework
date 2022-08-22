package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class DashboardPage extends CommonOps
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
		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//button[@aria-label='"+locator+"']"));
	}

    @FindBy(how = How.XPATH, using = "(//*[contains(text(),'Buy now')])[2]")
    public WebElement buyNowBtn;

    @FindBy(how = How.XPATH, using = "//div[@id='bundles-city-id']")
    public WebElement cityDropdown;

    @FindBy(how = How.XPATH, using = "//div[@id='city-building-id']")
    public WebElement buildingDropdown;

    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[1]")
    public  WebElement add5DayPassesBundle;

    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[2]")
    public  WebElement add10DayPassesBundle;

    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[1] //span[2]")
    public  WebElement fiveDaypassAmount;

    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[2] //span[2]")
    public  WebElement tenDaypassAmount;

    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[3] //span[2]")
    public  WebElement discount;

    @FindBy(how = How.XPATH, using = "(//div[@class='total']) //span[2]")
    public  WebElement totalAmount;



}
