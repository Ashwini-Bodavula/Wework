package pageObjects.web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;
public class ODAdminUsersPage  extends CommonOps{
	public WebElement select(String locator)
	{
		return driver.findElement(By.xpath("(//*[contains(text(), '"+locator+"')])"));
	}
	
	public WebElement selectBuilding(String locator)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'"+locator+"')]"));
	}
	public WebElement opt(String locator)
	{
		return driver.findElement(By.xpath("//span[contains(text(),'"+locator+"')]"));
	}
	public WebElement getPrice(String locator)
	{
		return driver.findElement(By.xpath("//span[contains(text(),'"+locator+"')]/following-sibling::span"));
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='user-email']")
    public WebElement Email;
	
	@FindBy(how = How.XPATH, using = "//input[@id='user-pwd']")
    public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgot Password?')]")
    public WebElement forgotPassword;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Login')]")
    public WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Logout')]")
    public WebElement logoutBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Admin Users')]")
    public WebElement adminUsers;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add User')]")
    public WebElement addUserBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='useremail']")
    public WebElement userEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@id='userpswd']")
    public WebElement userpassword;
	
	@FindBy(how = How.XPATH, using = "//input[@id='user-name']")
    public WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'select__dropdown-indicator')]")
    public WebElement SelectBuildingDrpdwn;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='MuiSwitch-thumb'])[1]")
    public WebElement isSuperAdminBtn;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='MuiSwitch-thumb'])[2]")
    public WebElement isPostPaidUserBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Prestige Atlanta, Koramangala')]")
    public WebElement PrestigeAtlanatBuilding;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Futura, Magarpatta Road')]")
    public WebElement FuturaBuilding;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'Add')])[2]")
    public WebElement addBtn;
	
//	@FindBy(how = How.XPATH, using = "//div[contains(text(),'User Created Successfully')]")
//    public WebElement userCreatedMessage;
	
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[2]/div[1]")
    public WebElement userCreatedMessage;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Update')]")
    public WebElement updateBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'DeleteDialog__DialogWrapper-sc-19usnbu-0 cMGXhg')] //button[contains(text(),'Delete')]")
    public WebElement deleteBtn;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[2]/div[1]/div[3]/button[1]")
    public WebElement closeBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Shop Purchases')]")
    public WebElement shopPurchasesTab;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/shop']")
    public WebElement shopTab;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='MuiIconButton-label'])[2]")
    public WebElement buildingDrpdwn;
	

	@FindBy(how = How.XPATH, using = "//input[@id='select-building-select']")  
    public WebElement selectBuilding;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Color')]")
    public WebElement colorPrinting;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Black & White')]")
    public WebElement blackAndwhitePrinting;

	
	@FindBy(how = How.XPATH, using = "//input[@id='email__id']")
    public WebElement customerEmail;
	

	@FindBy(how = How.XPATH, using = "//input[@id='name']")
    public WebElement customerName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='gstin__customer']")
    public WebElement customerGSTN;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Place Order')]")
    public WebElement placeOrderBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
    public WebElement plusBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'-')]")
    public WebElement minusBtn;

	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Total:')]")
    public WebElement total;
	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1']")
    public WebElement billingDetailsList;
	
	@FindBy(how = How.XPATH, using = "//input[@id='select-event-type-select']")
    public WebElement postPaidEventDropdown;
	
	@FindBy(how = How.XPATH, using = "//input[@id='price']")
    public WebElement price;
	
	@FindBy(how = How.XPATH, using = "//input[@id='enterprise-select']")
    public WebElement selectEnterprise;
	
	@FindBy(how = How.XPATH, using = "//input[@id='product type-select']")
    public WebElement selectproductType;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@class,'MuiInputBase-input MuiInput-input')]")
    public WebElement bookingDate;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'+')])[1]")
    public WebElement plusBtnToincreaseRoomSize;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'+')])[2]")
    public WebElement plusBtnToincreaseCredits;
	
	@FindBy(how = How.XPATH, using = "//input[@id='conference_room__id']")
    public WebElement conferenceRoom;	
	
//	@FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiSvgIcon-root'])[5]")
//    public WebElement rightArrowBtn;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(@class,'MuiPickersCalendarHeader-iconButton')])[2]")
    public WebElement rightArrowBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiPickersCalendarHeader-transitionContainer')]")
    public WebElement monthName;
	
	public WebElement selectSlotTime(int locator)
	{
		return driver.findElement(By.xpath("(//div[@class='ray-text-field RayInput__InputWrapper-u27a6p-0 kNsHaQ'])["+locator+"]"));
	}

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[6]/button[1]")
    public WebElement viewDetailsButton;
	
	
	
}

