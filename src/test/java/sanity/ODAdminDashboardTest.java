package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import org.testng.Assert;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.AdminFlows;
import workflows.WebFlows;

public class ODAdminDashboardTest extends CommonOps
{
/*	@Test(description = "Test01 - Verify User is able to add Admin user")
    @Description("This test verifies that User is able to add Admin user")
    public void test01_AddAdminUser() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		AdminFlows.addUser();
		Thread.sleep(6000);
		UIActions.loadTime(4);
		AdminFlows.logoutOfODDashboard();
    }*/
	
	@Test(description = "Test02 - Verify User is able to edit Admin user")
    @Description("This test verifies that User is able to edit Admin user")
    public void test01_EditAdminUser() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		boolean userDetailsFound = AdminFlows.searchUserDetails(getData("name"),getData("userEmail"), "Prestige Atlanta, Koramangala", "YES");
		
		if(userDetailsFound == true)
		{
			AdminFlows.editUser(getData("name"),getData("newName"));
			Thread.sleep(6000);
			
		}
		//AdminFlows.logoutOfODDashboard();
    }
	

}
