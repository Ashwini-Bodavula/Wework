package sanity;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.MyAccount;
import workflows.WebFlows;

public class WifiResetTest extends CommonOps {
	
	@Test(description = "Test01 - Verify Connect to WIFI Reset credentials", groups= {"CO"})
	 @Description("This test Verify Connect to WIFI Reset credentials")
   
   public void test01_RescheduleBooking()throws InterruptedException{
   {
   	 
			WebFlows.loginToApplication();
			MyAccount.wifi();


   }
	}
}
