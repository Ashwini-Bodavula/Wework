	package pageObjects.web;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.How;
	import utilities.CommonOps;

	import static org.sikuli.script.runnerSupport.JavaScriptSupport.click;
	import static org.testng.AssertJUnit.assertTrue;

	public class LoginPage{
		@FindBy(how = How.XPATH, using = "//div[contains(text(),'Login')]")
		public WebElement weWorkLoginButton;

		@FindBy(how = How.XPATH, using = "//input[@name= 'email']")
		public WebElement emailTestField;

		@FindBy(how = How.XPATH, using = "//input[@name= 'password']")
		public WebElement passwordTestField;

		@FindBy(how = How.XPATH, using = "//button[@name='submit']")
		public WebElement submitButton;

		@FindBy(how = How.XPATH, using = "//div[contains(@class,'userName')]")
		public WebElement userName;


		@FindBy(how = How.XPATH, using = "//div[@id='auth0-lock-error-msg-email']")
		public WebElement emailEmptyErrorMsg;

		@FindBy(how = How.XPATH, using = "//div[@id='auth0-lock-error-msg-password']")
		public WebElement passwordEmptyErrorMsg;

		@FindBy(how = How.XPATH, using = "//div[@id='auth0-lock-error-msg-email'] //div[@class='auth0-lock-error-invalid-hint']")
		public WebElement invalidEmailErrorMsg;

		@FindBy(how = How.XPATH, using = "//div[contains(text(),'Password is invalid')]")
		public WebElement invalidPasswordErrorMsg;


		@FindBy(how = How.XPATH, using = "//div[contains(text(),\"Email can't be blank\")]")
		public WebElement emailBlankErrorMsg;

		@FindBy(how = How.XPATH, using = "//div[@class='auth0-global-message auth0-global-message-error']")
		public WebElement wrongPasswordMsg;

		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Your account has been blocked')]")
		public WebElement accountBlockedMsg;

		@FindBy(how = How.XPATH, using = "//label[@title='Show password']")
		public WebElement showPassword;

		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Forgot password?')]")
		public WebElement forgotPassword;

		@FindBy(how = How.XPATH, using = "//div[@title='Reset your password']")
		public WebElement resetPasswordField;

		@FindBy(how = How.XPATH, using = "//button[@aria-label='Send email']")
		public WebElement sendEmailButton;

		@FindBy(how = How.XPATH, using = "//div[@class='auth0-global-message auth0-global-message-success']")
		public WebElement emailSentToResetPswrdMsg;

		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign Up')]")
		public WebElement signUpBtn;
		

	}
