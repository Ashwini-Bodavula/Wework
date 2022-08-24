  package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class conferenceOD extends CommonOps
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
	@FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public WebElement calendarIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='addBtnRow']")
    public WebElement addBtn;



	//conference booking  from search bar
	@FindBy(how = How.XPATH, using = "//div[@class='action-content conference_room_action']")
    public WebElement Conference;

	@FindBy(how = How.XPATH, using = "//select[@id='city-select']")
    public WebElement Con_city;

	@FindBy(how = How.XPATH, using = "//select[@id='building-selection']")
    public WebElement Con_buildings;

	@FindBy(how = How.XPATH, using = "//div[@class='search_icon_holder']")
    public WebElement Search;


	@FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--primary jss34']")
    public WebElement day_continue;

	@FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--tertiary jss34']")
    public WebElement day_cancel;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add Member')]")
    public WebElement day_AddMember;

	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'Member Name')]")
    public WebElement day_MemberName;

	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'Member Email')]")
    public WebElement day_MemberEmail;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement day_Save;

	@FindBy(how = How.XPATH, using = "(//button[@class='ray-button ray-button--tertiary ray-button--compact'])[2]")
    public WebElement day_remove;
	//button[@class='ray-button ray-button--tertiary jss41']

	@FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--tertiary jss41']")
    public WebElement day_Back;

	@FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--primary jss41']")
    public WebElement SkipPay;

	@FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--primary jss75']")
    public WebElement ConfirmPayment;


}