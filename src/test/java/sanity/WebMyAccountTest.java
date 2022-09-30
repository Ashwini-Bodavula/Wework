package sanity;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.MyAccount;
import workflows.WebFlows;
import static extensions.UIActions.*;

@Listeners(utilities.Listeners.class)
public class WebMyAccountTest extends CommonOps {


	/*	@Test(description = "Test01 - Verify User is able to view all bookings", groups= {"CO"})			 
	    @Description("This test verifies that User chnages and profile ")
	    public void test01_dashboardviewAll() throws InterruptedException
		{

	    	WebFlows.loginToApplication();        	
	    	MyAccount.dashboardViewAll();
	        WebFlows.logoutOfApplication();
	    }

		 @Test(description = "Test02 - Verify User is able to view all bookings", groups= {"CO"})		 
		 @Description("This test verifies that User chnages and profile ")
		 public void test02_dashboardviewdetails() throws InterruptedException
		 {

		    	WebFlows.loginToApplication();         	
		    	MyAccount.dashboardViewdetails();
		        WebFlows.logoutOfApplication();
		 }

		 @Test(description = "Test03 - Verify User is able to view all bookings", groups= {"CO"})		 
		 @Description("This test verifies that User chnages and profile ")
		 public void test03_profile() throws InterruptedException
		 {

		    	WebFlows.loginToApplication();         	
		    	MyAccount.profile();
		        WebFlows.logoutOfApplication();
		 }
	
    	@Test(description = "Test04 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test04_Dashboard_subscription() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.dashboard_active();
	        WebFlows.logoutOfApplication();
	    		    	
	     }
    	
    	@Test(description = "Test05 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test05_TeamMember_add() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.add_TeamMember();
	        WebFlows.logoutOfApplication();
	    		    	
	     }	
    	
    	@Test(description = "Test06 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test06_removeTeamMember() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.remove_TeamMember();
	        WebFlows.logoutOfApplication();
	    		    	
	     }	

    	@Test(description = "Test07 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test07_removeTeamMemberMultiple() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.add_TeamMember();
	    	MyAccount.add_TeamMember();
	    	MyAccount.add_TeamMember();
	        WebFlows.logoutOfApplication();
	    		    	
	     }*/
    	
    	@Test(description = "Test08 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test07_creditBundle() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.credits_Bundle();
	        WebFlows.logoutOfApplication();
	    		    	
	     }
}
