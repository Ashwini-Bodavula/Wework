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
	
    	@Test(description = "Test02 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test04_Dashboard_subscription() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.dashboard_active();
	        WebFlows.logoutOfApplication();
	    		    	
	     }*/
    	
    	@Test(description = "Test02 - Verify User profile details", groups= {"OD"})
	    @Description("This test verifies that User details are as given")

    	 public void test05_TeamMember() throws InterruptedException
    	 {
    		WebFlows.loginToApplication();         	
	    	MyAccount.remove_TeamMember();
	        WebFlows.logoutOfApplication();
	    		    	
	     }	

	/* @Test(description = "Test03 - Verify User Team details", groups= {"OD"})
       @Description("This test verifies that User team details")

     public void test03_Team() throws InterruptedException{

	WebFlows.ODLogin();
	click(WebODLogin.Hamberger);
	if(MyAcc.MyAccount.isDisplayed()) {
    	click(MyAcc.MyAccount);
        click(MyAcc.Team);
        if(MyAcc.remove.isDisplayed()) {
        	click(MyAcc.remove);
        }
       click(MyAcc.AddMember);
       updateText(MyAcc.MemberName, getData("Name"));
       updateText(MyAcc.MemberEmail, getData("Email"));
       click(MyAcc.save);
       WebFlows.ODlogout();
  }

  }


	 @Test(description = "Test04 - Verify User referral link", groups= {"OD"})
	@Description("This test verifies that User referral link")
	
	public void test04_Refer() throws InterruptedException{

	WebFlows.ODLogin();
	click(WebODLogin.Hamberger);
	if(MyAcc.MyAccount.isDisplayed()) {
    	click(MyAcc.MyAccount);
        click(MyAcc.Refer);
        if(MyAcc.copybtn.isEnabled()) {
        	String reflink=MyAcc.referlink.getAttribute("value");
            System.out.println(reflink);
        }
        else
        {
        	String reflink=MyAcc.referlink.getAttribute("value");
        	Assert.assertEquals(" ", reflink);
        }
        WebFlows.ODlogout();
  }

  }

	 @Test(description = "Test05 - Verify Refer from nav bar with login", groups= {"OD"})

@Description("This test Verify Refer from nav bar with login")

public void test05_NavRefer() throws InterruptedException{

	WebFlows.ODLogin();
	click(MyAcc.nav_refer);
        if(MyAcc.copybtn.isEnabled()) {
        	String reflink=MyAcc.referlink.getAttribute("value");
            System.out.println(reflink);
        }
        else
        {
        	String reflink=MyAcc.referlink.getAttribute("value");
        	Assert.assertEquals(" ", reflink);
        }
        WebFlows.ODlogout();


  }
	 @Test(description = "Test06 - Verify Refer from nav bar without login", groups= {"OD"})

	 @Description("This test Verify Refer from nav bar without login")

	 public void test06_NavRefer() throws InterruptedException{

		// WebFlows.loadODWebsite();
		 click(MyAcc.nav_refer);
		 Verifications.elementIsVisible(MyAcc.refer_login);
	         if(MyAcc.refer_login.isDisplayed()) {
	        	 String currentWindow = getWindowHandel();
	        	 click(MyAcc.refer_login);
	        	 switchToLoginWindow(currentWindow);
	             updateText(WebODLogin.emailTestField, getData("Username"));
	             updateText(WebODLogin.passwordTestField, getData("Password"));
	             click(WebODLogin.submitButton);
	             System.out.println("submit");
	             switchToParentWindow(currentWindow);
	         }
	         WebFlows.ODlogout();
	   }

    @Test(description = "Test07 - Verify latest booking of Daypass", groups= {"OD"})

	 @Description("This test Verify  latest booking of Daypass")

	 public void test07_Booking() throws InterruptedException{

	      WebFlows.ODLogin();
	      click(WebODLogin.Hamberger);
	      click(MyAcc.MyAccount);
		 click(MyAcc.Bookings);
		 String Day_flt=MyAcc.Daypass_filter.getAttribute("value");
		 Assert.assertEquals(Day_flt, "DAY_PASS");
		 String row1=MyAcc.orde_row1.getText();
		 System.out.println(row1);
	         WebFlows.ODlogout();
	   }
    
    
    @Test(description = "Test07 - Verify booking_filter", groups= {"OD"})

    @Description("This test Verify  latest booking_filter")

     public void test08_Booking_filter() throws InterruptedException{

        WebFlows.ODLogin();
        click(WebODLogin.Hamberger);
        click(MyAcc.MyAccount);
        click(MyAcc.Bookings);
        String Day_flt=MyAcc.Daypass_filter.getAttribute("value");
        Assert.assertEquals("DAY_PASS", Day_flt);
        updateDropDown(MyAcc.Daypass_filter, "Conference Room");
        Day_flt=MyAcc.Daypass_filter.getAttribute("value");
        Assert.assertEquals(Day_flt, "CONFERENCE_ROOM");
         WebFlows.ODlogout();
   }  	 */
}
