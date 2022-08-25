package sanity;

import static extensions.UIActions.*;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class WebAppTest extends CommonOps
{
	/*@Test(description = "Test01 - Verify Website Opens on Chrome Browser", groups= {"CO"})
    @Description("This test verifies that the website is opening on the chrome browser")
    public void test01_verifyWebsite() throws InterruptedException {
        WebFlows.loadWebsite();
    }*/

    @Test(description = "Test02 - Verify User is able to Login and logout", groups= {"CO"})
    @Description("This test verifies that User is able to login and logout")
    public void test02_verifyLoginandLogout() throws InterruptedException{
    	//WebFlows.loadWebsite();
        String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(WebLogin.weWorkLoginButton);
        click(WebLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);
        updateText(WebLogin.emailTestField, getData("Username"));
        updateText(WebLogin.passwordTestField, getData("Password"));
        click(WebLogin.submitButton);
        switchToParentWindow(currentWindow);
        waitForLoad();
        Verifications.verifyTextInElement(WebLogin.userName, getData("user"));
        scrollToElement(WebLoading.logout);
	    Verifications.elementIsVisible(WebLoading.logout);
	    click(WebLoading.logout);

    }


    @Test(description = "Test03 - Verify the email and password fields", groups= {"CO"})
    @Description("This test verifies the email and password fields")
    public void test03_verifyEmailAndPassword() throws InterruptedException{
    //	WebFlows.loadWebsite();
        String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(WebLogin.weWorkLoginButton);
        click(WebLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);

        //click on submit without entering email and password and validate for error messages
        click(WebLogin.submitButton);
        Assert.assertTrue("Email can't be blank error message displayed", WebLogin.emailEmptyErrorMsg.isDisplayed());
        Assert.assertTrue("Password can't be blank error message displayed",WebLogin.passwordEmptyErrorMsg.isDisplayed() );

        //Enter white spaces in email and check for error message
        updateText(WebLogin.emailTestField, getData("whiteSpaces"));
        Assert.assertTrue("Email can't be blank error message displayed",WebLogin.emailBlankErrorMsg.isDisplayed());

        //enter invalid email and validate the error message
        deleteText(WebLogin.emailTestField);
        updateText(WebLogin.emailTestField, getData("invalidEmail"));
        click(WebLogin.submitButton);
        Assert.assertTrue("Invalid email error message displayed",WebLogin.invalidEmailErrorMsg.isDisplayed());

        //Enter worng password
        //Validate show password button
        deleteText(WebLogin.emailTestField);
        updateText(WebLogin.emailTestField, getData("validEmail"));
        updateText(WebLogin.passwordTestField, getData("invalidPassword"));
        String val = WebLogin.passwordTestField.getAttribute("type");
        Assert.assertEquals("password", val);
        click(WebLogin.showPassword);
        String val2 = WebLogin.passwordTestField.getAttribute("type");
        Assert.assertEquals("text", val2);
        click(WebLogin.submitButton);
        Assert.assertTrue("Wrong email or password error message displayed", WebLogin.wrongPasswordMsg.isDisplayed());
  //      Verifications.elementIsVisible(WebLogin.accountBlockedMsg);
  //      Assert.assertTrue("Account blocked error message displayed", WebLogin.accountBlockedMsg.isDisplayed());

        //copy paste email ID
        //Validate by entering valid email and password
        deleteText(WebLogin.emailTestField);
        deleteText(WebLogin.passwordTestField);
        updateText(WebLogin.emailTestField, getData("validEmail"));
        copyPasteText(WebLogin.emailTestField);
        updateText(WebLogin.passwordTestField, getData("Password"));
        click(WebLogin.submitButton);

        switchToParentWindow(currentWindow);
        waitForLoad();
        Verifications.verifyTextInElement(WebLogin.userName, getData("user"));
        scrollToElement(WebLoading.logout);
	    Verifications.elementIsVisible(WebLoading.logout);
	    click(WebLoading.logout);

    }


	@Test(description = "Test04 - Verify forgot password link", groups= {"CO"})
    @Description("This test verifies forgot password link")
    public void test04_verifyForgotPasswordLink() throws InterruptedException
	{
	//	WebFlows.loadWebsite();
        String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(WebLogin.weWorkLoginButton);
        click(WebLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);

        click(WebLogin.forgotPassword);
        Assert.assertEquals(WebLogin.resetPasswordField.getText(), "Reset your password");
        deleteText(WebLogin.emailTestField);
        updateText(WebLogin.emailTestField, getData("validEmail"));
        click(WebLogin.sendEmailButton);
        Verifications.elementIsVisible(WebLogin.emailSentToResetPswrdMsg);
        Assert.assertTrue("Email sent to reset your password- message displayed", WebLogin.emailSentToResetPswrdMsg.isDisplayed());
        loadTime(3);

    }


	@Test(description = "Test05 - Verify Signup text fields", groups= {"CO"})
    @Description("This test verifies Sign up text fields")
    public void test05_verifySignUpTextFields() throws InterruptedException
	{
	//	WebFlows.loadWebsite();
        String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(WebLogin.weWorkLoginButton);
        click(WebLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);

        click(WebLogin.signUpBtn);
      //click on submit without entering email and password and validate for error messages
        click(WebLogin.submitButton);
        Assert.assertTrue("Email can't be blank error message displayed", WebLogin.emailEmptyErrorMsg.isDisplayed());
        Assert.assertTrue("Password can't be blank error message displayed",WebLogin.passwordEmptyErrorMsg.isDisplayed());

        //Enter white spaces in email and check for error message
        updateText(WebLogin.emailTestField, getData("whiteSpaces"));
        Assert.assertTrue("Email can't be blank error message displayed",WebLogin.emailBlankErrorMsg.isDisplayed());

        //enter invalid email and validate the error message
        deleteText(WebLogin.emailTestField);
        updateText(WebLogin.emailTestField, getData("invalidEmail"));
        click(WebLogin.submitButton);
        Assert.assertTrue("Invalid email error message displayed",WebLogin.invalidEmailErrorMsg.isDisplayed());

        //Enter worng password
        //Validate show password button
        deleteText(WebLogin.emailTestField);
        updateText(WebLogin.emailTestField, getData("validEmail"));
        updateText(WebLogin.passwordTestField, getData("invalidPassword"));
        String val = WebLogin.passwordTestField.getAttribute("type");
        Assert.assertEquals("password", val);
        click(WebLogin.showPassword);
        String val2 = WebLogin.passwordTestField.getAttribute("type");
        Assert.assertEquals("text", val2);
        click(WebLogin.submitButton);
        Assert.assertTrue("Invalid password error message displayed", WebLogin.invalidPasswordErrorMsg.isDisplayed());
        click(WebLogin.showPassword);

        //copy paste email ID
        //Validate by entering valid email and password
        deleteText(WebLogin.emailTestField);
        deleteText(WebLogin.passwordTestField);
        updateText(WebLogin.emailTestField, getData("validEmail"));
        copyPasteText(WebLogin.emailTestField);
        updateText(WebLogin.passwordTestField, getData("Password"));
        click(WebLogin.submitButton);


        loadTime(9);
    }



   @Test(description = "Test06 - Verify User is able to navigate to terms and services", groups= {"CO"})
    @Description("This test verifies that User is able to navigate to terms and services")
    public void test04_verifyTermsAndConditions() throws InterruptedException {
    //	WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
        scrollToElement(WebLoading.termsAndServices);
        Verifications.elementIsVisible(WebLoading.termsAndServices);
        click(WebLoading.termsAndServices);
       String title= driver.getTitle();
        Verifications.verifyPageTitle(title, "WeWork - Terms and Conditions");
        scrollToElement(WebLoading.logout);
	    Verifications.elementIsVisible(WebLoading.logout);
	    click(WebLoading.logout);
    }


	@Test(description = "Test07 - Verify User is able to select why wework option", groups= {"CO"} )
    @Description("This test verifies that User is able to select why wework option")
    public void test05_SelectWhyWework() throws InterruptedException
    {
	//	WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(WebHome.whyWEWorkButton);
		click(WebLoading.select("Discover workspaces"));
		click(WebLoading.allAccessButton);
		click(WebLoading.loctnDropdown2);
    	click(WebLoading.selectloc("Delhi-NCR"));
    	click(WebLoading.buildingDropdown);
    	click(WebLoading.select("Blue One Square"));
    	click(WebLoading.select("Book a workspace"));
    	updateText(WebLoading.fullName, getData("name"));
        updateText(WebLoading.email, getData("email"));
        updateText(WebLoading.phnNumber, getData("phoneNumber"));
		scrollToElement(WebLoading.plusIcon);
		WebFlows.selectNoOfPeople(2);
		WebFlows.selectDate("2024", "September", "26");
//		click(WebLoading.continueBtn);
//      String actualText = WebLoading.thankyouText.getText();
//      Verifications.verifyText(actualText,"Thank you for contacting WeWork");
//      click(WebLoading.backToHomePageBtn);
        mouseHover(WebLoading.closeIcon);
        WebFlows.logoutOfApplication();

    }

	@Test(description = "Test06 - Verify User is able to Select contact us option")
    @Description("This test verifies that User is able to Select contact us option")
    public void test06_VerifyContactUsFeature() throws InterruptedException
    {
	//	WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	click(WebLoading.contactUsBtn);
    	scrollToElement(WebLoading.fullName);
    	Verifications.elementIsVisible(WebLoading.fullName);
    	updateText(WebLoading.fullName, getData("name"));
        updateText(WebLoading.email, getData("email"));
        updateText(WebLoading.phnNumber, getData("phoneNumber"));
        scrollToElement(WebLoading.loctnDropdown);
        click(WebLoading.loctnDropdown);
        click(WebLoading.CityTwo);
        mouseHover(WebLoading.scheduleVistiBtn);
        click(WebLoading.getInTouchBtn);
        WebFlows.logoutOfApplication();

    }

}
