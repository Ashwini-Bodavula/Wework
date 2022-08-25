package workflows;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class AdminFlows extends CommonOps {

	@Step("Login to the application")
	public static void loginToODDashboard() throws InterruptedException 
	{
		updateText(ODAdminUser.Email, getData("ODUserEmail"));
		updateText(ODAdminUser.password, getData("ODUserPwd"));
		click(ODAdminUser.loginBtn);

	}

	@Step("Logout of the application")
	public static void logoutOfODDashboard() throws InterruptedException 
	{
		Verifications.elementIsVisible(ODAdminUser.logoutBtn);
		scrollToElement(ODAdminUser.logoutBtn);
		click(ODAdminUser.logoutBtn);

	}
	
	@Step("Add user")
	public static void addUser()
	{
		click(ODAdminUser.adminUsers);
		click(ODAdminUser.addUserBtn);
		updateText(ODAdminUser.userEmail, getData("userEmail"));
		updateText(ODAdminUser.userpassword, getData("userPassword"));
		updateText(ODAdminUser.userName, getData("name"));
		click(ODAdminUser.SelectBuildingDrpdwn);
		click(ODAdminUser.PrestigeAtlanatBuilding);
		mouseHover(ODAdminUser.isSuperAdminBtn);
		click(ODAdminUser.addBtn);
		Verifications.elementIsVisible(ODAdminUser.userCreatedMessage);
		String message = ODAdminUser.userCreatedMessage.getText();
		Assert.assertEquals(message, "User Created Successfully");
		waitForLoad();
		
	}
	
	@Step("Search user")
	public static boolean searchUserDetails(String user,  String email , String buildingName , String isAdmin)
	{
		boolean userDetailsFound = false;
		click(ODAdminUser.adminUsers);
		List<WebElement> usersList = driver .findElements(By.xpath("//tbody/tr"));
		for(int i=0;i<usersList.size();i++)
		{
			String selectedUserDetails = usersList.get(i).getText();
			if(selectedUserDetails.contains(user))
			{
				if(selectedUserDetails.contains(email))
				{
					if(selectedUserDetails.contains(buildingName))
					{
						if(selectedUserDetails.contains(isAdmin))
						{
							
							userDetailsFound = true;
							Assert.assertTrue(userDetailsFound);
							break;
						}
						
					}
				}
			}
		}
		return userDetailsFound;
	}
	
	
	@Step("Edit user")
	public static void editUser(String oldName,  String newName) throws InterruptedException
	{
		//boolean userDetailsFound = false;
		scrollToElement(ODAdminUser.select(getData("name")));
		List<WebElement> usersList = driver .findElements(By.xpath("//tbody/tr"));
		for(int i=0;i<usersList.size();i++)
		{
			String selectedUserDetails = usersList.get(i).getText();
			if(selectedUserDetails.contains(oldName))
			{
				int j;
				j=i+1;
				driver.findElement(By.xpath("//tbody/tr["+j+"]/td/button[contains(text(),'Edit')]")).click();
				
				UIActions.clearTextBox(ODAdminUser.userName);
				updateText(ODAdminUser.userName, newName);
				click(ODAdminUser.SelectBuildingDrpdwn);
				click(ODAdminUser.FuturaBuilding);
				click(ODAdminUser.updateBtn);
				break;		
			}
		}
	}
	
	

}
