package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class PaymentPage extends CommonOps
{

	public WebElement select(String locator)
	{
		return driver.findElement(By.xpath("//*[contains(text(),'"+locator+"')]"));

	}


	@FindBy(how = How.XPATH, using = "//input[contains(@id, 'checkout_email')]")
    public WebElement checkoutEmail;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-checkbox'])[1]")
    public WebElement emailMeCheckbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-checkbox'])[2]")
    public WebElement saveInfoCheckbox;

	@FindBy(how = How.XPATH, using = "//select[@id='checkout_billing_address_country']")
    public WebElement countryDropdown;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder, 'First name')]")
    public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last name']")
    public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Company')]")
    public WebElement companyName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Address']")
    public WebElement address;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Apartment, suite, etc. (optional)']")
    public WebElement landmark;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='City']")
    public WebElement city;

	@FindBy(how = How.XPATH, using = "//select[@placeholder='State']")
    public WebElement state;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='PIN code']")
    public WebElement PINcode;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Phone']")
    public WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue to payment')]")
    public WebElement continuePayment;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Complete order')])[1]")
    public WebElement completeOrder;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Change')])[1]")
    public WebElement changeBtn1;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Change')])[2]")
    public WebElement changeBtn2;

	@FindBy(how = How.XPATH, using = "//input[@id='checkout_reduction_code']")
    public WebElement coupon;

	@FindBy(how = How.XPATH, using = "//button[@id='checkout_submit']")
    public WebElement applyBtn;

	@FindBy(how = How.XPATH, using = "//p[@id='error-for-reduction_code']")
    public WebElement couponValidationMsg;


	//@FindBy(how = How.XPATH, using = "")
    //public WebElement name;



}
