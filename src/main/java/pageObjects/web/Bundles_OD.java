  package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class Bundles_OD extends CommonOps
{

	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//p[text()='"+locator+"']"));

	}


	//Bundles
	@FindBy(how = How.XPATH, using = "//div[@class='action-content bundles_action']")
    public WebElement Bundles;

	@FindBy(how = How.XPATH, using = "//select[@id='city-select']")
    public WebElement Bun_city;

	@FindBy(how = How.XPATH, using = "//select[@id='building-selection']")
    public WebElement Bun_buildings;
	@FindBy(how = How.XPATH, using = "(//select[@class='ray-select__input'])[2]")
    public WebElement Bun_bulname;

	//span[contains(text(),'+')]
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'+')]")
    public WebElement fivedayAdd;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[2]")
    public WebElement TendayAdd;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'-')])")
    public WebElement Fivedaysub;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'-')])[2]")
    public WebElement Tendaysub;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),\"How it works\")]")
    public WebElement Howitworks;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),\"Proceed\")]")
    public WebElement Proceed;

	@FindBy(how = How.XPATH, using = "//button[@class =\"MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton\"]")
    public WebElement calarrow;
}