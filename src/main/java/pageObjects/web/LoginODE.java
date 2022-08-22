package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class LoginODE extends CommonOps
{
	
	  
	    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Login')]")
	    public  WebElement Login;
	    
	    @FindBy(how = How.XPATH, using = "//input[@name= 'email']")
		public WebElement emailTestField;

		@FindBy(how = How.XPATH, using = "//input[@name= 'password']")
		public WebElement passwordTestField;

		@FindBy(how = How.XPATH, using = "//button[@name='submit']")
		public WebElement submitButton;
		
		@FindBy(how = How.XPATH, using = "(//div[@id='menu-toggle'])[2]")
		public WebElement hamBurger;
		
		@FindBy(how = How.XPATH, using = "//span[contains(@class, 'logout')]")
		public WebElement logOut;
		
		@FindBy(how = How.XPATH, using = "//div[@class='wework-desktop-logo']")
	    public  WebElement weWorkHome;
		
		@FindBy(how=How.XPATH, using="//h1[@class='feature_header']")
		public WebElement Homepage;
		
}
