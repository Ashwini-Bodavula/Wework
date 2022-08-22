package pageObjects.web;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginODPage {
//    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
//    public WebElement txt_create;
//
//    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90")
//    public List<WebElement> list_tasks;
//
//    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
//    public WebElement btn_x;
//
//    @FindBy(how = How.CLASS_NAME, using = "css-5j8aew")
//    public WebElement close_btn;

    //Login
	@FindBy(how = How.XPATH, using = "(//span[@class='hamburger-inner'])[2]")
    public WebElement Hamberger;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Login')]")
    public WebElement ODLoginButton;

	@FindBy(how = How.XPATH, using = "//input[@name= 'email']")
	public WebElement emailTestField;

	@FindBy(how = How.XPATH, using = "//input[@name= 'password']")
	public WebElement passwordTestField;

	@FindBy(how = How.XPATH, using = "//button[@name='submit']")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//span[contains(@class, 'logout')]")
	public  WebElement logout;

    @FindBy(how = How.XPATH, using = "//div[@class='MuiAlert-message']")
    public  WebElement login_msg;

    @FindBy(how = How.XPATH, using = "//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeSmall\"]")
    public  WebElement msg_close;
  //*[@class="MuiSvgIcon-root MuiSvgIcon-fontSizeSmall"]
}
