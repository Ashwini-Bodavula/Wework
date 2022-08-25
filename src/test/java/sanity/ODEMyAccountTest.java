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
public class ODEMyAccountTest extends MyAccPageODE {

	 @Test(description = "Test01 - Verify ODE Enterprise confirmed")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test01_ODE_Enterprise() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Enterprise_confirmed("CONFIRMED","Cancel","Cancel");
		    ODEflows.logoutODE();
	    }
	 
    @Test(description = "Test02 - Verify ODE profile")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test02_ODE_profile() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.ODE_profile();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test03 - Verify ODE support")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test03_ODE_support() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.ODE_support();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test04 - Verify Add employee")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test04_OD_AddEmployee() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.ODE_AddEmployee();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test05 - Verify search employee")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test05_ODE_searchEmployee() throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.ODE_searchEmployee();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test06 - Verify update employee")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test06_ODE_edit() throws InterruptedException{
		
	    	ODEflows.loginToODE();
		    ODEflows.ODE_editEmployee();
		    ODEflows.logoutODE();
	    }
	  

}
