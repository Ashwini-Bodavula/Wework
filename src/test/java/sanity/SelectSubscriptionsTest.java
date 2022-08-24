package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectSubscriptionsTest extends CommonOps
{

	@Test(description = "Test01 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions", groups= {"CO"})
    @Description("This test verifies that User is able to select subscriptions")
    public void test01_SelectSubscriptions(String officeType , String selectOption, String textInHeader) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	click(WebLoading.workspaceDrpdwn);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	click(WebLoading.opt(officeType));
    	String subscriptionType = WebLoading.subscriptionType.getText();
    	if(subscriptionType.contains(textInHeader))
    	{
    		click(WebLoading.loctnDropdown2);
        	click(WebLoading.selectloc("Delhi-NCR"));
        	click(WebLoading.buildingDropdown);
        	click(WebLoading.select("Blue One Square"));
        	Verifications.elementIsVisible(WebLoading.select(selectOption));
        	click(WebLoading.select(selectOption));
        	Verifications.elementIsVisible(WebLoading.nameField);
        	updateText(WebLoading.nameField, getData("name"));
            updateText(WebLoading.emailField, getData("email"));
            updateText(WebLoading.phonenNumberField, getData("phoneNumber"));
            scrollToElement(WebLoading.plusIcon);
			WebFlows.selectNoOfPeople(3);
			WebFlows.selectDate("2024", "September", "26");
//            click(WebLoading.continueBtn);
//            String actualText = WebLoading.thankyouText.getText();
//            Verifications.verifyText(actualText,"Thank you for contacting WeWork");
//            click(WebLoading.backToHomePageBtn);
			mouseHover(WebLoading.closeIcon);
            WebFlows.logoutOfApplication();
    	}
    	else
    	{
    		Assert.assertTrue(false, "Subscription type mismatch");

    	}


    }

	@DataProvider(name="Subscriptions")
	public Object[][] subscriptions()
	{
		return new Object[][] {
			{"Ready-to-move-in private offices","Know more","Private Office Space"},
			{"Hot desk", "Book a workspace","Hot Desk"},
			{"All Access","Book a workspace","All Access"},
			{"Office suite","Enquire now","Office Suite"}
			};

	}

}
