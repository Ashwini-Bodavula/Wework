package pageObjects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class WifiPage extends CommonOps{

	
	
	 @FindBy(how = How.XPATH, using = "(//div[@class='MuiGrid-root MuiGrid-item sidebarTitle css-1wxaqej'])[3]")
	    public WebElement WIFI;
	 
	 @FindBy(how = How.XPATH, using = "(//input[@id='username']")
	    public WebElement username;
	 
	 @FindBy(how = How.XPATH, using = "(//input[@id='1-email']")
	    public WebElement username1;
	 
	 @FindBy(how = How.XPATH, using = "(//span[contains(text(),'Copy')])[2]")
	    public WebElement copypswd;
	 
	 @FindBy(how = How.XPATH, using = "//button[contains(text(),'Reset credentials')]")
	    public WebElement Resetcredentials;
	 
	 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Connect to WiFi')]")
	    public WebElement pagetitle;
	 
	 
	 
}
