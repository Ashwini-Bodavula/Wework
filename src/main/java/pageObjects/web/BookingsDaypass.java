package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BookingsDaypass {
	
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Day Pass')]")
    public WebElement Daypass;
	
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Bookings')]")
    public WebElement Bookings;
	
//	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Reschedule')]")
//    public WebElement Reschedules;
	
	@FindBy(how = How.XPATH, using ="//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeMedium sc-dwnOUR kTgicL css-q34dxg'][6]")
    public WebElement Reschedule;
	
	@FindBy(how = How.XPATH, using ="//div[@class='MuiGrid-root MuiGrid-item title css-1wxaqej']")
    public WebElement pagename;
	
	@FindBy(how = How.XPATH, using ="//input[@placeholder = 'Select Date']")
    public WebElement Selectdatefield;
	
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Apply')]")
    public WebElement Applybutton;

	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Confirm')]")
    public WebElement confirm;
	
	@FindBy(how = How.XPATH, using ="//tbody/tr[1]/td[1]")
    public WebElement Ordernum;
	
	@FindBy(how = How.XPATH, using ="//tr[@class='MuiTableRow-root tableRow css-1gqug66'][1]")
    public WebElement Row1;
	
	@FindBy(how = How.XPATH, using ="//tbody/tr[1]/td[5]/span[1]")
    public WebElement orderdetails;
	
	@FindBy(how = How.XPATH, using ="//h3[contains(text(),'Day pass booking')]")
    public WebElement viewpagedetails;
	
	
	
	

}
