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


	@FindBy(how = How.XPATH, using = " //div[text()=' My Account ']")
	  public WebElement MyAccount; 

	//div[@class='MuiGrid-root MuiGrid-item sidebarTitle css-1wxaqej'])[2]
	@FindBy(how = How.XPATH, using = "//div[text()='Profile']")
	  public WebElement profile; 

	
	@FindBy(how = How.XPATH, using = "//div[text()= 'Team']")
	  public WebElement Team;

	@FindBy(how = How.XPATH, using = "//div[text()='Credits']")
	  public WebElement Credits;

	@FindBy(how = How.XPATH, using = "//div[text()='Bookings']")
	  public WebElement Bookings;
	
	@FindBy(how = How.XPATH, using = "//div[text()='On Demand']")
	  public WebElement ondemand;
	
	@FindBy(how = How.XPATH, using = "//div[text()= 'My Subscriptions']")
	  public WebElement mySubscriptions;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Dashboard')]")
	  public WebElement dashboard;
	
	//account page title	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item title css-1wxaqej']")
	  public WebElement pagetitle;
	
	//dashboard
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'View details')]")
	//"//button[contains(@class,'viewBtn')]")
	  public WebElement viewdetails;
	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item link css-1wxaqej']")
	  public WebElement viewAll;
	
	@FindBy(how = How.XPATH, using = "//h3")
	  public WebElement poptitle;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'No active')]")
	  public WebElement activesub;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Buy now']")
	  public WebElement buyNow;
	
	@FindBy(how = How.XPATH, using = "//*[@data-testid='CloseIcon']")
	  public WebElement close;
	
	//profile page	

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	  public WebElement Name;

	@FindBy(how = How.XPATH, using = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]")
	  public WebElement Phone;

	@FindBy(how = How.XPATH, using = "//input[@name='gstin']")
	  public WebElement GSTIN;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	  public WebElement save;


	@FindBy(how = How.XPATH, using = "//*[contains(@class, 'MuiAlert-message')]")
	  public WebElement save_msg;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginTopRight css-2ibgt4']")
	  public WebElement remove_msg;
	//Team page
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
    public WebElement MemberEmail;

	@FindBy(how = How.XPATH, using = "(//span[@class= 'deleteBtn'])[2]")
    public WebElement remove;
	
	//credits
	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'registerBtn')]")
    public WebElement buyBundle;
	
	@FindBy(how = How.XPATH, using = "//span[@class='deleteBtn']")
    public WebElement Reedem;
	
	@FindBy(how = How.XPATH, using = "(//tr/td/div[@class='MuiGrid-root MuiGrid-item css-1wxaqej'])[2]")
    public WebElement cred_building;
	
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

	//span[contains(text(), 'View')][1]
	@FindBy(how = How.XPATH, using = "//tbody[@class='MuiTableBody-root']/tr[1]")
    public WebElement orde_row1;

	@FindBy(how = How.XPATH, using = "//*[@name=\"select_building\"]")
    public WebElement Daypass_filter;

	@FindBy(how = How.XPATH, using = "//tbody[@class='MuiTableBody-root']/tr[1]")
    public WebElement Book_table;

	
	@FindBy(how = How.XPATH, using = "//input[@id='email-user']")
	  public WebElement Email;
}
