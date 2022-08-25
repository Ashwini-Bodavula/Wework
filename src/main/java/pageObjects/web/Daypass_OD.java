  package pageObjects.web;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert.*;

import utilities.CommonOps;

import static org.testng.AssertJUnit.assertEquals;


  public class Daypass_OD extends CommonOps
{

	public WebElement selectlocation(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}

	public WebElement selectDate(String locator)
	{
		return driver.findElement(By.xpath("//p[text()='"+locator+"']"));

	}



	//day pass booking  from search bar
	@FindBy(how = How.XPATH, using = "//select[@id='city-select']")
    public WebElement Day_city;

	@FindBy(how = How.XPATH, using = "//select[@id='building-selection']")
    public WebElement Day_buildings;

	@FindBy(how = How.XPATH, using = "//div[@class='search_icon_holder']")
    public WebElement Search;


	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Continue')]")
    public WebElement day_continue;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Cancel')]")
    public WebElement day_cancel;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add Member')]")
    public WebElement day_AddMember;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Name']")
    public WebElement day_MemberName;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
    public WebElement day_MemberEmail;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement day_Save;

	@FindBy(how = How.XPATH, using = "(//button[contains(@class,'ray-button ray-button--tertiary ray-button--compact')])[2]	")
    public WebElement day_remove;
	//button[@class='ray-button ray-button--tertiary jss41']

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Back')]")
    public WebElement day_Back;

	@FindBy(how = How.XPATH, using = "(//*[contains(text(), 'Skip')])")
    public static WebElement SkipPay;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Confirm')]")
    public static WebElement ConfirmPayment;

	@FindBy(how = How.XPATH, using = "//button[@class =\"MuiButtonBase-root MuiIconButton-root MuiPickersCalendarHeader-iconButton\"]")
	public WebElement calarrow;

	@Step("Skip payment")
	public static void skipPay() {
		SkipPay.click();
	String confirm= ConfirmPayment.getText();
		//assert.assertEquals("Confirm & Pay ₹ 650", ConfirmPayment.getText());
		assertEquals("Confirm & Pay ₹ 650",confirm);
	}
}