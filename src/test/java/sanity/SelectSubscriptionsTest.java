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

	@Test(description = "Test01 - Verify User is able to select subscriptions" ,dataProvider = "Subscriptions", groups= {"COD"})
    @Description("This test verifies that User is able to select subscriptions")
    public void test01_SelectSubscriptions(String workspaceType , String headerText) throws InterruptedException
    {
    	WebFlows.loginToApplication();
    	click(WebLoading.workspaceDrpdwn);
    	click(WebLoading.opt(workspaceType));
    	String headerTextBox = WebLoading.subscriptionType.getText();
    	if(headerTextBox.contains(headerText))
    	{
    		WebFlows.selectLocationAndBuilding();
        	WebFlows.header_fillTheFormDetails();
    	}
    	else
    	{
    		Assert.assertTrue(false, "Subscription type mismatch");
    	}
    	WebFlows.logoutOfApplication();

    }

	@DataProvider(name="Subscriptions")
	public Object[][] subscriptions()
	{
		return new Object[][] {
			{"Ready-to-move-in private offices","Private Office Space"},
//			{"Hot desk","Hot Desk"},
//			{"All Access","All Access"},
//			{"Office suite","Office Suite"}
			};

	}

}
