package pageObjects.web;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.CommonOps;
public class HomePage extends CommonOps
{
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Login')]")
    public  WebElement weWorkLoginButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Why WeWork')]")
    public  WebElement whyWEWorkButton;


}
