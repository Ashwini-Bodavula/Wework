package workflows;

import static extensions.UIActions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugins.annotations.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebFlows extends CommonOps
{
	 @Parameters({"URL"})
  @Step("Launch browser for main website")
    public static void loadWebsite(String URL){
      //  UIActions.Browser("chrome","CO");
        CommonOps.URL(URL);
    }

  
//    @Step("Launch browser for OD website")
//    public static void loadODWebsite(String URL){
//     
//    	CommonOps.URL(URL);
//
//    }
	 
    @Step("Login to the application")
    public static void loginToApplication() throws InterruptedException
    {
    	//WebFlows.loadWebsite();
    	String currentWindow = getWindowHandel();
        Verifications.elementIsVisible(WebLogin.weWorkLoginButton);
        click(WebLogin.weWorkLoginButton);
        switchToLoginWindow(currentWindow);
        updateText(WebLogin.emailTestField, getData("Username"));
        updateText(WebLogin.passwordTestField, getData("Password"));
        click(WebLogin.submitButton);
        System.out.println("logged in successfully");
        switchToParentWindow(currentWindow);
        waitForLoad();
     //   Verifications.verifyTextInElement(WebLogin.userName, getData("user"));
    }

    @Step("Logout of the application")
    public static void logoutOfApplication() throws InterruptedException
    {
    	scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
	    Verifications.elementIsVisible(WebLoading.logout);
	    click(WebLoading.logout);
    }

   
    @Step("Login to the OD application")
    public static void ODLogin() throws InterruptedException{
       // WebFlows.loadODWebsite(String URL);
        String currentWindow = getWindowHandel();
        click(WebODLogin.Hamberger);
        Verifications.elementIsVisible(WebODLogin.ODLoginButton);
        click(WebODLogin.ODLoginButton);
        switchToLoginWindow(currentWindow);
        updateText(WebODLogin.emailTestField, getData("Username"));
        updateText(WebODLogin.passwordTestField, getData("Password"));
        click(WebODLogin.submitButton);
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(WebODLogin.login_msg);
        String Messg=WebODLogin.login_msg.getText();
        System.out.println(Messg);
        click(WebODLogin.msg_close);
    }

    @Step(" OD Logout")
    public static void ODlogout() throws InterruptedException{
    	  click(WebODLogin.Hamberger);
    	  click(WebODLogin.logout);
    }
    
    @Step("Login to the OD application")
    public static void ODELogin() throws InterruptedException{
       // WebFlows.loadODWebsite(String URL);
        String currentWindow = getWindowHandel();
        click(WebODLogin.Hamberger);
        Verifications.elementIsVisible(WebODLogin.ODLoginButton);
        click(WebODLogin.ODLoginButton);
        switchToLoginWindow(currentWindow);
        updateText(WebODLogin.emailTestField, getData("Username"));
        updateText(WebODLogin.passwordTestField, getData("Password"));
        click(WebODLogin.submitButton);
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(WebODLogin.login_msg);
        String Messg=WebODLogin.login_msg.getText();
        System.out.println(Messg);
        click(WebODLogin.msg_close);
    }

    @Step(" OD Logout")
    public static void ODElogout() throws InterruptedException{
    	  click(WebODLogin.Hamberger);
    	  click(WebODLogin.logout);

    }
    
    @Step("Select workspace")
    public static void selectWorkspace(String city , String location, String buildingName) throws InterruptedException
    {
    	scrollToElement(WebLoading.workspaceBtn);
    	boolean value1 = WebLoading.exploreBtn.isEnabled();
		if(!value1)
		{
			Verifications.elementIsVisible(WebLoading.cityDropdown);
			String beforeCitySelection = WebLoading.cityDropdown.getText();
			if(beforeCitySelection.equals("Select a city"))
			{
				click(WebLoading.cityDropdown);
				click(WebLoading.selectCity(city));
				String afterCitySelection = WebLoading.cityDropdown.getText();
				if(afterCitySelection.equals(city))
				{
					Assert.assertTrue(true, "City selected");
				}

			}
			String beforeBuildingSelection = WebLoading.buildingsDropdown.getText();
			if(beforeBuildingSelection.equals("Building"))
			{
				click(WebLoading.buildingsDropdown);
				if(location.contains("BKC"))
				{
					scrollToElement(WebLoading.selectLocation(location));
				}
				click(WebLoading.selectLocation(location));
				if(buildingName.contains("Enam Sambhav"))
				{
					scrollToElement(WebLoading.selectBuilding(buildingName));
				}
				click(WebLoading.selectBuilding(buildingName));

				String afterBuildingSelection = WebLoading.buildingsDropdown.getText();
				if(afterBuildingSelection.equals(buildingName))
				{
					if(buildingName.contains("Enam Sambhav"))
					{
						scrollToElement(WebLoading.exploreBtn);
					}
					boolean value = WebLoading.exploreBtn.isEnabled();
					if(value)
					{
						click(WebLoading.exploreBtn);
					}
				}
			}
		}
    }

    @Step("Select Enterprise in guided selling")
    public static void selectLocationForEnterprise(String city , String location, String noOfPpl) throws InterruptedException
    {
    	scrollToElement(Enterprise.enterpriseBtn);
    	boolean value1 = WebLoading.exploreBtn.isEnabled();
		if(!value1)
		{
			click(Enterprise.enterpriseBtn);
	    	click(Enterprise.selectDropdown(1));
	        loadTime(1);
	    	click(Enterprise.selectCity(city));
	    	click(Enterprise.selectLocation(location));
	    	click(Enterprise.selectDropdown(2));
	    	click(Enterprise.selectNoOfPeople(noOfPpl));
	    	boolean value2 = WebLoading.exploreBtn.isEnabled();
			if(value2)
			{
				click(Enterprise.exploreSolnBtn);
			}
		}
    }

    @Step("Select building and plan for virtual office")
    public static void selectBuildingAndPlan( String buildingName, String plan) throws InterruptedException
    {
		click(WebLoading.select("Select Building"));
		Verifications.elementIsVisible(WebLoading.select(buildingName));
		scrollToElement(WebLoading.select(buildingName));
		click(WebLoading.select(buildingName));
		mouseHover(VirtualOffice.nextBtn);
		Verifications.elementIsVisible(WebLoading.select(plan));
        if(VirtualOffice.checkoutBtn.isEnabled())
        {
        		click(WebLoading.select("Checkout"));
        }
        else
        {
        	click(WebLoading.select(plan));
        	mouseHover(VirtualOffice.checkoutBtn);
        }
    }

    @Step("Proceed with Payment")
	    public static void proceedWithPayment() throws InterruptedException
	    {

	    	Verifications.elementIsVisible(Payment.checkoutEmail);
	        click(Payment.checkoutEmail);
	        clearTextBox(Payment.checkoutEmail);
	        updateText(Payment.checkoutEmail, getData("email"));
	        click(Payment.emailMeCheckbox);
	        updateDropDown(Payment.countryDropdown, "India");
	        clearTextBox(Payment.firstName);
	        updateText(Payment.firstName, getData("name"));
	        clearTextBox(Payment.lastName);
	        updateText(Payment.lastName, getData("lastName"));
	        clearTextBox(Payment.companyName);
	        updateText(Payment.companyName, getData("companyName"));
	        clearTextBox(Payment.address);
	        updateText(Payment.address, getData("address"));
	        clearTextBox(Payment.landmark);
	        updateText(Payment.landmark, getData("landMark"));
	        clearTextBox(Payment.city);
	        updateText(Payment.city, getData("city"));
	        updateDropDown(Payment.state, "Karnataka");
	        clearTextBox(Payment.PINcode);
	        updateText(Payment.PINcode, getData("pincode"));
	        clearTextBox(Payment.phoneNumber);
	        updateText(Payment.phoneNumber, getData("phoneNumber"));
	//        click(Payment.saveInfoCheckbox);
	//        updateText(Payment.coupon, getData("couponCode"));
	//        click(Payment.applyBtn);
	//        String actualText = Payment.couponValidationMsg.getText();
	//        Verifications.verifyText(actualText,"Enter a valid discount code or gift card");
	//        clearTextBox(Payment.coupon);
	//        loadTime(4);
	        scrollToElement(Payment.continuePayment);
	        mouseHover(Payment.continuePayment);
	        scrollToElement(Payment.completeOrder);
	        mouseHover(Payment.completeOrder);

	    }

	@Step("Select Payment for virtual office")
    public static void VirtualOfficeWorkspacePayment(String locNameInPaymentPage) throws InterruptedException
    {
		String locationInHeader = VirtualOffice.verifyLocation(locNameInPaymentPage).getText();
		if (locationInHeader.contains(locNameInPaymentPage))
		{
			Verifications.elementIsVisible(WebLoading.select("Proceed to Payment"));
			scrollToElement(WebLoading.select("Proceed to Payment"));
			click(WebLoading.select("Proceed to Payment"));
		}
		String PaymentWindow = getWindowHandels2();
		switchToParentWindow(PaymentWindow);

		String pageTitle = UIActions.getPageTitle();
		String PaymentPageTitle = "Payment - WeWork India Management Private Limited - Checkout";
		if (pageTitle.contains(PaymentPageTitle))
		{
			click(Payment.changeBtn1);
		}
		WebFlows.proceedWithPayment();
		loadTime(2);

    }

 @Step("Fill the form going from header")
	    public static void header_fillTheFormDetails() throws InterruptedException
	    {
	    	updateText(WebLoading.enter("Full name"), getData("Username"));
			updateText(WebLoading.enter("Email"), getData("email"));
			updateText(WebLoading.phnNumber, getData("phoneNumber"));
			scrollToElement(WebLoading.adding("header"));
			selectNoOfPeople(4,"header");
//			selectDate(getData("year"), getData("month3"), getData("date1"));
			scrollToElement(WebLoading.dateField);
			WebFlows.enterDate(getData("date1"),getData("month"),getData("year"));
//			Verifications.elementIsVisible(WebLoading.continueBtn);
//			click(WebLoading.continueBtn);
//			Verifications.elementIsVisible(WebLoading.thankyouText);
//			String actualText = WebLoading.thankyouText.getText();
//			Verifications.elementIsVisible(WebLoading.thankyouText);
//			Verifications.verifyText(actualText, "Thank you for contacting WeWork");
//			click(WebLoading.backToHomePageBtn);
			mouseHover(WebLoading.closeIcon); //as the form is not submited and msg is not validated, clicking on close icon

			
	    }
	 
	 @Step("Fill the form")
	    public static void fillTheFormDetails() throws InterruptedException
	    {
	    	updateText(WebLoading.enter("Full name"), getData("Username"));
			updateText(WebLoading.enter("Email"), getData("email"));
			updateText(WebLoading.enter("Phone number"), getData("phoneNumber"));
			scrollToElement(WebLoading.adding(""));
			selectNoOfPeople(4,"");
//			selectDate(getData("year"), getData("month3"), getData("date1"));
			scrollToElement(WebLoading.dateField);
			WebFlows.enterDate(getData("date1"),getData("month"),getData("year"));
//			Verifications.elementIsVisible(WebLoading.continueBtn);
//			click(WebLoading.continueBtn);
//			Verifications.elementIsVisible(WebLoading.thankyouText);
//			String actualText = WebLoading.thankyouText.getText();
//			Verifications.elementIsVisible(WebLoading.thankyouText);
//			Verifications.verifyText(actualText, "Thank you for contacting WeWork");
//			click(WebLoading.backToHomePageBtn);
			mouseHover(WebLoading.closeIcon); //as the form is not submited and msg is not validated, clicking on close icon

			
	    }

	 

    @Step("Fill the Enterprise form")
    public static void fillEnterpriseFormDetails() throws InterruptedException
    {
		click(Enterprise.getInTouchBtnForSoln);
		updateText(Enterprise.enter("Full Name"), getData("Username"));
		updateText(Enterprise.enter("Work Email"), getData("email"));
		updateText(Enterprise.enter("Phone Number"), getData("phoneNumber"));
		scrollToElement(Enterprise.companySizeDrpdwn);
		click(Enterprise.companySizeDrpdwn);
		click(Enterprise.selectCompanySize("100+"));
		loadTime(1);
		scrollToElement(Enterprise.selectRadioButton("No"));
		mouseHover(Enterprise.selectRadioButton("No"));
//    	click(Enterprise.getInTouchButtonForSumbtn);
//    	loadTime(1);
//    	Verifications.elementIsVisible(WebLoading.FormSubbmittedMsg);
//      String actualText = WebLoading.FormSubbmittedMsg.getText();
//      Verifications.verifyText(actualText,"Form Submitted Successfully");

    }



    @Step ("Select date in Calander UI")
	public static void selectDate(String year, String month, String date) throws InterruptedException
	{

    	scrollToElement(WebLoading.calendarIcon);
    	click(WebLoading.calendarIcon);

		click(WebLoading.calendarIcon);
		loadTime(2);
		mouseHover(WebLoading.yearDropdown);
		loadTime(1);
		int yearINT = Integer.parseInt(year);

		if(yearINT < 2022)
			Assert.assertTrue(false, "Invalid year selection");

		List<WebElement> yearsList = driver.findElements(
				By.xpath("//div[@class='PrivatePickersYear-root PrivatePickersYear-modeDesktop css-j9zntq']//button"));
		loadTime(1);
		for (WebElement selectedYear : yearsList) {
			String currentyear = selectedYear.getText();
			if (currentyear.equals(year))
			{
				if (selectedYear.isEnabled())
				{
					loadTime(1);
					mouseHover(selectedYear);
					break;
				}
			}
		}
		while (!WebLoading.monthName.getText().equals(month))
		{
			click(WebLoading.rightArrowBtn);
		}

		List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'dayWithMargin')]"));
		int count = dates.size();
		for (int j = 0; j < count; j++)
		{
			String currentDate = dates.get(j).getText();
			if (currentDate.equals(date))
			{

				String attributeValue = dates.get(j).getAttribute("class");
				if(attributeValue.contains("Mui-disabled"))
				{
					System.out.println("Please select valid date");
					break;
				}
				else
				{
					click(dates.get(j));
					loadTime(2);
					break;
				}

			}
		}

	}

	@Step ("Select date in Calander UI for Daypass")
    public static void selectDate(String month, String date) throws InterruptedException
    {
    	while (!WebLoading.monthName.getText().contains(month))
		{
    		click(WebLoading.rightArrowBtn);
			//WebLoading.rightArrowBtn.click();
    		loadTime(1);
		}

		List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'dayWithMargin')]"));
		int count = dates.size();
		for (int j = 0; j < count; j++)
		{
			String currentDate = dates.get(j).getText();
			if (currentDate.contains(date))
			{
				String attributeValue = dates.get(j).getAttribute("class");
				if(attributeValue.contains("Mui-disabled"))
				{
					System.out.println("Please select weeekdays");
					break;
				}
				else
				{
					click(dates.get(j));
					loadTime(2);
					break;
				}

			}
		}
    }


    @Step ("Select Number of hours for conference room")
	   public static void verifyDate(String year, String month, String date) throws InterruptedException
	   {
		   String dateTextBox = ConferenceRoom.dateTextBox.getAttribute("value");
		   //System.out.println(dateTextBox);
		   if(dateTextBox.contains(month) && dateTextBox.contains(date))
		   {
			   Assert.assertTrue(true, "Date selected");
		   }
	   }

	@Step ("Select number of people")
    public static void selectNoOfPeople(int count, String form)
    {
    	if(count == 1)
    	{
    		return;
    	}
    	else{
    		
    	for(int i=0;i<count;i++)
    	{
    		click(WebLoading.adding(form));
    	}
    	}
//       else
//    	   for(int i=0;i<count;i++)
//       	{
//       		click(WebLoading.plusIcon);
//       	}   

    }

    @Step ("Select Number of hours for conference room")
	   public static void selectNumberOfHours(int hours) throws InterruptedException
	   {
	   	    for(int i=1;i<hours;i++)
	   	    {
	   	    	click(ConferenceRoom.increaseHours);
	   	    }
	   	    loadTime(2);

	    	String hoursText = ConferenceRoom.hoursText.getText();
	    	int hoursInt = Integer.parseInt(hoursText);
	    	if(hours==hoursInt)
	    	{
	    		Assert.assertTrue(true, hours+" hours selected");

	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, hours +" hours not selected");

	    	}

	   }

	@Step ("Select slots")
	   public static void selectSlots(String time) throws InterruptedException
		{
			List<WebElement> slotsList = driver
					.findElements(By.xpath("//div[contains(@class,'startTimesWrapper')] //div //span"));

			for (WebElement element : slotsList) {
				if (element.getCssValue("Color").contains("0.87")) {
					if (element.getText().equals(time)) {
						element.click();
						loadTime(1);
						break;
					}
				}
			}
		}

	@Step ("Select seater size [4 seater, 6 seater , 12 seater]")
	   public static void selectSeater(String seatSize) throws InterruptedException
		{
			List<WebElement> seatersList = driver.findElements(By.xpath("//div[@class='roomCapacityContent'] "));
			for (WebElement element : seatersList) {
				if (element.getText().contains(seatSize))
				{
					element.click();
					loadTime(1);
					break;
				}
			}
		}

	@Step("Validate the date time and slot selection")
	   public static boolean validateSlotSelection(int hours, String year, String month, String date, String seaterSize, String slot) throws InterruptedException
	   {
		    ArrayList<String> containerValues = new ArrayList<>();
			WebElement container = driver.findElement(By.xpath("//div[contains(@class,'conferenceItemContainer')]"));
			String[] value = container.getText().split("\n");
			for (String element : value) {
				containerValues.add(element);
			}
			boolean validationPassed = false;
		   		int k=1;
				if(containerValues.get(k).contains(year) && containerValues.get(k).contains(month(month)) && containerValues.get(k).contains(date))
				{
						if(containerValues.get(k+1).equals(seaterSize))
						{
							if(containerValues.get(k+2).contains(slot))
							{
								String[] timeSlots = containerValues.get(k+2).split("-");
								String startTime = timeSlots[0].trim().split(" ")[0].split(":")[0];
								String stopTime = timeSlots[1].trim().split(" ")[0].split(":")[0];
						    	int intStartTime = Integer.parseInt(startTime);
						    	int intStopTime = Integer.parseInt(stopTime);
								int newStartTime,newStopTime=0;
								if(intStartTime<9)
								{
									newStartTime = 24-12 + intStartTime;
								}else{
									newStartTime= intStartTime;
								}
								if(intStopTime<9)
								{
									 newStopTime = 24 - 12 +intStopTime;

								}else{
									newStopTime= intStopTime;
								}
								int difference = newStopTime- newStartTime;
								if(difference== hours)
								{
									validationPassed = true;
								}
							}
						}

				}
			return validationPassed;
	   }

	@Step ("Convert String value of price to integer")
    public static int priceValueInt(String price)
    {
    	String priceValueInString = "";
		for(int i=0;i<price.length();i++)
		{
				char ch = price.charAt(i);
				if(ch!=',')
				{
					priceValueInString = priceValueInString+ch;
				}

		}
		int priceValueinInt = Integer.parseInt(priceValueInString);
		return priceValueinInt;
    }



    @Step ("Select date and slots for conference room ")
	   public static boolean selectConferenceRoomDateAndSlots(int hours, String year, String month, String date, String seaterSize, String slot) throws InterruptedException
	   {
		    WebFlows.selectNumberOfHours(hours);
			WebFlows.selectDate(year,month,date);
			WebFlows.verifyDate(year,month,date);
			UIActions.scrollPage(ConferenceRoom.slotsWindow, 10000);
			WebFlows.selectSeater(seaterSize);
			WebFlows.selectSlots(slot);
			boolean addButtonEnabled = false;
			scrollToElement(ConferenceRoom.addBtn);
			if(ConferenceRoom.addBtn.getCssValue("color").contains("1"))
			{
				 addButtonEnabled = true;
			}
			return addButtonEnabled;
	   }

	@Step ("Select date and slots for conference room ")
	   public static boolean selectConferenceRoomSlots(int hours, String seaterSize, String slot) throws InterruptedException
	   {
			WebFlows.selectNumberOfHours(hours);
			UIActions.scrollPage(ConferenceRoom.slotsWindow, 10000);
			WebFlows.selectSeater(seaterSize);
			WebFlows.selectSlots(slot);
			boolean addButtonEnabled = false;
			scrollToElement(ConferenceRoom.addBtn);
			if (ConferenceRoom.addBtn.getCssValue("color").contains("1"))
			{
				addButtonEnabled = true;
			}
			return addButtonEnabled;
		}

	@Step ("Convert String value of price to integer")
    public static String month(String monthName)
    {
    	    String input = monthName;
    	    String firstThreeChars = "" ;
    	    if (input.length() > 3 )
    	    {
    	    firstThreeChars = input.substring( 0 , 3 );
    	    }
    	    else
    	    {
    	    firstThreeChars = input;
    	    }
    	   return firstThreeChars;
    }

   @Step("Add team members for day pass")
	   public static void addTeamMemberForDayPass(String name, String emailId) throws InterruptedException
	   {
		    click(DayPass.addMemberBtn);
			updateText(DayPass.memberName, name);
			updateText(DayPass.memberEmail, emailId);
			click(DayPass.saveBtn);
			loadTime(3);
	   }

@Step("Verify the price breakup after selecting day passes")
   public static boolean verifyPriceBreakupForDayPass() throws InterruptedException
   {
	boolean priceBreakupVerified = false;
	String confirmAndPayBtnAmount = DayPass.confirmAndPayBtn.getText().split("₹")[1].trim();
	System.out.println(confirmAndPayBtnAmount);
	int amountInConfirmAndPayBtn = WebFlows.priceValueInt(confirmAndPayBtnAmount);
	System.out.println(amountInConfirmAndPayBtn);
	int finalPrice = 0;
	int finalAmount = 0;
	
	boolean userNamePresent = false;
	String[] value = DayPass.priceBreakupContainer.getText().split("\n");
	String[] numArray = { WebFlows.month(getData("month3")), getData("date3") };

	for (int j = 0; j < numArray.length - 1; j++) 
	{
		if (value[2].contains(numArray[j]) && value[2].contains(numArray[j+1])) 
		{
			String price = value[4].split("₹")[1].trim();
			int amount = WebFlows.priceValueInt(price);
			finalPrice = finalPrice + amount;
			break;
		}
	}
	if (value[3].contains(getData("user"))) {
		userNamePresent = true;
		Assert.assertTrue(userNamePresent, "Selected DayPass for " + getData("user"));
	}
	String totalrice = DayPass.totalPrice.getText().split("₹")[1].trim();
	finalAmount = WebFlows.priceValueInt(totalrice);
	loadTime(3);
	
	if (amountInConfirmAndPayBtn == finalAmount && finalAmount == finalPrice) 
	{
		priceBreakupVerified = true;	
	}
	return priceBreakupVerified;
		

   }

   @Step("Verify the price breakup for team member after selecting day passes")
   public static boolean verifyPriceBreakupforTeamMember() throws InterruptedException
   {
	   boolean priceBreakupVerified = false;
		String confirmAndPayBtnAmount = DayPass.confirmAndPayBtn.getText().split("₹")[1].trim();
		int amountInConfirmAndPayBtn = WebFlows.priceValueInt(confirmAndPayBtnAmount);	
		int finalPrice = 0;
		int finalAmount = 0;
		boolean userNamePresent = false;
		boolean teamMemberPresent = false;
		String[] value = DayPass.priceBreakupContainer.getText().split("\n");
		String[] numArray = { WebFlows.month(getData("month3")), getData("date3") };

		for (int j = 0; j < numArray.length - 1; j++) 
		{
			if (value[2].contains(numArray[j]) && value[2].contains(numArray[j+1])) 
			{
				String price = value[4].split("₹")[1].trim();
				int amount = WebFlows.priceValueInt(price);
				finalPrice = finalPrice + amount;
				break;
			}
		}
		if (value[3].contains(getData("user"))) {
			userNamePresent = true;
			Assert.assertTrue(userNamePresent, "Selected DayPass for " + getData("user"));
		}
		else {
			Assert.assertTrue(false, "DayPass not selected for " + getData("user"));
		}	
		if (value[5].contains(getData("teamMember1"))) {
			teamMemberPresent = true;
			Assert.assertTrue(teamMemberPresent, "Selected DayPass for " + getData("teamMember1"));
		}
		else
		{
			Assert.assertTrue(false, "DayPass not selected for " + getData("teamMember1"));
		}
		
		String amount1 = value[4].split("₹")[1].trim();
		int user1Amount = WebFlows.priceValueInt(amount1);
		String amount2 = value[6].split("₹")[1].trim();
		int user2Amount = WebFlows.priceValueInt(amount2);
		int totalPrice = user1Amount + user2Amount;
		String totalrice = DayPass.totalPrice.getText().split("₹")[1].trim();
		finalAmount = WebFlows.priceValueInt(totalrice);
		loadTime(3);
		
		if (amountInConfirmAndPayBtn == finalAmount && finalAmount ==totalPrice) 
		{
			priceBreakupVerified = true;	
		}
		return priceBreakupVerified;
	   
   }


   @Step("Verify the price breakup for team member after selecting day passes")
   public static boolean verifyPriceBreakupforDayPassAndConferenceRoom(int hours, String year, String month, String date, String seaterSize, String slot) throws InterruptedException
   {
		int finalPrice = 0;
		int DayPassPrice = 0;
		boolean priceBreakupValidationPassed = false;
		boolean validationPassed = false;
		ArrayList<String> containerValues = new ArrayList<>();
		String[] value = DayPass.priceBreakupContainer.getText().split("\n");
		for (String element : value) {
			containerValues.add(element);
		}

		int k = 1;
		if (containerValues.get(k).equals("Day Passes")) {

			if (containerValues.get(k + 1).contains(month(month)) && containerValues.get(k + 1).contains(date)) {
				if (containerValues.get(k + 2).contains(getData("user"))) {
					String price = containerValues.get(k + 3).split("₹")[1].trim();
					int amount1 = WebFlows.priceValueInt(price);
					DayPassPrice = DayPassPrice + amount1;
				}

				if (containerValues.get(k + 4).contains(getData("teamMember2"))) {
					String price = containerValues.get(k + 5).split("₹")[1].trim();
					int amount2 = WebFlows.priceValueInt(price);
					DayPassPrice = DayPassPrice + amount2;
				}

				if (containerValues.get(k + 6).equals("Conference Room Sessions")) {
					if (containerValues.get(k + 7).contains(month(month))
							&& containerValues.get(k + 7).contains(date)) {
						if (containerValues.get(k + 8).contains(slot)) {
							String[] timeSlots = containerValues.get(k + 8).split("-");
							String startTime = timeSlots[0].trim().split(" ")[0].split(":")[0];
							String stopTime = timeSlots[1].trim().split(" ")[0].split(":")[0];

							int intStartTime = Integer.parseInt(startTime);
							int intStopTime = Integer.parseInt(stopTime);
							int newStartTime, newStopTime = 0;
							if (intStartTime < 9) {
								newStartTime = 24 - 12 + intStartTime;
							} else {
								newStartTime = intStartTime;
							}
							if (intStopTime < 9) {
								newStopTime = 24 - 12 + intStopTime;

							} else {
								newStopTime = intStopTime;
							}
							int difference = newStopTime - newStartTime;

							if (difference == hours) {
								if (containerValues.get(k + 9).equals(seaterSize)) {
									validationPassed = true;

								}
							}
						}
						String ConferenceRoomAmount = containerValues.get(k + 10).split("₹")[1].trim();

						int ConferenceRoomPrice = WebFlows.priceValueInt(ConferenceRoomAmount);
						finalPrice = DayPassPrice + ConferenceRoomPrice;
					}
				}
				String totalAmount = containerValues.get(k + 11).split("₹")[1].trim();
				int totalPrice = WebFlows.priceValueInt(totalAmount);
				if (finalPrice == totalPrice && validationPassed) {
					priceBreakupValidationPassed = true;
				}
			}
		}
		return priceBreakupValidationPassed;

   }

@Step("Verify the price breakup after selecting day passes")
   public static boolean verifyPriceBreakupforConferenceRoom(int hours, String year, String month, String date, String seaterSize, String slot) throws InterruptedException
   {
	   String[] value = ConferenceRoom.priceBreakupContainer.getText().split("\n");
       boolean validationPassed = false;
	   int k=2;
       if(value[k].contains(date) && value[k].contains(month(month)) && value[k].contains(year))
       {
    	  if(value[k+1].contains(slot))
    	  {
    		    String[] timeSlots = value[k+1].split("-");
				String startTime = timeSlots[0].trim().split(" ")[0].split(":")[0];
				String stopTime = timeSlots[1].trim().split(" ")[0].split(":")[0];
		    	int intStartTime = Integer.parseInt(startTime);
		    	int intStopTime = Integer.parseInt(stopTime);
				int newStartTime,newStopTime=0;
				if(intStartTime<9)
				{
					newStartTime = 24-12 + intStartTime;
				}else{
					newStartTime= intStartTime;
				}
				if(intStopTime<9)
				{
					 newStopTime = 24 - 12 +intStopTime;

				}else{
					newStopTime= intStopTime;
				}
				int difference = newStopTime- newStartTime;

				if (difference == hours)
				{
					if (value[k + 2].equals(seaterSize))
					{
						validationPassed = true;
					}
				}
    	  }
       }
       return validationPassed;
   }

	@Step("Select time")
	public static void selectTime(String hours, String minutes) throws InterruptedException 
	{
		click(Events.select("ClockIcon"));
		loadTime(3);
		//scrollToElement(Events.selectHour(hours));
		mouseHover(Events.selectHour(hours));
		loadTime(3);
		Verifications.elementIsVisible(Events.selectMinute(minutes));
		mouseHover(Events.selectMinute(minutes));
		loadTime(3);
	}
	
	@Step("Fill WBS Form")
	public static void fillWBSForm() throws InterruptedException 
	{
		click(WebLoading.workspaceDrpdwn);
		Verifications.elementIsVisible(WebLoading.WBS);
		mouseHover(WebLoading.WBS);
		loadTime(2);
		scrollToElement(Wbs.select("Full name"));
		Verifications.elementIsVisible(Wbs.select("Full name"));
		updateText(Wbs.select("Full name"), getData("name"));
		updateText(Wbs.select("Company name"), getData("companyName"));
		updateText(Wbs.select("Company email"), getData("companyEmail"));
		updateText(Wbs.select("Phone number"), getData("phoneNumber"));
		click(Wbs.locationDropdwon);
		click(Wbs.selectCity("Mumbai"));
		click(Wbs.selectService("Hardware rentals"));
		click(Wbs.selectService("Payroll processing"));
		click(Wbs.selectService(" Food & Beverage"));
		//click(wbs.getInTouch);
		
	}
	
	
	@Step("Fill getInTouch form")
	public static void fillGetInTouchForm() throws InterruptedException
	{
		click(WebLoading.contactUsBtn);
    	scrollToElement(GetInTouch.enter("First Name"));
    	Verifications.elementIsVisible(GetInTouch.enter("First Name"));
    	updateText(GetInTouch.enter("First Name"), getData("name"));
        updateText(GetInTouch.enter("Last Name"), getData("lastName"));
        updateText(GetInTouch.enter("Company Name"), getData("companyName"));
        updateText(GetInTouch.enter("Company E-mail address"), getData("companyEmail"));
        updateText(GetInTouch.enter("Phone number"), getData("phoneNumber"));
        click(GetInTouch.selectDropdown(1));
        click(GetInTouch.select("Pune"));
        click(GetInTouch.selectDropdown(2));
        click(GetInTouch.select("Kharadi"));
        click(GetInTouch.selectDropdown(3));
        click(GetInTouch.select("World Trade Center"));
        click(GetInTouch.selectDropdown(4));
        click(GetInTouch.select("Private Office"));
        WebFlows.selectNoOfDesks(3);
        //click(GetInTouch.getInTouchBtn);
	}
	
	@Step("Fill referral form")
	public static void fillReferralForm() throws InterruptedException
	{
		
		scrollToElement(WebLoading.referralsLink);
		click(WebLoading.referralsLink);
		loadTime(4);
		Thread.sleep(2000);
		scrollToElement(Referral.FAQ1);
		loadTime(4);
		Verifications.elementIsVisible(Referral.FAQ1);
		loadTime(4);
		click(Referral.FAQ1);
		scrollToElement(Referral.referralLinkInFAQ1);
		String referralLinkText = Referral.referralLinkInFAQ1.getText();
		String actualReferralLinkText = "https://wework.co.in/referrals";
		Assert.assertEquals(referralLinkText, actualReferralLinkText);
		scrollToElement(Referral.getStartedBtn);
		click(Referral.getStartedBtn);
		scrollToElement(Referral.select("Full Name"));
		updateText(Referral.select("Full Name"), getData("name"));
		updateText(Referral.select("Email"), getData("email"));
		updateText(Referral.select("Phone Number"), getData("phoneNumber"));
		updateText(Referral.select("Company Name"), getData("companyName"));
		click(Referral.preferredOfficeLocationDropdwon);
		click(Referral.selectLocation("Pune"));
		click(Referral.workspaceIntrestedInDrpdwn);
		click(Referral.selectWorkspace("All Access"));
		scrollToElement(Referral.increaseNoOfDesk);
		click(Referral.addReferralBtn);
		boolean errormessageDisplayed = Referral.errorMessage.isDisplayed();
		Assert.assertTrue(errormessageDisplayed);
		click(Referral.increaseNoOfDesk);
		click(Referral.increaseNoOfDesk);
		updateText(Referral.select("Referrer Name"), getData("name"));
		updateText(Referral.select("Referrer Email"), getData("email"));
		updateText(Referral.select("Referrer Phone"), getData("phoneNumber"));
//		click(referral.addReferralBtn);
	}
	
	@Step("Validate careers link")
	public static void validateCareersLink() throws InterruptedException
	{
		scrollToElement(WebLoading.CareersLink);
		click(WebLoading.CareersLink);
		loadTime(3);
		Thread.sleep(1000);
		waitForLoad();
		click(Careers.joinUsBtn);
		loadTime(4);
		boolean openingsBtnPresent = Careers.viewopeningsBtn.isDisplayed();
		Assert.assertTrue(openingsBtnPresent, "Button present");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://weworkindia.hire.trakstar.com/");
		driver.navigate().back();
		waitForLoad();
	}
	
	@Step("Validate careers link by clicking on contact us butoon")
	public static void selectCareersfromContactUsBtn() throws InterruptedException
	{ 
		click(WebLoading.contactUsBtn);
		scrollToElement(Careers.submitButton);
		String textInSubmitBtnBfrSelectingChkBox = Careers.submitButton.getText();
		Assert.assertEquals(textInSubmitBtnBfrSelectingChkBox, "Get in touch");
		boolean nameEnabled = Careers.firstName.isEnabled();
		Assert.assertTrue(nameEnabled);
		scrollToElement(Careers.jobOportunitiescheckBox);
		mouseHover(Careers.jobOportunitiescheckBox);
		waitForLoad();
		boolean nameDisabledled = Careers.firstName.isEnabled();
		Assert.assertFalse(nameDisabledled);
		scrollToElement(Careers.submitButton);
		String textInSubmitBtnAfrSelectingChkBox = Careers.submitButton.getText();
		Assert.assertEquals(textInSubmitBtnAfrSelectingChkBox, "Explore Now");
		click(Careers.submitButton);
		waitForLoad();
		Thread.sleep(1000);
		click(Careers.joinUsBtn);
		boolean openingsBtnPresent = Careers.viewopeningsBtn.isDisplayed();
		Assert.assertTrue(openingsBtnPresent, "Button present");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://weworkindia.hire.trakstar.com/");
		driver.navigate().back();
		waitForLoad();
	}
	
	@Step ("Select number of Desks")
    public static void selectNoOfDesks(int count)
    {
    	if(count == 1)
    	{
    		return;
    	}

    	for(int i=1;i<=count;i++)
    	{
    		click(GetInTouch.increaseNoOfDesk);
    	}

    }
	
	@Step("enter date")
	public static void enterDate(String date, String month, String year) throws InterruptedException
	{
		click(WebLoading.dateField);
		updateText(WebLoading.dateField, date+month+year );
		Thread.sleep(3000);
	}

	@Step("Select location and building for subscription")
	public static void selectLocationAndBuilding()
	{
		click(WebLoading.loctnDropdown2);
    	click(WebLoading.selectloc("Delhi-NCR"));
    	click(WebLoading.buildingDropdown);
    	click(WebLoading.select("Blue One Square"));
    	click(WebLoading.bookAWorkspaceBtn);
	}
	
	@Step("Select User")
	public static void selectUser(String username)
	{
		driver.findElement(By.xpath("//p[contains(text(),'"+username+"')]")).click();
	}
	
	@Step("Delete User")
	public static void deleteUser(String username)
	{
		driver.findElement(By.xpath("//p[contains(text(),'"+username+"')]/parent::div/following-sibling::div/div[2]")).click();
	}
	
	@Step("verify profile")
	public static void profile() throws InterruptedException
	{
		if(MyAcc.MyAccount.isDisplayed()) {
    	click(MyAcc.MyAccount);
        click(MyAcc.profile);
        Boolean email=MyAcc.Email.isEnabled();
        Assert.assertEquals(false, false);
        //String name = "test";
        clearTextBox(MyAcc.Name);
        updateText(MyAcc.Name, getData("Name"));
        clearTextBox(MyAcc.Phone);
        updateText(MyAcc.Phone, getData("Phone"));
        click(MyAcc.save);
  //    loadTime(3);
        String msg=MyAcc.save_msg.getText();
        Assert.assertEquals(msg,"Details Updated Successfully");
        String pname= MyAcc.Name.getAttribute("value");
        Assert.assertEquals(pname, "tester2");
        String phone=MyAcc.Phone.getAttribute("value");
        Assert.assertEquals(phone, "8905641237");
        click(WebODLogin.msg_close);    
	}

	}
}


