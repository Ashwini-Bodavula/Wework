package sanity;

import static extensions.UIActions.*;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectConferenceRoomTest extends CommonOps
{


	@Test(description = "Test01 - Verify User is able to select conference room in Pune",dataProvider= "PuneConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Pune")
    public void test01_SelectConferenceRoomInPune(String city , String location, String buildingName) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
		if (conferenceRoomOptn.contains("disabled")) {
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = ConferenceRoom.conferenceRoomHeader.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = WebFlows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August", "26", "4", "10:00 AM");
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
				Assert.assertTrue(false, "Subscription type mismatch");
			}
		}
		WebFlows.logoutOfApplication();
     }



	@Test(description = "Test02 - Verify User is able to select conference room in Hyderabad",dataProvider= "HyderabadConferenceRoomWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Hyderabad")
    public void test02_SelectConferenceRoomInHyderabad(String city , String location, String buildingName) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
		if (conferenceRoomOptn.contains("disabled")) {
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = ConferenceRoom.conferenceRoomHeader.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = WebFlows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected==true)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation==true)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August", "26", "4", "10:00 AM");
						if(slotsValidationinPriceBreakup == true)
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
				Assert.assertTrue(false, "Subscription type mismatch");
			}
		}
		WebFlows.logoutOfApplication();
     }

	@Test(description = "Test01 - Verify User is able to select conference room in Delhi",dataProvider= "DelhiNCRConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Delhi")
    public void test03_SelectConferenceRoomInDelhi(String city , String location, String buildingName) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
		if (conferenceRoomOptn.contains("disabled")) {
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = ConferenceRoom.conferenceRoomHeader.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = WebFlows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected==true)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation==true)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August ", "26", "4", "10:00 AM");
						if(slotsValidationinPriceBreakup == true)
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
				Assert.assertTrue(false, "Subscription type mismatch");
			}
		}
		WebFlows.logoutOfApplication();
     }

	@Test(description = "Test04 - Verify User is able to select conference room in Bengaluru",dataProvider= "BengaluruConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Bengaluru")
    public void test04_SelectConferenceRoomInBengaluru(String city , String location, String buildingName) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
		if (conferenceRoomOptn.contains("disabled")) {
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = ConferenceRoom.conferenceRoomHeader.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = WebFlows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected==true)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation==true)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August", "26", "4", "10:00 AM");
						if(slotsValidationinPriceBreakup == true)
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
				Assert.assertTrue(false, "Subscription type mismatch");
			}
		}
		WebFlows.logoutOfApplication();
     }

	@Test(description = "Test05 - Verify User is able to select conference room in Mumbai",dataProvider= "MumbaiConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Mumbai")
    public void test05_SelectConferenceRoomInMumbai(String city , String location, String buildingName) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String currentWindow = getWindowHandel();
		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
		if (conferenceRoomOptn.contains("disabled")) {
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = ConferenceRoom.conferenceRoomHeader.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = WebFlows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected==true)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ConferenceRoom.addBtn);
					click(ConferenceRoom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation==true)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August", "26", "4", "10:00 AM");
						if(slotsValidationinPriceBreakup == true)
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
				Assert.assertTrue(false, "Subscription type mismatch");
			}
		}
		WebFlows.logoutOfApplication();
     }

	


	@DataProvider(name="PuneConferenceRoomWorkspaces")
	public Object[][] puneConferenceRoomWorkspaces()
	{
		return new Object[][] {
//			{"Pune","Kharadi","World Trade Center"},
			{"Pune","Magarpatta","Panchshil Futura"}
			};

	}

	@DataProvider(name="HyderabadConferenceRoomWorkspaces")
	public Object[][] hyderabadConferenceRoomWorkspaces()
	{
		return new Object[][] {
			{"Hyderabad","Financial District","Rajapushpa Summit"},
//			{"Hyderabad","Hitec City","Krishe Emerald"}
			};

	}

	@DataProvider(name="DelhiNCRConferenceRoomWorkspaces")
	public Object[][] delhiNCRConferenceRoomWorkspaces()
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

	@DataProvider(name="BengaluruConferenceRoomWorkspaces")
	public Object[][] bengaluruConferenceRoomWorkspaces()
	{
		return new Object[][] {
			{"Bengaluru","Koramangala","Prestige Atlanta"},
//			{"Bengaluru","Koramangala","Prestige Cube"},
//			{"Bengaluru","MG Road","The Pavilion"},
//			{"Bengaluru","MG Road","Galaxy"},
//			{"Bengaluru","MG Road","Embassy Quest"},
//			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
//			{"Bengaluru","Infantry Road","Prestige Central"},
//			{"Bengaluru","Domlur","Sunriver, EGL"},
//			{"Bengaluru","Domlur","Cinnabar Hills, EGL"},
//			{"Bengaluru","Bellandur","Embassy TechVillage"},
//			{"Bengaluru","Bellandur","Vaishnavi Signature"},
//			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
//			{"Bengaluru","Hebbal","Manyata NXT"},
//			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}

	@DataProvider(name="MumbaiConferenceRoomWorkspaces")
	public Object[][] mumbaiConferenceRoomWorkspaces()
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





}
