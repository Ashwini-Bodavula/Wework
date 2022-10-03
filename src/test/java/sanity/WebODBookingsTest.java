package sanity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.MyAccount;
import workflows.WebFlows;
import static extensions.UIActions.*;

import io.qameta.allure.Description;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class WebODBookingsTest extends CommonOps{
	
    @Test(description = "Test01 - Verify Reschedule Day Pass booking of Daypass", groups= {"CO"})
	 @Description("This test Verify Reschedule Day Pass booking of Daypass")
    
    public void test01_RescheduleBooking()throws InterruptedException{
    {
    	 
			WebFlows.loginToApplication();
			MyAccount.Daypass();

			
		
		}
	      
    }
    


}
