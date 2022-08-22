package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class ConferenceroomPage extends CommonOps
{
	public WebElement select(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}
	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//button[text()='"+locator+"']"));

	}

	public WebElement selectTime(String locator)
	{
		return driver.findElement(By.xpath("//span[contains(text(),"+locator+"')]"));

	}

	public WebElement seater(String locator)
	{
		return driver.findElement(By.xpath("//div[@class='roomCapacityContent'] //span[contains(text(),'"+locator+"')]"));

	}

	@FindBy(how = How.XPATH, using = "//div[@class='hoursControl'] //span[contains(text(),'-')]")
    public WebElement decreaseHour;

	@FindBy(how = How.XPATH, using = "//div[@class='hoursControl'] //span[contains(text(),'+')]")
    public WebElement increaseHours;

	@FindBy(how = How.XPATH, using = "//span[@class='hoursText']")
    public WebElement hoursText;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='dd/mm/yyyy']")
    public WebElement dateTextBox;

	@FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public WebElement calendarIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='addBtnRow'] //span[contains(text(),'Add')]")
    public WebElement addBtn;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Conference Room')]")
    public WebElement conferenceRoomHeader;

	@FindBy(how = How.CSS, using = "div.formContainer")
    public WebElement slotsWindow;

	@FindBy(how = How.CSS, using = "//div[contains(@class,'conferenceItemContainer')]")
    public WebElement conferenceItemContainer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue')]")
    public WebElement continueBtn;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'priceBreakupContainer')]")
    public WebElement priceBreakupContainer;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm & Pay')]")
    public WebElement confirmAndPayBtn;



}
