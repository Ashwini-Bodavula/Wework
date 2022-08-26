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
        switchToParentWindow(currentWindow);
        waitForLoad();
     //   Verifications.verifyTextInElement(WebLogin.userName, getData("user"));
    }

    @Step("Logout of the application")
    public static void logoutOfApplication() throws InterruptedException
    {
    	scrollToElement(WebLoading.logout);
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
	    	click(Enterprise.locationDropdown);
	        loadTime(1);
	    	click(Enterprise.selectCity(city));
	    	click(Enterprise.selectLocation(location));
	    	click(Enterprise.noOfPplDrpdwn);
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



    @Step("Fill the form")
    public static void fillTheFormDetails() throws InterruptedException
    {
    	updateText(WebLoading.username, getData("Username"));
		updateText(WebLoading.userEmail, getData("email"));
		updateText(WebLoading.userPhnNumber, getData("phoneNumber"));
		scrollToElement(WebLoading.plusIcon);
		selectNoOfPeople(4);
		selectDate("2024", "September", "26");
//		Verifications.elementIsVisible(WebLoading.continueBtn);
//		click(WebLoading.continueBtn);
//		Verifications.elementIsVisible(WebLoading.thankyouText);
//		String actualText = WebLoading.thankyouText.getText();
//		Verifications.elementIsVisible(WebLoading.thankyouText);
//		Verifications.verifyText(actualText, "Thank you for contacting WeWork");
//		click(WebLoading.backToHomePageBtn);
		mouseHover(WebLoading.closeIcon); //as the form is not submited and msg is not validated, clicking on close icon

    }

    @Step("Fill the Enterprise form")
    public static void fillEnterpriseFormDetails() throws InterruptedException
    {
    	click(Enterprise.getInTouchBtn);
    	updateText(Enterprise.fullName, getData("Username"));
        updateText(Enterprise.workEmail, getData("email"));
        updateText(Enterprise.phoneNumber, getData("phoneNumber"));
    	scrollToElement(Enterprise.companySizeDrpdwn);
    	click(Enterprise.companySizeDrpdwn);
    	click(Enterprise.selectCompanySize("100+"));
    	loadTime(1);
    	mouseHover(Enterprise.noRadioBtn);
//    	click(Enterprise.getInTouchButton);
//    	loadTime(1);
//    	Verifications.elementIsVisible(WebLoading.FormSubbmittedMsg);
//      String actualText = WebLoading.FormSubbmittedMsg.getText();
//      Verifications.verifyText(actualText,"Form Submitted Successfully");

    }



    @Step ("Select date in Calander UI")
	public static void selectDate(String year, String month, String date) throws InterruptedException
	{
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

	@Step ("Select date in Calander UI")
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
    public static void selectNoOfPeople(int count)
    {
    	if(count == 1)
    	{
    		return;
    	}

    	for(int i=1;i<count;i++)
    	{
    		click(WebLoading.plusIcon);
    	}

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
   public static void verifyPriceBreakupForDayPass() throws InterruptedException
   {
		String continueBtnAmount = DayPass.continueBtn.getText().split("₹")[1].trim();
		int amountInContinueBtn = WebFlows.priceValueInt(continueBtnAmount);
        click(DayPass.continueBtn);

        String skipAndPayBtnAmount = DayPass.skipAndPayBtn.getText().split("₹")[1].trim();
		int amountInSkipAndPayBtn = WebFlows.priceValueInt(skipAndPayBtnAmount);
        click(DayPass.skipAndPayBtn);

        int finalPrice =0;
        int finalAmount=0;
        boolean userNamePresent = false;
        String[] value = DayPass.priceBreakupContainer.getText().split("\n");
        for(int i=0;i<value.length;i++)
        {
        	String[] numArray = {WebFlows.month(getData("month1")),getData("date1"),
//       						 WebFlows.month(getData("month2")),getData("date2"),
//       						 WebFlows.month(getData("month2")),getData("date1"),
//       			             WebFlows.month(getData("month3")),getData("date3")
       			             };

       	for(int j=0;j<numArray.length-1;j++)
       	{
	        		if(value[i].contains(numArray[j]) && value[i].contains(numArray[j+1]))
		        	{
	        			String price = value[i+2].split("₹")[1].trim();
		        		int amount = WebFlows.priceValueInt(price);
		        		finalPrice = finalPrice + amount;
		        		break;

		        	}
       	}
       	if(value[i].contains(getData("user")))
      	{
       		userNamePresent = true;
      		Assert.assertTrue(userNamePresent, "Selected DayPass for "+getData("user"));
      	}
       	if(value[i].contains("Total"))
       	{
       		String price = value[i].split("₹")[1].trim();
       		finalAmount = WebFlows.priceValueInt(price);
       	}

       }
        loadTime(3);
       String confirmAndPayBtnAmount = DayPass.confirmAndPayBtn.getText().split("₹")[1].trim();
       int amountInConfirmAndPayBtn = WebFlows.priceValueInt(confirmAndPayBtnAmount);


       if(amountInContinueBtn == amountInSkipAndPayBtn && amountInContinueBtn == amountInConfirmAndPayBtn
    		   && finalAmount == finalPrice && userNamePresent )
       {
       	scrollToElement(DayPass.confirmAndPayBtn);
       	click(DayPass.confirmAndPayBtn);
       	String PaymentWindow = getWindowHandels();
	    switchToParentWindow(PaymentWindow);
       }

   }

   @Step("Verify the price breakup for team member after selecting day passes")
   public static void verifyPriceBreakupforTeamMember(String teamMemberName) throws InterruptedException
   {
	   String skipAndPayBtnAmount = DayPass.skipAndPayBtn.getText().split("₹")[1].trim();
	   int amountInSkipAndPayBtn = WebFlows.priceValueInt(skipAndPayBtnAmount);
       click(DayPass.skipAndPayBtn);

       int finalPrice =0;
       int finalAmount=0;
       boolean teamMamberNameIsPresent = false;
       String[] value = DayPass.priceBreakupContainer.getText().split("\n");
       for(int i=0;i<value.length;i++)
       {
       	String[] numArray = {WebFlows.month(getData("month1")),getData("date1") };

      	for(int j=0;j<numArray.length-1;j++)
      	{
	        		if(value[i].contains(numArray[j]) && value[i].contains(numArray[j+1]))
		        	{
	        			String price = value[i+2].split("₹")[1].trim();
		        		int amount = WebFlows.priceValueInt(price);
		        		finalPrice = finalPrice + amount;
		        		break;

		        	}
      	}
      	if(value[i].contains(teamMemberName))
      	{
      		teamMamberNameIsPresent = true;
      		Assert.assertTrue(teamMamberNameIsPresent, "Selected DayPass for Team member "+teamMemberName);
      	}
      	if(value[i].contains("Total"))
      	{
      		String price = value[i].split("₹")[1].trim();
      		finalAmount = WebFlows.priceValueInt(price);
      		loadTime(3);
      	}
      }

       String confirmAndPayBtnAmount = DayPass.confirmAndPayBtn.getText().split("₹")[1].trim();
       int amountInConfirmAndPayBtn = WebFlows.priceValueInt(confirmAndPayBtnAmount);

      if(amountInConfirmAndPayBtn == amountInSkipAndPayBtn  && finalAmount == finalPrice && teamMamberNameIsPresent)
      {
      	scrollToElement(DayPass.confirmAndPayBtn);
      	click(DayPass.confirmAndPayBtn);
      	String PaymentWindow = getWindowHandels();
	    switchToParentWindow(PaymentWindow);
      }
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
		click(Events.clockIcon);
		loadTime(3);
		mouseHover(Events.selectHour(hours));
		loadTime(3);
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
		scrollToElement(Wbs.fullName);
		Verifications.elementIsVisible(Wbs.fullName);
		updateText(Wbs.fullName, getData("name"));
		updateText(Wbs.companyName, getData("companyName"));
		updateText(Wbs.companyEmail, getData("companyEmail"));
		updateText(Wbs.phoneNumber, getData("phoneNumber"));
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
    	scrollToElement(GetInTouch.firstName);
    	Verifications.elementIsVisible(GetInTouch.firstName);
    	updateText(GetInTouch.firstName, getData("name"));
        updateText(GetInTouch.lastName, getData("lastName"));
        updateText(GetInTouch.companyName, getData("companyName"));
        updateText(GetInTouch.companyEmail, getData("companyEmail"));
        updateText(GetInTouch.phoneNumber, getData("phoneNumber"));
        click(GetInTouch.locationsDrpdwn);
        click(GetInTouch.select("Pune"));
        click(GetInTouch.micromarketDrpdwn);
        click(GetInTouch.select("Kharadi"));
        click(GetInTouch.buildingsDropdown);
        click(GetInTouch.select("World Trade Center"));
        click(GetInTouch.workspaceTypedrpdwn);
        click(GetInTouch.select("Private Office"));
        click(GetInTouch.increaseNoOfDesk);
        click(GetInTouch.increaseNoOfDesk);
        click(GetInTouch.decreaseNoOfDesk);
        //click(GetInTouch.getInTouchBtn);
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


