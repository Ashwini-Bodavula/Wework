  package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class MyAccPage extends CommonOps
{

	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//p[text()='"+locator+"']"));

	}


	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'My Account')]")
	  public WebElement MyAccount;

	//(//div[@class='sidebar-accordion-list-item'])[1]
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Profile')]")
	  public WebElement profile;

	//(//div[@class='sidebar-accordion-list-item'])[2]
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Team')]")
	  public WebElement Team;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Credits')]")
	  public WebElement Credits;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Bookings')]")
	  public WebElement Bookings;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Refer')]")
	  public WebElement Refer;

	//profile page

	@FindBy(how = How.XPATH, using = "//input[@id='email-user']")
	  public WebElement Email;

	@FindBy(how = How.XPATH, using = "//input[@id='user-fname']")
	  public WebElement Name;

	@FindBy(how = How.XPATH, using = "//input[@id='phone-user']")
	  public WebElement Phone;

	@FindBy(how = How.XPATH, using = "//input[@id='gstin-user']")
	  public WebElement GSTIN;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	  public WebElement save;


	@FindBy(how = How.XPATH, using = "//div[@class=\"MuiAlert-message\"]")
	  public WebElement save_msg;

	//Team page
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add Member')]")
    public WebElement AddMember;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Name']")
    public WebElement MemberName;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
    public WebElement MemberEmail;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement Save;

	@FindBy(how = How.XPATH, using = "(//button[@class='ray-button ray-button--tertiary ray-button--compact'])[2]")
    public WebElement remove;

	//Refer

	@FindBy(how = How.XPATH, using = "//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 MuiGrid-grid-sm-4\"]")
    public WebElement copybtn;

	@FindBy(how = How.XPATH, using = "//input[@id='codeee']")
    public WebElement referlink;

	//refer from navbar
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'header-links')]/div[4]")
    public WebElement nav_refer;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
    public WebElement refer_login;

	//booking

	@FindBy(how = How.XPATH, using = "//tbody[@class='MuiTableBody-root']/tr[1]")
    public WebElement orde_row1;

	@FindBy(how = How.XPATH, using = "//*[@name=\"select_building\"]")
    public WebElement Daypass_filter;

	@FindBy(how = How.XPATH, using = "//tbody[@class='MuiTableBody-root']/tr[1]")
    public WebElement Book_table;

}