package sanity;

import static extensions.UIActions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectDayPassTest extends CommonOps
{


/*	@Test(description = "Test01 - Verify User is able to select day pass in Pune. (In  home page navigate to workspaces and select day pass)",dataProvider = "PuneDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass in Pune. (In  home page navigate to workspaces and select day pass)")
	@Step("Test steps")
    public void test01_SelectDayPassInPune(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			boolean bookNowBtnBeforeClick = WebLoading.bookNowBtn.isEnabled();
			Assert.assertEquals(bookNowBtnBeforeClick, false);
			loadTime(1);

			click(WebLoading.dayPassBtn);
			String DayPassSelected = WebLoading.dayPassBtn.getAttribute("class");
			if(DayPassSelected.contains("card_selected"))
			{
				loadTime(1);
				boolean bookNowBtnAfterClick = WebLoading.bookNowBtn.isEnabled();
				Assert.assertEquals(bookNowBtnAfterClick, true);
				click(WebLoading.bookNowBtn);

				String daypaassHeader = DayPass.dayPassHeader.getText();
				if(daypaassHeader.contains(buildingName))
				{
					Assert.assertTrue(true, "Building name is matching");
					boolean ContinuebtnBeforeClick = DayPass.continueBtn.isEnabled();
					Assert.assertEquals(ContinuebtnBeforeClick, false);

					WebFlows.selectDate(getData("month1"),getData("date1"));
//					WebFlows.selectDate(getData("month2"),getData("date2"));
//					WebFlows.selectDate(getData("month2"),getData("date1"));
//					WebFlows.selectDate(getData("month3"),getData("date3"));
					loadTime(1);
					boolean ContinuebtnAfterClick = DayPass.continueBtn.isEnabled();
					Assert.assertEquals(ContinuebtnAfterClick, true);
					WebFlows.verifyPriceBreakupForDayPass();
			        WebFlows.proceedWithPayment();
			        UIActions.closeCurrentWindow();
			        switchToParentWindow(currentWindow);
			        Verifications.elementIsVisible(WebLoading.closeIcon);
			        click(WebLoading.closeIcon);
				}
				else
				{
					Assert.assertTrue(false, "Building name is not matching");
				}
			}
		}
		WebFlows.logoutOfApplication();
    }


/*	@Test(description = "Test02 - Verify User is able to select day pass in Hyderabad. (In  home page navigate to workspaces and select day pass)",dataProvider = "HyderabadDayPassWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to select day pass in Hyderabad. (In  home page navigate to workspaces and select day pass)")
    public void test02_SelectDayPassInHyderabad(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			String DayPassSelected = WebLoading.dayPassBtn.getAttribute("class");
			if(DayPassSelected.contains("card_selected"))
			{
				click(WebLoading.bookNowBtn);
				String daypaassHeader = DayPass.dayPassHeader.getText();
				if(daypaassHeader.contains(buildingName))
				{
					Assert.assertTrue(true, "Building name is matching");
					WebFlows.selectDate(getData("month1"),getData("date1"));
					loadTime(1);
					WebFlows.verifyPriceBreakupForDayPass();
			        WebFlows.proceedWithPayment();
			        UIActions.closeCurrentWindow();
			        switchToParentWindow(currentWindow);
			        Verifications.elementIsVisible(WebLoading.closeIcon);
			        click(WebLoading.closeIcon);
				}
				else
				{
					Assert.assertTrue(false, "Building name is not matching");
				}
			}
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test03 - Verify User is able to select day pass in Delhi. (In  home page navigate to workspaces and select day pass)",dataProvider = "DelhiNCRDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass in Delhi. (In  home page navigate to workspaces and select day pass)")
    public void test03_SelectDayPassInDelhi(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			String DayPassSelected = WebLoading.dayPassBtn.getAttribute("class");
			if(DayPassSelected.contains("card_selected"))
			{
				click(WebLoading.bookNowBtn);
				String daypaassHeader = DayPass.dayPassHeader.getText();
				if(daypaassHeader.contains(buildingName))
				{
					Assert.assertTrue(true, "Building name is matching");
					WebFlows.selectDate(getData("month1"),getData("date1"));
					loadTime(1);
					WebFlows.verifyPriceBreakupForDayPass();
			        WebFlows.proceedWithPayment();
			        UIActions.closeCurrentWindow();
			        switchToParentWindow(currentWindow);
			        Verifications.elementIsVisible(WebLoading.closeIcon);
			        click(WebLoading.closeIcon);
				}
				else
				{
					Assert.assertTrue(false, "Building name is not matching");
				}
			}
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test04 - Verify User is able to select day pass in Bengaluru. (In  home page navigate to workspaces and select day pass)",dataProvider = "BengaluruDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass in Bengaluru. (In  home page navigate to workspaces and select day pass)")
    public void test04_SelectDayPassInBengaluru(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			String DayPassSelected = WebLoading.dayPassBtn.getAttribute("class");
			if(DayPassSelected.contains("card_selected"))
			{
				click(WebLoading.bookNowBtn);
				String daypaassHeader = DayPass.dayPassHeader.getText();
				if(daypaassHeader.contains(buildingName))
				{
					Assert.assertTrue(true, "Building name is matching");
					WebFlows.selectDate(getData("month1"),getData("date1"));
					loadTime(1);
					WebFlows.verifyPriceBreakupForDayPass();
			        WebFlows.proceedWithPayment();
			        UIActions.closeCurrentWindow();
			        switchToParentWindow(currentWindow);
			        Verifications.elementIsVisible(WebLoading.closeIcon);
			        click(WebLoading.closeIcon);
				}
				else
				{
					Assert.assertTrue(false, "Building name is not matching");
				}
			}
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test05 - Verify User is able to select day pass in Mumbai. (In  home page navigate to workspaces and select day pass)",dataProvider = "MumbaiDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass in Mumbai. (In  home page navigate to workspaces and select day pass)")
    public void test05_SelectDayPassInMumbai(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			String DayPassSelected = WebLoading.dayPassBtn.getAttribute("class");
			if(DayPassSelected.contains("card_selected"))
			{
				click(WebLoading.bookNowBtn);
				String daypaassHeader = DayPass.dayPassHeader.getText();
				if(daypaassHeader.contains(buildingName))
				{
					Assert.assertTrue(true, "Building name is matching");
					WebFlows.selectDate(getData("month1"),getData("date1"));
					loadTime(1);
					WebFlows.verifyPriceBreakupForDayPass();
			        WebFlows.proceedWithPayment();
			        UIActions.closeCurrentWindow();
			        switchToParentWindow(currentWindow);
			        Verifications.elementIsVisible(WebLoading.closeIcon);
			        click(WebLoading.closeIcon);
				}
				else
				{
					Assert.assertTrue(false, "Building name is not matching");
				}
			}
		}
		WebFlows.logoutOfApplication();
    }


	@Test(description = "Test06 - Verify User is able to select day pass for others. (In  home page navigate to workspaces and select day pass)",dataProvider = "MumbaiWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass for others. (In  home page navigate to workspaces and select day pass)")
    public void test06_SelectDayPassForTeamMember(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			click(WebLoading.bookNowBtn);
			String daypaassHeader = DayPass.dayPassHeader.getText();
			if(daypaassHeader.contains(buildingName))
			{
				Assert.assertTrue(true, "Building name is matching");
				WebFlows.selectDate(getData("month1"), getData("date1"));
				click(DayPass.continueBtn);
				loadTime(2);

				//delete the existing member
				click(DayPass.deleteMemberBtn);
				loadTime(4);

				//add same member twice and validate for error message
				WebFlows.addTeamMemberForDayPass(getData("teamMember1"),getData("teamMember1Email"));
				WebFlows.addTeamMemberForDayPass(getData("teamMember1"),getData("teamMember1Email"));
		    	Verifications.elementIsVisible(DayPass.errorMsgForAddingSameMember);
		    	if(DayPass.errorMsgForAddingSameMember.isDisplayed())
		    	{
			    	String errorMsg = DayPass.errorMsgForAddingSameMember.getText();
			    	Assert.assertEquals("Team member with this email ID already exists in this team", errorMsg);
			    	click(DayPass.closeMemberBtn);
			    	loadTime(4);
		    	}
		    	click(DayPass.deleteMemberBtn);
		    	loadTime(4);

				//Add new member
				WebFlows.addTeamMemberForDayPass(getData("teamMember2"),getData("teamMember2Email"));
				List<WebElement> members = driver.findElements(By.xpath("//label[contains(@class,'checkbox')]"));
				loadTime(2);
				for (WebElement member : members) {
					if(member.getText().contains(getData("user")))
					{
						mouseHover(member); //deselect the user
						break;
					}
				}
				loadTime(2);
				WebFlows.verifyPriceBreakupforTeamMember(getData("teamMember2"));
				WebFlows.proceedWithPayment();
				UIActions.closeCurrentWindow();
				switchToParentWindow(currentWindow);
				Verifications.elementIsVisible(WebLoading.closeIcon);
				click(WebLoading.closeIcon);
			}
			else
			{
				Assert.assertTrue(false, "Building name is not matching");
			}
		}
		WebFlows.logoutOfApplication();
    }

*/
	@Test(description = "Test07 - Verify User is able to select day pass and Conference room for Team. (In  home page navigate to workspaces and select day pass)",dataProvider = "MumbaiWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass and Conference room for Team (In  home page navigate to workspaces and select day pass)")
    public void test07_SelectDayPassAndConferenceRoomForTeam(String city , String location, String buildingName) throws InterruptedException
    {

		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String DayPassOptnBtn = WebLoading.dayPassBtn.getAttribute("class");
		if (DayPassOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.dayPassBtn);
			click(WebLoading.bookNowBtn);
			String daypaassHeader = DayPass.dayPassHeader.getText();
			if(daypaassHeader.contains(buildingName))
			{
				Assert.assertTrue(true, "Building name is matching");
				WebFlows.selectDate(getData("month1"),getData("date1"));
				click(DayPass.continueBtn);
				loadTime(6);

				List<WebElement> members = driver.findElements(By.xpath("//label[contains(@class,'checkbox')]"));
				loadTime(2);
				for (WebElement member : members) {
					if(member.getText().contains(getData("teamMember2")))
					{
						mouseHover(member); //select the team member
						break;
					}
				}
				loadTime(2);

				click(DayPass.addConferenceRoomBtn);

				loadTime(2);

				boolean slotSelected =WebFlows.selectConferenceRoomSlots(2,"2","1:00 PM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(4);

					boolean slotSelectionValidation = WebFlows.validateSlotSelection(2,"2022", "August", "26", "2", "1:00 PM");
					if(slotSelectionValidation)
					{
						loadTime(3);
						click(ConferenceRoom.continueBtn);

						loadTime(3);
					boolean	slotsValidationinPriceBreakup =  WebFlows.verifyPriceBreakupforDayPassAndConferenceRoom(2,"2022", "August", "26", "2", "1:00 PM");
						if(slotsValidationinPriceBreakup)
						{
							click(ConferenceRoom.confirmAndPayBtn);
							String paymentWinow = getWindowHandels();
							switchToParentWindow(paymentWinow);
							WebFlows.proceedWithPayment();
					        UIActions.closeCurrentWindow();
					        switchToParentWindow(currentWindow);
					        Verifications.elementIsVisible(WebLoading.closeIcon);
					        click(WebLoading.closeIcon);
						}
					}


				}

				else
				{
					System.out.println("Please Select available slot");
					mouseHover(WebLoading.closeIcon);
				}

			}
			else
			{
				Assert.assertTrue(false, "Building name is not matching");
			}
		}
		WebFlows.logoutOfApplication();

    }


/*	@Test(description = "Test08 - Verify User is able to select day pass with budnles for Pune",dataProvider = "PuneDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass with budnles for Pune")
    public void test08_SelectDayPasswithBundlesforPune(String city , String location, String buildingName) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(WebLoading.workspaceDrpdwn);
		loadTime(2);
		click(WebLoading.opt("Day pass"));
		click(WebLoading.loctnDropdown2);
		click(WebLoading.selectloc(city));
		click(WebLoading.buildingDropdown);
		click(WebLoading.select(buildingName));
		click(WebLoading.select("Book a workspace"));
		String currentWindow = getWindowHandel();
		click(WebLoading.buyABundleLink);
		click(WebLoading.add10DayPassesBundle);
		scrollToElement(WebLoading.fiveDaypassAmount);
		String DayPassfor5Days =WebLoading.fiveDaypassAmount.getText().split(" ")[1];
		String DayPassfor10Days =WebLoading.tenDaypassAmount.getText().split(" ")[1];

		String value = "";
		for(int i=0;i<DayPassfor5Days.length();i++)
		{
				char ch = DayPassfor5Days.charAt(i);
				if(ch!=',')
				{
					value = value+ch;
				}
		}
		int DayPassAmountfor5days = Integer.parseInt(value);

		String value2 = "";
		for(int i=0;i<DayPassfor10Days.length();i++)
		{
				char ch = DayPassfor10Days.charAt(i);
				if(ch!=',')
				{
					value2 = value2+ch;
				}

		}
		int DayPassAmountfor10days = Integer.parseInt(value2);

		int totalAmount = DayPassAmountfor5days + DayPassAmountfor10days;
		//System.out.println("Total amount is "+totalAmount);

		String discount  =WebLoading.discount.getText().split(" ")[2];

		String value3 = "";
		for(int i=0;i<discount.length();i++)
		{
				char ch = discount.charAt(i);
				if(ch!=',')
				{
					value3 = value3+ch;
				}

		}
		int discountAmount = Integer.parseInt(value3);
		//System.out.println("Discount amount is "+discountAmount);

		int finalAmount= totalAmount -discountAmount;
		//System.out.println("Amount after applying discount is  "+finalAmount);

		String total  =WebLoading.totalAmount.getText().split(" ")[1];
		String value4 = "";
		for(int i=0;i<total.length();i++)
		{
				char ch = total.charAt(i);
				if(ch!=',')
				{
					value4 = value4+ch;
				}

		}
		int totalAmountValue = Integer.parseInt(value4);
		//System.out.println("Final  amount is "+totalAmountValue);
		Assert.assertEquals(finalAmount, totalAmountValue);

		click(WebLoading.select("Proceed to Pay"));
		loadTime(2);
		String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        loadTime(2);

        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(WebLoading.closeIcon);
        click(WebLoading.closeIcon);
        WebFlows.logoutOfApplication();

    }

	@Test(description = "Test09 - Verify User is able to select day pass with budnles (navigate to user's Dashboard and select day pass)", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass with budnles (navigate to user's Dashboard and select day pass)")
    public void test09_SelectDayPasswithBundlesfromDashboard() throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(WebLogin.userName);
		loadTime(4);
		scrollToElement(Dashboard.buyNowBtn);
		click(Dashboard.buyNowBtn);
		loadTime(4);
		String currentWindow = getWindowHandel();
		click(Dashboard.cityDropdown);
		click(Dashboard.opt("Mumbai"));
		click(Dashboard.buildingDropdown);
		click(Dashboard.opt("Zenia"));
		loadTime(4);
		click(Dashboard.add10DayPassesBundle);

		scrollToElement(Dashboard.fiveDaypassAmount);
		String DayPassfor5Days =Dashboard.fiveDaypassAmount.getText().split(" ")[1];
		String DayPassfor10Days =Dashboard.tenDaypassAmount.getText().split(" ")[1];

		String value = "";
		for(int i=0;i<DayPassfor5Days.length();i++)
		{
				char ch = DayPassfor5Days.charAt(i);
				if(ch!=',')
				{
					value = value+ch;
				}
		}
		int DayPassAmountfor5days = Integer.parseInt(value);

		String value2 = "";
		for(int i=0;i<DayPassfor10Days.length();i++)
		{
				char ch = DayPassfor10Days.charAt(i);
				if(ch!=',')
				{
					value2 = value2+ch;
				}

		}
		int DayPassAmountfor10days = Integer.parseInt(value2);

		int totalAmount = DayPassAmountfor5days + DayPassAmountfor10days;
		//System.out.println("Total amount is "+totalAmount);

		String discount  =Dashboard.discount.getText().split(" ")[2];

		String value3 = "";
		for(int i=0;i<discount.length();i++)
		{
				char ch = discount.charAt(i);
				if(ch!=',')
				{
					value3 = value3+ch;
				}

		}
		int discountAmount = Integer.parseInt(value3);
		//System.out.println("Discount amount is "+discountAmount);

		int finalAmount= totalAmount -discountAmount;
		//System.out.println("Amount after applying discount is  "+finalAmount);

		String total  =Dashboard.totalAmount.getText().split(" ")[1];
		String value4 = "";
		for(int i=0;i<total.length();i++)
		{
				char ch = total.charAt(i);
				if(ch!=',')
				{
					value4 = value4+ch;
				}

		}
		int totalAmountValue = Integer.parseInt(value4);
		//System.out.println("Final  amount is "+totalAmountValue);
		Assert.assertEquals(finalAmount, totalAmountValue);

		click(Dashboard.select("Proceed to Pay"));
		loadTime(2);
		String paymentWindow = getWindowHandels();
        switchToParentWindow(paymentWindow);
        loadTime(2);
        WebFlows.proceedWithPayment();
        UIActions.closeCurrentWindow();
        switchToParentWindow(currentWindow);
        Verifications.elementIsVisible(WebLoading.closeIcon);
        click(WebLoading.closeIcon);
        WebFlows.logoutOfApplication();
    }

	@Test(description = "Test10 - Verify User is able to select day pass with budnles (In  home page navigate to workspaces and select day pass)",dataProvider = "PuneDayPassWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select day pass with budnles (In  home page navigate to workspaces and select day pass)")
    public void test10_SelectDayPasswithBundlesfromWrkspaces(String city , String location, String buildingName) throws InterruptedException
    {
		//  WebFlows.loadWebsite();
		  WebFlows.loginToApplication();
	      scrollToElement(WebLoading.workspaceBtn);
	      click(WebLoading.cityDropdown);
	      click(WebLoading.select(city));
	      click(WebLoading.buildingsDropdown);
	      click(WebLoading.select(location));
	      click(WebLoading.select(buildingName));
	      click(WebLoading.exploreBtn);
	      String currentWindow = getWindowHandel();
	      scrollToElement(WebLoading.dayPassBtn);
	      click(WebLoading.dayPassBtn);
	      click(WebLoading.bookNowBtn);
	      click(WebLoading.buyABundleLink);
	      loadTime(4);
		  click(WebLoading.plusBtnToAdd10daypass);

			scrollToElement(Dashboard.fiveDaypassAmount);
			String DayPassfor5Days =Dashboard.fiveDaypassAmount.getText().split(" ")[1];
			String DayPassfor10Days =Dashboard.tenDaypassAmount.getText().split(" ")[1];

			String value = "";
			for(int i=0;i<DayPassfor5Days.length();i++)
			{
					char ch = DayPassfor5Days.charAt(i);
					if(ch!=',')
					{
						value = value+ch;
					}
			}
			int DayPassAmountfor5days = Integer.parseInt(value);

			String value2 = "";
			for(int i=0;i<DayPassfor10Days.length();i++)
			{
					char ch = DayPassfor10Days.charAt(i);
					if(ch!=',')
					{
						value2 = value2+ch;
					}

			}
			int DayPassAmountfor10days = Integer.parseInt(value2);

			int totalAmount = DayPassAmountfor5days + DayPassAmountfor10days;
			//System.out.println("Total amount is "+totalAmount);

			String discount  =Dashboard.discount.getText().split(" ")[2];

			String value3 = "";
			for(int i=0;i<discount.length();i++)
			{
					char ch = discount.charAt(i);
					if(ch!=',')
					{
						value3 = value3+ch;
					}

			}
			int discountAmount = Integer.parseInt(value3);
			//System.out.println("Discount amount is "+discountAmount);

			int finalAmount= totalAmount -discountAmount;
			//System.out.println("Amount after applying discount is  "+finalAmount);

			String total  =Dashboard.totalAmount.getText().split(" ")[1];
			String value4 = "";
			for(int i=0;i<total.length();i++)
			{
					char ch = total.charAt(i);
					if(ch!=',')
					{
						value4 = value4+ch;
					}

			}
			int totalAmountValue = Integer.parseInt(value4);
			//System.out.println("Final  amount is "+totalAmountValue);
			Assert.assertEquals(finalAmount, totalAmountValue);
			click(Dashboard.select("Proceed to Pay"));
			loadTime(2);
			String paymentWindow = getWindowHandels();
	        switchToParentWindow(paymentWindow);
	        loadTime(2);
	        WebFlows.proceedWithPayment();
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        Verifications.elementIsVisible(WebLoading.closeIcon);
	        click(WebLoading.closeIcon);
	        WebFlows.logoutOfApplication();

    }*/

	@DataProvider(name="PuneDayPassWorkspaces")
	public Object[][] puneDayPassWorkspaces()
	{
		return new Object[][] {
//			{"Pune","Kharadi","World Trade Center"},
			{"Pune","Magarpatta","Panchshil Futura"}
			};

	}

	@DataProvider(name="HyderabadDayPassWorkspaces")
	public Object[][] hyderabadDayPassWorkspaces()
	{
		return new Object[][] {
			{"Hyderabad","Financial District","Rajapushpa Summit"},
//			{"Hyderabad","Hitec City","Krishe Emerald"}
			};

	}

	@DataProvider(name="DelhiNCRDayPassWorkspaces")
	public Object[][] delhiNCRDayPassWorkspaces()
	{
		return new Object[][] {
			{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
//			{"Delhi-NCR","Cybercity","DLF Forum"},
//			{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
//			{"Delhi-NCR","Bristol Chowk","Platina Tower"},
//			{"Delhi-NCR","Golf Course Road","Two Horizon Centre"},
//			{"Delhi-NCR","Udyog Vihar","Blue One Square"},
//			{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
			};
	}

	@DataProvider(name="BengaluruDayPassWorkspaces")
	public Object[][] bengaluruDayPassWorkspaces()
	{
		return new Object[][] {
			{"Bengaluru","Koramangala","Prestige Atlanta"},
//			{"Bengaluru","Koramangala","Prestige Cube"},
//			{"Bengaluru","MG Road","The Pavilion"},
//			{"Bengaluru","MG Road","Galaxy"},
//			{"Bengaluru","MG Road","Embassy Quest"},
//			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
//			{"Bengaluru","Infantry Road","Prestige Central"},
//			{"Bengaluru","Domlur","Sunriver, EGL"}, //Day pass not avilable
//			{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //Day pass not avilable
//			{"Bengaluru","Bellandur","Embassy TechVillage"},
//			{"Bengaluru","Bellandur","Vaishnavi Signature"},
//			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
//			{"Bengaluru","Hebbal","Manyata NXT"},
//			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}

	@DataProvider(name="MumbaiDayPassWorkspaces")
	public Object[][] mumbaiDayPassWorkspaces()
	{
		return new Object[][] {
			{"Mumbai","Nariman Point","Express Towers"},
//			{"Mumbai","Goregaon East","Oberoi Commerz II"},
//			{"Mumbai","Goregaon East","NESCO IT Park"},
//			{"Mumbai","Vikhroli West","247 Park"},
//			{"Mumbai","Thane","Zenia"},
//			{"Mumbai","Andheri East","Vijay Diamond"},
//			{"Mumbai","Andheri East","Raheja Platinum"},
//			{"Mumbai","Powai","Chromium"},
//			{"Mumbai","Navi Mumbai","Seawoods Grand Central"},
//			{"Mumbai","Malad","Spectrum Tower"},
//			{"Mumbai","Worli","Vaswani Chambers"},
//			{"Mumbai","BKC","Enam Sambhav"}
			};

	}


	@DataProvider(name="MumbaiWorkspaces")
	public Object[][] mumbaiWorkspaces()
	{
		return new Object[][] {
			{"Mumbai","Nariman Point","Express Towers"},
			};

	}

}
