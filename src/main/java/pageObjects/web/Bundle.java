  package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class Bundle extends CommonOps
{

	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}
	
	public WebElement Booknow(int i)
	{
		return driver.findElement(By.xpath("(//button[contains(@class, 'book-now-button')])['"+i+"']"));

	}

	//Bundles
	@FindBy(how = How.XPATH, using = "(//div[@class='MuiGrid-root css-rfnosa'])[2]")
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

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'continue_btn')]")
    public WebElement pay;


}