package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;
import static pageObjects.web.Daypass_OD.skipPay;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import pageObjects.web.Daypass_OD;
import pageObjects.web.MyAccPageODE;
import utilities.CommonOps;
import workflows.ODEflows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ODEBooking extends MyAccPageODE {

	/* @Test(description = "Test01 - Verify ODE Enterprise confirmed is cancelled All", groups= {"ODE"})
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test01_ODE_confirmed_cancelAll() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Enterprise_confirmed("CONFIRMED","Cancel","Cancel All");
		    ODEflows.logoutODE();
	    }*/

	 @Test(description = "Test02 - Verify in multiple booking single pass is removed", groups= {"ODE"})
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test02_ODE_confirmed_Done() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Enterprise_confirmed("CONFIRMED","Cancel","Done");
		    ODEflows.logoutODE();
	    }
	 
	/* @Test(description = "Test03 - Verify admin approved the pending request", groups= {"ODE"})
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test03_ODE_pending_Approve() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Enterprise_pending("Pending","Approve");
		    ODEflows.logoutODE();
	    }
	 @Test(description = "Test04 - Verify admin rejected the pending request", groups= {"ODE"})
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test04_ODE_pending_Rejected() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Enterprise_pending("Pending","Rejected");
		    ODEflows.logoutODE();
	    }*/

	 
}
