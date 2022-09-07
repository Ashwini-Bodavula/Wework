package sanity;
import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	/*@Test(description = "Test01 - Verify User is able to add Admin user")
    @Description("This test verifies that User is able to add Admin user")
    public void test01_AddAdminUser() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		AdminFlows.addUser(getData("userEmail"),getData("userPassword"),getData("name"),getData("loc1"),getData("isSuperAdmin"),getData("isPostpaidUser"));
		UIActions.loadTime(4);
		AdminFlows.logoutOfODDashboard();
    }
	
	@Test(description = "Test02 - Verify User is able to edit Admin user")
    @Description("This test verifies that User is able to edit Admin user")
    public void test02_EditAdminUser() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		boolean userDetailsFound = AdminFlows.searchUser(getData("name"),getData("userEmail"),getData("loc1"), getData("isPostpaidUser"), getData("isSuperAdmin"));
		if(userDetailsFound == true)
		{
			AdminFlows.editUser(getData("name"),getData("newName"), getData("loc2"));
		}
		else
		{
			Assert.assertTrue(userDetailsFound);
		}
		AdminFlows.logoutOfODDashboard();
    }
	
	@Test(description = "Test03 - Verify User is able to delete Admin user")
    @Description("This test verifies that User is able to delete Admin user")
    public void test03_DeleteAdminUser() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		boolean userDetailsFound = AdminFlows.searchUser(getData("newName"),getData("userEmail"),getData("loc1"), getData("isPostpaidUser"), getData("isSuperAdmin"));
		if(userDetailsFound == true)
		{
			AdminFlows.deleteUser(getData("newName"));
		}
		else
		{
			Assert.assertTrue(userDetailsFound);
		}
		AdminFlows.logoutOfODDashboard();
    }
	
	@Test(description = "Test04 - Verify User is able to select shop - printing.")
	@Description("This test verifies that User is able to select shop - printing.")
	public void test04_shopSelectionPrinting() throws InterruptedException 
	{
		AdminFlows.loginToODDashboard();		
		AdminFlows.selectShop("Printing", getData("loc1"),"Color",getData("count"), getData("userEmail"), getData("GSTN"));
		AdminFlows.logoutOfODDashboard();
	}
	
	@Test(description = "Test05 - Verify User is able to select shop - postpaid.")
	@Description("This test verifies that User is able to select shop - Postpaid.")
	public void test05_shopSelectionPostpaid() throws InterruptedException 
	{
		AdminFlows.loginToODDashboard();
		AdminFlows.selectShopForPostPaid("Postpaid Events" ,getData("eventType"), getData("loc1"), getData("price"),  getData("userEmail"),getData("name"), getData("GSTN"));
		AdminFlows.logoutOfODDashboard();
	}*/
	
	@Test(description = "Test06 - Verify User is able to select shop - ODE purchase.")
	@Description("This test verifies that User is able to select shop - ODE purchase.")
	public void test06_shopSelectionODEPurchase() throws InterruptedException 
	{
		AdminFlows.loginToODDashboard();
		
		AdminFlows.selectShopForODEPurchases("ODE purchases","5th-main","Conference room",getData("loc1"),getData("userEmail") );
		
		AdminFlows.validateOrderDetailsForODE(getData("loc1"),getData("count"), getData("date"),  getData("time"),getData("conference room"), getData("userEmail"));
		
		AdminFlows.logoutOfODDashboard();
	}
	
}