package sanity;
import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    }*/
	
	@Test(description = "Test04 - Verify User is able to select shop.")
    @Description("This test verifies that User is able to select shop.")
    public void test04_shopSelection() throws InterruptedException
    {
		AdminFlows.loginToODDashboard();
		
		click(ODAdminUser.shopTab);
		
		List<WebElement> shopList = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3']"));
		for(int i=0;i<shopList.size();i++)
		{
			String itemInList = shopList.get(i).getText();
			if(itemInList.contains("Printing"))
			{
				int j=0;
				j = i+1;
				driver.findElement(By.xpath("//div[@class='ray-card__content']//a["+j+"]")).click();
				
				click(ODAdminUser.buildingDrpdwn);
				click(ODAdminUser.select(getData("loc1")));
//				
//				Thread.sleep(4000);
//				Verifications.elementIsVisible(ODAdminUser.colorPrinting);
//				click(ODAdminUser.colorPrinting);
//				updateText(ODAdminUser.userEmail, getData("userEmail"));
//				scrollToElement(ODAdminUser.plusBtn);
//				
//				click(ODAdminUser.plusBtn);
//				click(ODAdminUser.plusBtn);
//				click(ODAdminUser.plusBtn);
//				
				Thread.sleep(5000);
			}
			
		}
		
		
		System.out.println();
		
		Thread.sleep(5000);
		
		
		
		//AdminFlows.logoutOfODDashboard();
    }
	
}