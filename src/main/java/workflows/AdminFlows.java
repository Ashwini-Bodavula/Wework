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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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

	
	@Step("Increase quantity")
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
		String price = 	printingPrice.split("???")[1];
		int priceInInt = AdminFlows.priceValueInt(price);
		int totalAmount = Integer.parseInt(ODAdminUser.total.getText().split("???")[1]);
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
	
	@Step ("Select shop - Printing")
    public static void selectShopForPrinting(String location, String option, String count, String email, String GSTN) throws InterruptedException
    {
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
		updateText(ODAdminUser.customerGSTN, GSTN);

		boolean orderDetailsValidated = AdminFlows.validateOrderDetails("Color", count, location, email, GSTN);
		if (orderDetailsValidated == true) 
		{
			click(ODAdminUser.placeOrderBtn);
			Verifications.elementIsVisible(ODAdminUser.closeBtn);
			if (ODAdminUser.closeBtn.isDisplayed()) 
			{
				click(ODAdminUser.closeBtn);
				waitForLoad();
			}
			boolean shopPurchaseDetailsValidated = AdminFlows.validateShopPurchaseDetails(location, email, "Printing");
			Assert.assertTrue(shopPurchaseDetailsValidated, "Shop purchase order details validated");
		} 
		else 
		{
			Assert.assertTrue(false, "Order Details not Validated");
		}
		
    }
	
	@Step ("Select shop - Postpaid ")
    public static void selectShopForPostPaid(String optService, String postpaidEvent, String location, String price, String email, String name,String GSTN) throws InterruptedException
	{
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
		updateText(ODAdminUser.customerGSTN, GSTN);
		boolean orderDetailsValidated = AdminFlows.validateOrderDetailsForPostPaid(postpaidEvent, location, email, name,
				GSTN, price);
		if (orderDetailsValidated == true) 
		{
			click(ODAdminUser.placeOrderBtn);
			Verifications.elementIsVisible(ODAdminUser.closeBtn);
			if (ODAdminUser.closeBtn.isDisplayed()) 
			{
				click(ODAdminUser.closeBtn);
				waitForLoad();
			}
			boolean shopPurchaseDetailsValidated = AdminFlows.validateShopPurchaseDetails(location, email,
					getData("eventType"));
			Assert.assertTrue(shopPurchaseDetailsValidated, "Shop purchase order details validated");
		} 
		else 
		{
			Assert.assertTrue(false, "Order Details not Validated");
		}	
    }  
	
	@Step ("Validate the order details for Postpaid")
    public static boolean validateOrderDetailsForPostPaid(String postpaidEvent, String location,  String email, String name,String GSTN, String price) throws InterruptedException
    {
		boolean detailsValidated = false;

		String totalAmount = ODAdminUser.total.getText().split("???")[1];
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
    public static void selectShopForODEPurchases() throws InterruptedException
	{
		AdminFlows.selectEnterpriseProductBuilding(getData("enterprise"), getData("productType1"), getData("loc1"));
		String dateSelected = AdminFlows.selectDate(getData("month3"), getData("date1"));
		String monthName = AdminFlows.trimMonth(dateSelected);
		AdminFlows.selectSlot(getData("time1"), getData("time2"));
		String timeSlot = AdminFlows.meetingTime(getData("time1"), getData("time2"));
		AdminFlows.selectRoomSizeAndCredits(getData("conferenceRoomSize"), getData("creditsSize"), getData("manager"));

		boolean validationResult = AdminFlows.validateOrderDetailsForODE(getData("loc1"), getData("conferenceRoomSize"),
				monthName, timeSlot, "Test", getData("manager"));

		if (validationResult == true) 
		{
			click(ODAdminUser.placeOrderBtn);
			Verifications.elementIsVisible(ODAdminUser.closeBtn);
			if (ODAdminUser.closeBtn.isDisplayed()) 
			{
				click(ODAdminUser.closeBtn);
				waitForLoad();
			}
			boolean shopPurchaseDetailsValidated = AdminFlows.validateShopPurchaseDetails(getData("loc1"),
					getData("manager"), getData("productType1"));
			Assert.assertTrue(shopPurchaseDetailsValidated, "Shop purchase order details validated");
		} 
		else 
		{
			Assert.assertTrue(false, "Order Details not Validated");
		}
    }
	
	@Step ("Validate the order details for ODE purchases")
    public static boolean validateOrderDetailsForODE(String location, String noOfGuests,  String meetingDate, String meetingTime,String conferenceRoom, String email) throws InterruptedException
    {
		boolean detailsValidated = false;

		String totalAmount = ODAdminUser.total.getText().split("???")[1];
		int totalAmountCalculated = Integer.parseInt(getData("creditsSize")) * 1000;
		int  finalAmount = WebFlows.priceValueInt(totalAmount);
		if(totalAmountCalculated==finalAmount)
		{
			String bookingDetailsinFrame = ODAdminUser.billingDetailsList.getText();
			String[] bookingDetails = bookingDetailsinFrame.split("\r?\n|\r");
			
			
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
		}
		return detailsValidated;
		
    }	
	
	
	@Step ("Select date in Calander UI")
    public static String selectDate(String month, String date) throws InterruptedException
    {
		String dateSelected= "";
    	while(!ODAdminUser.monthName.getText().contains(month))
		{
    		mouseHover(ODAdminUser.rightArrowBtn);
    		loadTime(1);
		}

		List<WebElement> dates = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day']"));
		int count = dates.size();
		for (int j = 0; j < count; j++)
		{
			String currentDate = dates.get(j).getText();
			if (currentDate.contains(date))
			{
					mouseHover(dates.get(j));
					loadTime(2);
					dateSelected = ODAdminUser.bookingDate.getAttribute("value");
					break;
			}
		}
		return dateSelected;
    }
	
	
	@Step ("Select time")
    public static void selectTime(String time) throws InterruptedException
    {
		
		List<WebElement> slotsList = driver.findElements(By.xpath("//li[contains(@class,'react-datepicker__time-list-item ')]"));
		for(int k=0;k<slotsList.size();k++)
		{
			if(!slotsList.get(k).getAttribute("class").contains("react-datepicker__time-list-item--disabled"))
			{
				if(slotsList.get(k).getText().equals(time))
				{
					slotsList.get(k).click();
					break;
				}
			}
		}
		
    }
	
	
	
	@Step("Select time slot")
	public static void selectSlot(String fromTime, String toTime) throws InterruptedException
	{
		mouseHover(ODAdminUser.total);
		click(ODAdminUser.selectSlotTime(1));
		AdminFlows.selectTime(fromTime);		
		click(ODAdminUser.selectSlotTime(2));
		AdminFlows.selectTime(toTime);
	}
	
	
	@Step("Select enterprise, product and building")
	public static void selectEnterpriseProductBuilding(String enterprise, String productType, String building) throws InterruptedException
	{
		click(ODAdminUser.selectEnterprise);
		updateText(ODAdminUser.selectEnterprise, enterprise);
		scrollToElement(ODAdminUser.select(enterprise));
		click(ODAdminUser.select(enterprise));
		click(ODAdminUser.selectproductType);
		updateText(ODAdminUser.selectproductType, productType);
		scrollToElement(ODAdminUser.select(productType));
		click(ODAdminUser.select(productType));
		Thread.sleep(4000);
//		loadTime(4);
//		waitForLoad();
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='MuiIconButton-label'])[2]")));
		Verifications.elementIsVisible(ODAdminUser.buildingDrpdwn);
		click(ODAdminUser.buildingDrpdwn);
		updateText(ODAdminUser.selectBuilding, building);
		scrollToElement(ODAdminUser.select(building));
		click(ODAdminUser.select(building));
		click(ODAdminUser.bookingDate);
		
	}
	
	@Step("Select conference room size and credits")
	public static void selectRoomSizeAndCredits(String conferenceRoomSize, String creditsSize,String email) throws InterruptedException
	{	
		AdminFlows.increaseConferenceRoomSize(Integer.parseInt(conferenceRoomSize));
		AdminFlows.increaseCredits(Integer.parseInt(creditsSize));
		updateText(ODAdminUser.conferenceRoom, "Test");
		updateText(ODAdminUser.customerEmail, email);	
	}
	
	@Step("Select Shop type")
	public static void selectShopType(String optService) throws InterruptedException
	{
		click(ODAdminUser.shopTab);
		List<WebElement> shopList = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-3']"));
		for (int i = 0; i < shopList.size(); i++)
		{
			String itemInList = shopList.get(i).getText();
			if (itemInList.contains(optService)) 
			{
					int j = 0;
					j = i + 1;
					driver.findElement(By.xpath("(//div[@class='ray-card__content']//a[1])["+j+"]")).click();
					break;
			}
		}	
		
	}
	
	@Step ("Convert String value of month")
    public static String trimMonth(String monthName)
    {
			String date = monthName.split(" ")[0];
			String input = monthName.split(" ")[1];
    	    String year = monthName.split(" ")[2];
    	    String finalMonthName = "";
    	    String firstThreeChars = "" ;
    	    if (input.length() > 3 )
    	    {
    	    firstThreeChars = input.substring( 0 , 3 );
    	    }
    	    else
    	    {
    	    firstThreeChars = input;
    	    }
    	    finalMonthName = date +" "+ firstThreeChars+" " + year;
    	    return finalMonthName;
    }
	
	@Step ("Convert meeting time")
    public static String meetingTime(String startTime, String endTime)
    {	
		startTime = startTime.toLowerCase();
		int len1 = startTime.length();
		StringBuffer stringBuffer = new StringBuffer(startTime);
		stringBuffer.insert(len1 - 1, ".");
		stringBuffer.insert(len1 + 1, ".");
		String newStartTime = stringBuffer.toString();

		endTime = endTime.toLowerCase();
		int len2 = endTime.length();
		StringBuffer stringBuffer2 = new StringBuffer(endTime);
		stringBuffer2.insert(len2 - 1, ".");
		stringBuffer2.insert(len2 + 1, ".");
		String newEndTime = stringBuffer2.toString();
		
		return newStartTime + "-" + newEndTime;
    }
	
	@Step("Increase ConferenceRoom Size")
	public static void increaseConferenceRoomSize(int size)
	{
		for(int i=0; i<size-2; i++)
		{
			click(ODAdminUser.plusBtnToincreaseRoomSize);
		}
	}
	
	@Step("Increase credits")
	public static void increaseCredits(int size)
	{
		for(int i=0; i<size-1; i++)
		{
			click(ODAdminUser.plusBtnToincreaseCredits);
		}
	}
	
	@Step ("Select shop - Parking")
    public static void selectShopForParking(String location, String option, String count, String email, String GSTN) throws InterruptedException
    {					
			
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
			click(ODAdminUser.bookingDate);
			String dateSelected  = AdminFlows.selectDate(getData("month3"),getData("date1"));
			String monthName = AdminFlows.trimMonth(dateSelected);
			updateText(ODAdminUser.customerGSTN,GSTN);
			Thread.sleep(4000);
			
			boolean orderDetailsValidated = AdminFlows.validateOrderDetailsForParking("Car", count, location, monthName, email, GSTN);
			if(orderDetailsValidated == true)
			{
				click(ODAdminUser.placeOrderBtn);
				Verifications.elementIsVisible(ODAdminUser.closeBtn);
				if(ODAdminUser.closeBtn.isDisplayed())
				{
					click(ODAdminUser.closeBtn);
					waitForLoad();
				}
				boolean shopPurchaseDetailsValidated = AdminFlows.validateShopPurchaseDetails(location,email,"Parking");
				Assert.assertTrue(shopPurchaseDetailsValidated, "Shop purchase order details validated");
			}
			else
			{
				Assert.assertTrue(false, "Order Details not Validated");
			}
			
    }
	
	@Step ("Validate the order details - Parking")
    public static boolean validateOrderDetailsForParking(String shopType, String count, String location, String monthName, String userEmail, String GSTN )
    {
		boolean detailsValidated = false;
		String printingPrice = ODAdminUser.getPrice(shopType).getText();
		String price = 	printingPrice.split("???")[1];
		int priceInInt = AdminFlows.priceValueInt(price);
		int totalAmount = Integer.parseInt(ODAdminUser.total.getText().split("???")[1]);
		String bookingDetailsinFrame = ODAdminUser.billingDetailsList.getText();
		String[] bookingDetails = bookingDetailsinFrame.split("\r?\n|\r");
		int finalPrice = priceInInt*Integer.parseInt(count);
		int k=5;
		if(bookingDetails[k].equalsIgnoreCase(location))
		{
			if(bookingDetails[k+1].equals(count))
			{
				if(bookingDetails[k+2].equalsIgnoreCase(monthName))
				{
					if(bookingDetails[k+3].equals(userEmail))
					{
						if(bookingDetails[k+4].equals(GSTN))
						{
							if(totalAmount==finalPrice)
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
	
	@Step ("Validate the shop purchase details")
    public static boolean validateShopPurchaseDetails(String location, String email, String productType) throws InterruptedException
    {
		
		driver.navigate().refresh();
		waitForLoad();
		loadTime(2);
		Thread.sleep(3000);
		driver.navigate().refresh();
		waitForLoad();
		Verifications.elementIsVisible(ODAdminUser.viewDetailsButton);
		click(ODAdminUser.viewDetailsButton);
		boolean orderDetailsValidated = false;
	
		if(ODAdminUser.buildingNameInDetails.getText().equalsIgnoreCase(location))
		{
			if(ODAdminUser.customerEmailInDetails.getText().equalsIgnoreCase(email))
			{
				if(ODAdminUser.productNameInDetails.getText().split(" ")[0].trim().contains(productType.split(" ")[0].trim()))
				{
					orderDetailsValidated = true;
					click(ODAdminUser.closeShopPurchase);
				}
				else
				{
					orderDetailsValidated = false;
					Assert.assertTrue(orderDetailsValidated, "Wrong product selected");
				}	
			}
			else
			{
				orderDetailsValidated = false;
				Assert.assertTrue(orderDetailsValidated, "Wrong email selected");
			}
		}
		else
		{
			orderDetailsValidated = false;
			Assert.assertTrue(orderDetailsValidated, "Wrong building selected");
		}
		return orderDetailsValidated;	
    }
	
	@Step ("Switch shopType")
    public static void selectShop(String shoptype) throws InterruptedException
    {   
	    switch(shoptype)  
	    {  
	        case "Printing": 
	        	AdminFlows.selectShopType("Printing");		
	    		AdminFlows.selectShopForPrinting(getData("loc1"),"Color",getData("count"), getData("userEmail"), getData("GSTN"));
	    		Assert.assertTrue(true, "Printing selected");
	    		break;  
	            
	        case "Postpaid Events":   
	        	AdminFlows.selectShopType("Postpaid Events");
	    		AdminFlows.selectShopForPostPaid("Postpaid Events" ,getData("eventType"), getData("loc1"), getData("price"),  getData("userEmail"),getData("name"), getData("GSTN"));
	    		Assert.assertTrue(true, "Postpaid Events selected");
	    		break; 
	            
	        case "ODE purchases":   
	        	AdminFlows.selectShopType("ODE purchases");
	    		AdminFlows.selectShopForODEPurchases();
	    		Assert.assertTrue(true, "ODE purchases selected");
	            break;
	            
	        case "Parking": 
	        	AdminFlows.selectShopType("Parking");
	        	AdminFlows.selectShopForParking(getData("loc1"),"Car",getData("count"), getData("userEmail"), getData("GSTN"));
	    		Assert.assertTrue(true, "Parking selected");
	            break;    
	            
	    }
    }
	
}
