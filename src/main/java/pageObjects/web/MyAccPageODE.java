  package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class MyAccPageODE extends CommonOps
{

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'My Account')]")
	  public WebElement MyAccount;

	//(//div[@class='sidebar-accordion-list-item'])[1]
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Profile')]")
	  public WebElement profile;

	//(//div[@class='sidebar-accordion-list-item'])[2]
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Enterprise Bookings')]")
	  public WebElement Enterprise;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'My Bookings')]")
	  public WebElement MyBookings;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Employees')]")
	  public WebElement Employees;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Support')]")
	  public WebElement Support;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'On Ground Purchases')]")
	  public WebElement myPurchase;

	//profile page

	@FindBy(how = How.XPATH, using = "//input[@id='email-user']")
	  public WebElement Email;

	@FindBy(how = How.XPATH, using = "//input[@id='user-fname']")
	  public WebElement Name;

	@FindBy(how = How.XPATH, using = "//input[@id='phone-user']")
	  public WebElement Phone;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	  public WebElement save;

	@FindBy(how = How.XPATH, using = "//div[@class=\"MuiAlert-message\"]")
	  public WebElement save_msg;

	//Enterprise page and mybooking
	@FindBy(how = How.XPATH, using = "//h2[@class='ray-text--h2  ']")
    public WebElement Enterprise_Heading;

	@FindBy(how = How.XPATH, using = "//select[@name='order_type']")
    public WebElement orderType;
	
	@FindBy(how = How.XPATH, using = "(//tr[@class='booking_row'])[1]")
    public WebElement bookingTable;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Export Booking')]")
    public WebElement exportBooking;
	
	public WebElement status(String status)
	{
		return driver.findElement(By.xpath("(//span[contains(text(),'"+status+"')])[1]"));

	}
	//span[contains(text(), 'CONFIRMED')] - table confirmation and status of order

	public WebElement updatestatus(String status)
	{
		return driver.findElement(By.xpath("//button[contains(text(),'"+status+"')]"));

	}
	
	public WebElement delete(int num)
	{
		return driver.findElement(By.xpath("(MuiGrid-root MuiGrid-item MuiGrid-grid-xs-1 MuiGrid-grid-md-1)["+num+"]"));

	}
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(), Order)]")
	  public WebElement order;
	
	//button[contains(text( ), 'Cancel')] - cancel
			//button[@class='buttonStyle m4'] - Reschedule
	//button[contains(text( ), 'Approve')]
	//button[contains(text( ), 'Reject')]
	//button[contains(text( ), 'Reschedule')]
	//button[contains(text( ), 'Cancel All')]
	@FindBy(how = How.XPATH, using = "//div[@class='MuiAlert-message']")
	  public WebElement msg;
	
	//Support
	@FindBy(how = How.XPATH, using = "//span[contains(text( ), 'any queries')]")
	  public WebElement supQueries;
	@FindBy(how = How.XPATH, using = "//a[contains(text( ), 'wework.co')]")
	  public WebElement supMail;
	
	
	//Employee
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchtextfield']")
	  public WebElement searchemp;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text( ), 'Add Employee')]")
	  public WebElement addEmp;
	
	@FindBy(how = How.XPATH, using = "//input[@id='employee-id']")
	  public WebElement emp_Id;
	
	@FindBy(how = How.XPATH, using = "//select[@name='role-user']")
	  public WebElement emp_Role;

	@FindBy(how = How.XPATH, using = "//input[@id='email-manager']")
	  public WebElement emp_Mgr;
	
	@FindBy(how = How.XPATH, using = "//button/span[@class='MuiIconButton-label']")
	  public WebElement emp_close;
	
	@FindBy(how = How.XPATH, using = "(//div[@style='cursor: pointer;'][1]")
	  public WebElement emp_edit;
	

	
}