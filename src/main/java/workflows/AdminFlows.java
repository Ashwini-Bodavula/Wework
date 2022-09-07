package workflows;
import static extensions.UIActions.clearTextBox;
import static extensions.UIActions.click;
import static extensions.UIActions.loadTime;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateText;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
<<<<<<< HEAD
	
	@Step("Search user")
	public static void increaseQuantity(String number)
	{
		int count = Integer.parseInt(number);
		for(int k=1;k<count;k++)
		{
			click(ODAdminUser.plusBtn);
		}
	}
	
	@Step ("Convert String value of price to integer")
    public static int priceValueInt(String price)
    {
    	String priceValueInString = "";
		for(int i=0;i<price.length();i++)
		{
				char ch = price.charAt(i);
				if(ch == '.')
				{
					break;
				}
				priceValueInString = priceValueInString+ch;
		}
		int priceValueinInt = Integer.parseInt(priceValueInString);
		return priceValueinInt;
    }
	
	@Step ("Validate the order details")
    public static boolean validateOrderDetails(String shopType, String count, String location, String userEmail, String GSTN )
    {
		boolean detailsValidated = false;
		String printingPrice = ODAdminUser.getPrice(shopType).getText();
		String price = 	printingPrice.split("₹")[1];
		int priceInInt = AdminFlows.priceValueInt(price);
		int totalAmount = Integer.parseInt(ODAdminUser.total.getText().split("₹")[1]);
		String bookingDetailsinFrame = ODAdminUser.billingDetailsList.getText();
		String[] bookingDetails = bookingDetailsinFrame.split("\r?\n|\r");
		int finalPrice = priceInInt*Integer.parseInt(count);
		int k=4;
		if(bookingDetails[k].equals(location))
		{
			if(bookingDetails[k+1].equals(count))
			{
				if(bookingDetails[k+2].equals(userEmail))
				{
					if(bookingDetails[k+3].equals(GSTN))
					{
						if(totalAmount==finalPrice)
						{
							detailsValidated = true;
						}
						
					}
				}
			}
		}
		return detailsValidated;
		
    }
	
	
	
	@Step ("Select shop")
    public static void selectShop(String optService, String location, String option, String count, String email, String GSTN) throws InterruptedException
    {
		click(ODAdminUser.shopTab);
		List<WebElement> shopList = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3']"));
		for (int i = 0; i < shopList.size(); i++)
		{
			String itemInList = shopList.get(i).getText();
			
			if (itemInList.contains(optService)) // optService
			{
					int j = 0;
					j = i + 1;
					driver.findElement(By.xpath("(//div[@class='ray-card__content']//a[1])["+j+"]")).click();	
					click(ODAdminUser.buildingDrpdwn);
					updateText(ODAdminUser.selectBuilding, location);
					scrollToElement(ODAdminUser.select(location));
					click(ODAdminUser.select(location));
					click(ODAdminUser.opt(option));
					scrollToElement(ODAdminUser.plusBtn);
					AdminFlows.increaseQuantity(count);
					Verifications.elementIsVisible(ODAdminUser.opt(option));
					click(ODAdminUser.opt(option));
					updateText(ODAdminUser.customerEmail, email);
					updateText(ODAdminUser.customerGSTN,GSTN);
					
					boolean orderDetailsValidated = AdminFlows.validateOrderDetails("Color", count, location, email, GSTN);
					if(orderDetailsValidated == true)
					{
						//click(ODAdminUser.placeOrderBtn);
						Verifications.elementIsVisible(ODAdminUser.closeBtn);
						if(ODAdminUser.closeBtn.isDisplayed())
						{
							click(ODAdminUser.closeBtn);
							waitForLoad();
						}
						break;
					}
					else
					{
						Assert.assertTrue(false, "Order Details not Validated");
					}
			}
		}
		
    }
	
	@Step ("Select shop - Postpaid ")
    public static void selectShopForPostPaid(String optService, String postpaidEvent, String location, String price, String email, String name,String GSTN) throws InterruptedException
    {
		click(ODAdminUser.shopTab);
		List<WebElement> shopList = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3']"));
		for (int i = 0; i < shopList.size(); i++)
		{
			String itemInList = shopList.get(i).getText();
			
			if (itemInList.contains(optService)) // optService
			{
					int j = 0;
					j = i + 1;
					driver.findElement(By.xpath("(//div[@class='ray-card__content']//a[1])["+j+"]")).click();
					click(ODAdminUser.postPaidEventDropdown);
					updateText(ODAdminUser.postPaidEventDropdown, postpaidEvent);
					scrollToElement(ODAdminUser.select(postpaidEvent));
					click(ODAdminUser.select(postpaidEvent));
					click(ODAdminUser.selectBuilding);
					updateText(ODAdminUser.selectBuilding, location);
					scrollToElement(ODAdminUser.select(location));
					click(ODAdminUser.select(location));
					clearTextBox(ODAdminUser.price);
					updateText(ODAdminUser.price, price);
					updateText(ODAdminUser.customerEmail, email);
					updateText(ODAdminUser.customerName, name);
					updateText(ODAdminUser.customerGSTN,GSTN);
					Thread.sleep(5000);
					
					boolean orderDetailsValidated = AdminFlows.validateOrderDetailsForPostPaid(postpaidEvent,location, email,  name, GSTN, price);
					if(orderDetailsValidated == true)
					{
//						click(ODAdminUser.placeOrderBtn);
//						Verifications.elementIsVisible(ODAdminUser.closeBtn);
//						if(ODAdminUser.closeBtn.isDisplayed())
//						{
//							click(ODAdminUser.closeBtn);
//							waitForLoad();
//						}
						break;
					}
					else
					{
						Assert.assertTrue(false, "Order Details not Validated");
					}
				
			}
		}	
    }  
	
	@Step ("Validate the order details for Postpaid")
    public static boolean validateOrderDetailsForPostPaid(String postpaidEvent, String location,  String email, String name,String GSTN, String price) throws InterruptedException
    {
		boolean detailsValidated = false;

		String totalAmount = ODAdminUser.total.getText().split("₹")[1];
		String bookingDetailsinFrame = ODAdminUser.billingDetailsList.getText();
		String[] bookingDetails = bookingDetailsinFrame.split("\r?\n|\r");
		
		int k=7;
		if(bookingDetails[k].equalsIgnoreCase(postpaidEvent))
		{
			
			if(bookingDetails[k+1].equalsIgnoreCase(location))
			{
				if(bookingDetails[k+2].equalsIgnoreCase("1"))
				{	
					if(bookingDetails[k+3].equalsIgnoreCase(email))
					{
						if(bookingDetails[k+4].equalsIgnoreCase(name))
						{
							if(bookingDetails[k+5].equalsIgnoreCase(GSTN))
							{
								if(bookingDetails[k+6].contains(price) && bookingDetails[k+6].contains(totalAmount))
								{
										detailsValidated = true;				
								}	
							}	
						}
					}
				}	
			}
		}
		return detailsValidated;
		
    }
	
	@Step ("Select shop - ODE purchases")
    public static void selectShopForODEPurchases(String optService,String enterprise, String productType, String location, String email) throws InterruptedException
    {
		
		click(ODAdminUser.shopTab);
		List<WebElement> shopList = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3']"));
		for (int i = 0; i < shopList.size(); i++)
		{
			String itemInList = shopList.get(i).getText();
			
			if (itemInList.contains(optService)) // optService
			{
					int j = 0;
					j = i + 1;
					driver.findElement(By.xpath("(//div[@class='ray-card__content']//a[1])["+j+"]")).click();
					
					
					click(ODAdminUser.selectEnterprise);
					updateText(ODAdminUser.selectEnterprise, enterprise);
					scrollToElement(ODAdminUser.select(enterprise));
					click(ODAdminUser.select(enterprise));
					
					click(ODAdminUser.selectproductType);
					updateText(ODAdminUser.selectproductType, productType);
					scrollToElement(ODAdminUser.select(productType));
					click(ODAdminUser.select(productType));
					
					Thread.sleep(4000);
//					loadTime(4);
//					waitForLoad();
//					WebDriverWait wait = new WebDriverWait(driver,30);
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='MuiIconButton-label'])[2]")));
					
					Verifications.elementIsVisible(ODAdminUser.buildingDrpdwn);
					
					click(ODAdminUser.buildingDrpdwn);
					updateText(ODAdminUser.selectBuilding, location);
					scrollToElement(ODAdminUser.select(location));
					click(ODAdminUser.select(location));
					
					//click(ODAdminUser.bookinStartDate);w
					//WebFlows.selectDate("October", "29");
					
					click(ODAdminUser.plusBtnToincreaseCredits);
					click(ODAdminUser.plusBtnToincreaseRoomSize);
					
					updateText(ODAdminUser.conferenceRoom, "Test");
					
					updateText(ODAdminUser.customerEmail, email);
					//
					Thread.sleep(9000);
					break;
		
			}
		}	
    }
	
	@Step ("Validate the order details for ODE purchases")
    public static boolean validateOrderDetailsForODE(String location, String noOfGuests,  String meetingDate, String meetingTime,String conferenceRoom, String email) throws InterruptedException
    {
		boolean detailsValidated = false;

		String totalAmount = ODAdminUser.total.getText().split("₹")[1];
		String bookingDetailsinFrame = ODAdminUser.billingDetailsList.getText();
		String[] bookingDetails = bookingDetailsinFrame.split("\r?\n|\r");
		
		System.out.println(bookingDetails[6]);
		
		int k=6;
		if(bookingDetails[k].equalsIgnoreCase(location))
		{
			if(bookingDetails[k+1].equalsIgnoreCase(noOfGuests))
			{
				if(bookingDetails[k+2].equalsIgnoreCase(meetingDate))
				{	
					if(bookingDetails[k+3].equalsIgnoreCase(meetingTime))
					{
						if(bookingDetails[k+4].equalsIgnoreCase(conferenceRoom))
						{
							if(bookingDetails[k+5].equalsIgnoreCase(email))
							{
								
										detailsValidated = true;				
									
							}	
						}
					}
				}	
			}
		}
		return detailsValidated;
		
    }	
	
=======
>>>>>>> 9d7fb0c58103dd450b9b137e910252fdc7692464
}
