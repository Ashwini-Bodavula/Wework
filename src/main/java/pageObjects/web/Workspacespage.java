package pageObjects.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;

public class Workspacespage extends CommonOps {
	
	
	
	public WebElement type(String locator)
	{
		return driver.findElement(By.xpath("//select[text()='"+locator+"']"));

	}
	
	public WebElement select(String locator)
	{
		return driver.findElement(By.linkText(locator));
	}

	
	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Workspaces')]")
    public WebElement workspace;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'SUBSCRIPTIONS')]")
    public WebElement SUBSCRIPTIONS;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Ready-to-move-in private offices')]")
    public WebElement privateoffice;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Hot desk')]")
    public WebElement Hotdesk;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Office suite')]")
    public WebElement Officesuite;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Types of workspaces')]")
    public WebElement typesofworkspace;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Compare workspaces')]")
    public WebElement Workspaces;
	
	@FindBy(how = How.XPATH, using = "//select[@class='ray-dropdown__input'][1]")
    public WebElement selectworkspace;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Find a Workspace')]")
    public WebElement findworkspace;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'cancel-btn')]")
    public WebElement closeicon;


	
	
	
	

}
