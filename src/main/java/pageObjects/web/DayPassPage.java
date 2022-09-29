package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class DayPassPage  extends CommonOps
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
		return driver.findElement(By.xpath("//button[contains(text(),'"+locator+"')]"));
	}

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
    public WebElement continueBtn;

    @FindBy(how = How.XPATH, using = "(//button[contains(@class,'fullWidthBtn')])[2]")
    public WebElement skipAndPayBtn;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'continue_btn')]")
    public WebElement confirmAndPayBtn;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Day Pass at')]")
    public WebElement dayPassHeader;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiGrid-grid-xs-12 sc-iJKOTD fjqLWR css-15j76c0')]")
    public WebElement priceBreakupContainer;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'+ Add Member')]")
    public WebElement addMemberBtn;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Name']")
    public WebElement memberName;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Email']")
    public WebElement memberEmail;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]")
    public WebElement saveBtn;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Save')]/following-sibling::button")
    public WebElement closeMemberBtn;

    @FindBy(how = How.XPATH, using = "(//button[contains(@class,'ray-button--compact')])[1]")
    public WebElement deleteMemberBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Team member with this email ID already exists in this team')]")
    public WebElement errorMsgForAddingSameMember;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'proceedButton')]")
    public WebElement addConferenceRoomBtn;

    public void addconference(String proceed)
    {
    	addConferenceRoomBtn.click();

    }
    
    @FindBy(how = How.XPATH, using = "//input[@id='date']")
    public WebElement selectDates;
    
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Apply')]")
    public WebElement applyButton;
  
    @FindBy(how = How.XPATH, using = "(//button[contains(@class,'action_btns')])[1]")
    public WebElement editButton;
    
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'total_price')] //div[2]")
    public WebElement totalPrice;
    
    public WebElement selectCityOrBuilding(String locator)
   	{
   		return driver.findElement(By.xpath("//li[contains(text(),'"+locator+"')]"));
   	}
       
       @FindBy(how = How.XPATH, using = "//button[contains(@class,'search-button')]")
       public WebElement searchBtn; 
       
       @FindBy(how = How.XPATH, using = "//button[contains(text(),'Book now')]")
       public WebElement bookNowBtn; 
  
}
