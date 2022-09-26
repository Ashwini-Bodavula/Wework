package pageObjects.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class webLoading extends CommonOps{

	public WebElement selectloc(String locator)
	{
		return driver.findElement(By.xpath("(//*[contains(text(), '"+locator+"')])[2]"));

	}

	public WebElement select(String locator)
	{
		return driver.findElement(By.xpath("(//*[contains(text(), '"+locator+"')])"));

	}

	public WebElement selectCity(String locator)
	{
		return driver.findElement(By.xpath("(//div[contains(@class,'city_card')] //p[contains(text(),'"+locator+"')])[2]"));

	}

	public WebElement selectLocation(String locator)
	{
		return driver.findElement(By.xpath("(//div[contains(@class,'building_container')] //p[contains(text(),'"+locator+"')])[2]"));

	}
	public WebElement selectBuilding(String locator)
	{
		return driver.findElement(By.xpath("(//div[contains(@class,'building_container')] //p[contains(text(),'"+locator+"')])"));

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
		return driver.findElement(By.xpath("//button[@aria-label='"+locator+"']"));
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'city_card')] //p[contains(text(),'Mumbai')]")
    public WebElement mumbai;


    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[3]/div/div/div/div[3]/div/a[2]")
    public WebElement termsAndServices;

	@FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[1]")
    public  WebElement cityDropdown;

    @FindBy(how = How.XPATH, using = "//p[text()='Bengaluru']")
    public WebElement CityOne;

    @FindBy(how = How.XPATH, using = "//li[text()='Hyderabad']")
    public WebElement CityTwo;

    @FindBy(how = How.XPATH, using = "(//div[@class='ray-dropdown'])[2]")
    public WebElement buildingsDropdown;

    @FindBy(how = How.XPATH, using = "(//div[@role='button'])[2]")
    public WebElement buildingsDrpdwn;

    @FindBy(how = How.XPATH, using = "(//div[@role='button'])[3]")
    public WebElement iAmIntrestedInDrpdwn;

    @FindBy(how = How.XPATH, using = "//p[text()='MG Road']")
    public WebElement locationOne;

    @FindBy(how = How.XPATH, using = "//p[text()='Galaxy']")
    public WebElement buildingOne;

    @FindBy(how = How.XPATH, using = "//li[text()='Rajapushpa Summit']")
    public WebElement buildingThree;

    @FindBy(how = How.XPATH, using = "//button[text()='Explore Solutions']")
    public WebElement exploreBtn;
 
    
    public WebElement selectWorkspace(String locator)
   	{
    	int i=0;
    	int j =0;
    	 List<WebElement> workspaceList = driver.findElements(By.xpath("(//div[contains(@class,'MuiGrid-grid-md-3.7')])"));
    		for(i =0; i<workspaceList.size();i++)
    		{
    			if(workspaceList.get(i).getText().contains(locator))
    			{
    				j = i+1;
    				break;
    			}
    		}
    	
   		return driver.findElement(By.xpath("(//div[contains(@class,'MuiGrid-grid-md-3.7')])["+j+"]"));

   	}
    

    public WebElement enter(String locator)
   	{
       	if(locator.equals("Phone number"))
       	{
       		return driver.findElement(By.xpath("(//input[@placeholder='"+locator+"*'])[2]"));
       	}
       	else
       	{
       		return driver.findElement(By.xpath("(//input[@placeholder='"+locator+"*'])"));
      	}
   	}
    
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Book Now')]")
    public  WebElement bookNowBtn;

    @FindBy(how = How.XPATH, using = "(//input[@name='full_name'])[2]")
    public WebElement name;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Full Name*'])")
    public WebElement Name;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Full name*'])[1]")
    public WebElement fullName;

    @FindBy(how = How.XPATH, using = "(//input[@name='email'])[2]")
    public WebElement addemail;

    @FindBy(how = How.XPATH, using = "(//input[@type='email'])[2]")
    public WebElement workemail;

    @FindBy(how = How.XPATH, using = "(//input[@type='email'])[1]")
    public WebElement email;

    @FindBy(how = How.XPATH, using = "(//input[@name='phone_number'])[2]")
    public WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Phone Number*'])")
    public WebElement phnNmbr;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Phone number*']")
    public WebElement phnNumber;

//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'+')]")
//    public WebElement HeaderplusIcon;
//
//    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'+')])[2]")
//    public WebElement plusIcon;

    public WebElement adding(String locator)
   	{
       	if(locator.equals("header"))
       	{
       		return driver.findElement(By.xpath("//div[contains(text(),'+')]"));
       	}
       	else
       	{
       		return driver.findElement(By.xpath("(//div[contains(text(),'+')])[2]"));
      	}
   	}
  
    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CalendarIcon']")
    public WebElement calendarIcon;

    @FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'switch to year view')]")
    public WebElement yearDropdown;

//    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='ArrowDropDownIcon'])[2]")
//    public WebElement yearDropdown;


    @FindBy(how = How.XPATH, using = "//div[@class='PrivatePickersYear-root PrivatePickersYear-modeDesktop css-j9zntq']")
    public WebElement yearsList;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'Group-root css-1bx5ylf')])[1]")
    public WebElement monthName;

    @FindBy(how = How.XPATH, using = "//button[@title='Next month']")
    public WebElement rightArrowBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='30']")
    public WebElement clickOnDate;

    public WebElement date(String locator)
	{
		return driver.findElement(By.xpath("//button[text()='"+locator+"']"));
	}

    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='ClockIcon']")
    public WebElement clockIcon;

    @FindBy(how = How.XPATH, using = "//span[@aria-label='4 hours']")
    public WebElement hour;

    @FindBy(how = How.XPATH, using = "//span[@aria-label='20 minutes']")
    public WebElement minute;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
    public WebElement continueBtn;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Back to homepage')]")
    public  WebElement backToHomePageBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Log out')]")
    public  WebElement logout;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Thank you for contacting WeWork')]")
    public WebElement thankyouText;

    @FindBy(how = How.XPATH, using = "(//div[@class='navWithIcon'])[1]")
    public WebElement loc;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'userName')]")
    public WebElement userName;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiTab-iconWrapper'])[1]")
    public WebElement workspaceBtn;



    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiTab-iconWrapper'])[3]")
    public WebElement eventSpacesBtn;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@class='MuiTab-iconWrapper'])[4]")
    public WebElement bookATourBtn;



    @FindBy(how = How.XPATH, using = "//div[@role='button']")
    public WebElement loctnDropdown;

    @FindBy(how = How.XPATH, using = "(//div[@role='button'])[1]")
    public WebElement loctnDropdown1;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'ray-dropdown')])[1]")
    public WebElement loctnDropdown2;

    @FindBy(how = How.XPATH, using = "(//p[@class='cityName'])[1]")
    public  WebElement cityOne;

    @FindBy(how = How.XPATH, using = "(//p[@class='building_name'])[2]")
    public  WebElement buildingTwo;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'ray-dropdown')])[2]")
    public  WebElement buildingDropdown;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'1-20')]")
    public  WebElement noOfPpl;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Explore Solutions')]")
    public  WebElement exploreSolnBtn;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Day-pass for teams')]")
    public  WebElement dayPassOptn;

    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[2]")
    public  WebElement getInTouchButton;

    @FindBy(how = How.XPATH, using = "(//button[text()='Get in touch'])[1]")
    public  WebElement getInTouchBtn;

    @FindBy(how = How.XPATH, using = "(//div[@aria-haspopup='listbox'])[2]")
    public  WebElement companySizeDrpdwn;

    @FindBy(how = How.XPATH, using = "(//li[@role='option'])[1]")
    public  WebElement optnOne;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[8]")
    public  WebElement brokerRadioBtn;

    @FindBy(how = How.XPATH, using = "(//*[name()='svg'][@data-testid='RadioButtonUncheckedIcon'])[1]")
    public  WebElement scheduleVistiBtn;

    @FindBy(how = How.XPATH, using = "//*[name()='svg'][@data-testid='CloseIcon']")
    public  WebElement closeIcon;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Virtual Office')]")
    public  WebElement virtualOffice;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Virtual Offices by WeWork')]")
    public  WebElement virtualOfficeText;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Form Submitted Successfully')]")
    public  WebElement FormSubbmittedMsg;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Contact us')]")
    public  WebElement contactUsBtn;

    @FindBy(how = How.XPATH, using = "//li[text()='Events']")
    public  WebElement events;

   /* @FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
    public  WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
    public  WebElement checkoutBtn; */

    @FindBy(how = How.XPATH, using = "(//div[@class='navWithIcon'])[2]")
    public  WebElement workspaceDrpdwn;

    @FindBy(how = How.XPATH, using = "//button[@class='ray-button ray-button--primary jss2']")
    public  WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'All Access')]")
    public  WebElement allAccessButton;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Full name*']")
    public  WebElement nameField;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Email*']")
    public  WebElement emailField;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Phone number*']")
    public  WebElement phonenNumberField;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Full name*'])")
    public  WebElement username;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Email*'])")
    public  WebElement userEmail;

    @FindBy(how = How.XPATH, using = "(//input[@placeholder='Phone number*'])")
    public  WebElement userPhnNumber;

    @FindBy(how = How.XPATH, using = "(//*[name()='path'][@stroke='#0000FF'])[1]")
    public  WebElement leftArrow;

    @FindBy(how = How.XPATH, using = "(//*[name()='path'][@stroke='#0000FF'])[2]")
    public  WebElement rightArrow;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Buy a bundle')]")
    public  WebElement buyABundleLink;


    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[1]")
    public  WebElement add5DayPassesBundle;

    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[2]")
    public  WebElement add10DayPassesBundle;


    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[1] //span[2]")
    public  WebElement fiveDaypassAmount;

    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[2] //span[2]")
    public  WebElement tenDaypassAmount;

    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'+')])[5]")
    public  WebElement plusBtnToAdd10daypass;

    @FindBy(how = How.XPATH, using = "(//div[@class='summary_unit'])[3] //span[2]")
    public  WebElement discount;

    @FindBy(how = How.XPATH, using = "(//div[@class='total']) //span[2]")
    public  WebElement totalAmount;

    @FindBy(how = How.XPATH, using = "//p[@class='form_title']")
    public  WebElement subscriptionType;

    @FindBy(how = How.XPATH, using = "(//p[@class='title'])[3]")
    public  WebElement workspaceTitle;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'WBS')]")
    public  WebElement WBS;
  
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Referrals')]")
    public  WebElement referralsLink;
  
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
    public  WebElement CareersLink;
    
    @FindBy(how = How.XPATH, using = "//input[@placeholder='dd/mm/yyyy']")
    public  WebElement dateField;
  
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'sc-gsDKAQ jRuFlm button')]")
    public  WebElement bookAWorkspaceBtn;
    
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'headerAccountDrpdwn')]")
    public  WebElement accountDropdown;
  
  
    
}
