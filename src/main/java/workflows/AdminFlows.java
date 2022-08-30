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
	public static void addUser(String userEmail, String password, String userName, String location1,String isSuperAdmin,String isPostpqaidUser)
	{
		
		click(ODAdminUser.adminUsers);
		click(ODAdminUser.addUserBtn);
		updateText(ODAdminUser.userEmail, userEmail);
		updateText(ODAdminUser.userpassword, password);
		updateText(ODAdminUser.userName,userName);
		click(ODAdminUser.SelectBuildingDrpdwn);
		click(ODAdminUser.selectBuilding(location1));
		if(isSuperAdmin.equals("YES"))
		{
			mouseHover(ODAdminUser.isSuperAdminBtn);
		}
		if(isPostpqaidUser.equals("YES"))
		{
			mouseHover(ODAdminUser.isPostPaidUserBtn);
		}
		click(ODAdminUser.addBtn);
		Verifications.elementIsVisible(ODAdminUser.userCreatedMessage);
		String message = ODAdminUser.userCreatedMessage.getText();
		Assert.assertEquals(message, "User Created Successfully");
		waitForLoad();
		Verifications.elementIsVisible(ODAdminUser.closeBtn);
		if(ODAdminUser.closeBtn.isDisplayed())
		{
			click(ODAdminUser.closeBtn);
			waitForLoad();
		}
		
		
		
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
	public static void editUser(String oldName,  String newName, String newLoc) throws InterruptedException
	{
		//boolean userDetailsFound = false;
		scrollToElement(ODAdminUser.select(oldName));
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
				click(ODAdminUser.selectBuilding(newLoc));
				click(ODAdminUser.updateBtn);
				Verifications.elementIsVisible(ODAdminUser.closeBtn);
				if(ODAdminUser.closeBtn.isDisplayed())
				{
					click(ODAdminUser.closeBtn);
					waitForLoad();
				}
				break;		
			}
		}
	}
	
	@Step("Delete user")
	public static void deleteUser(String newName) throws InterruptedException
	{
		scrollToElement(ODAdminUser.select(newName));
		List<WebElement> usersList = driver .findElements(By.xpath("//tbody/tr"));
		for(int i=0;i<usersList.size();i++)
		{
			String selectedUserDetails = usersList.get(i).getText();
			if(selectedUserDetails.contains(newName))
			{
				int j;
				j=i+1;
				driver.findElement(By.xpath("//tbody/tr["+j+"]/td/button[contains(text(),'Delete')]")).click();
				click(ODAdminUser.deleteBtn);
				
				Verifications.elementIsVisible(ODAdminUser.closeBtn);
				if(ODAdminUser.closeBtn.isDisplayed())
				{
					click(ODAdminUser.closeBtn);
					waitForLoad();
				}
			    break;		
			}
		}
	}
	
	
	@Step("Search user")
	public static boolean searchUser(String user,  String email , String buildingName , String isPostPaidUser, String isAdmin)
	{
		boolean userDetailsFound = false;
		click(ODAdminUser.adminUsers);
		List<WebElement> usersList = driver .findElements(By.xpath("//tbody/tr"));
		for(int i=0;i<usersList.size();i++)
		{
			String selectedUserDetails = usersList.get(i).getText();
			
			if(selectedUserDetails.contains(user))
			{
				String[] details = selectedUserDetails.split(" ");
				int len = details.length;
				
				if(details[0].equals(user) && details[1].equals(email) && details[len -3].equals("NO") && details[len -2].equals("YES") )
				{
					String loc = details[2] +" "+details[3]+" "+details[4].split(",")[0];
					if(loc.equals(buildingName))
					{
						userDetailsFound = true;
					}
					else
					{
						loc = details[5] +" "+details[6]+" "+details[7].split(",")[0];
						if(loc.equals(buildingName))
						{
							userDetailsFound = true;
						}
					}
				}
			}
		}
		return userDetailsFound;
	}
}
