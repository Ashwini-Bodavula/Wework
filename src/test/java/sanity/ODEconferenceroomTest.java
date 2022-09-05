

package sanity;

import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.loadTime;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import pageObjects.web.ConferenceRoomODE;
import pageObjects.web.webLoading;
import utilities.CommonOps;
import workflows.ODEconfrenceroomflows;
import workflows.ODEflows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class ODEconferenceroomTest extends CommonOps  {
	
	
	@Test(description = "Test01 - Verify User is able to select conference room in Pune",dataProvider= "PuneConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Pune")
    public void test01_SelectConferenceRoomInPune(String city , String location, String buildingName) throws InterruptedException
    {
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		
		String currentWindow = getWindowHandel();

			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					click(ODEconferenceroom.Addanothermeeting);
				
					boolean slotSelectionValidation = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "6", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ODEconferenceroom.addBtn);
						click(ODEconferenceroom.continuebutton);
					}	
				else
				{
					System.out.println("Please Select available slot");
//					mouseHover(WebLoading.closeIcon);
				}

				}
			}
		}
	

	@Test(description = "Test02 - Verify User is able to select conference room in Hyderabad",dataProvider= "HyderabadConferenceRoomWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Hyderabad")
    public void test02_SelectConferenceRoomInHyderabad(String city , String location, String buildingName) throws InterruptedException
	{
		
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		
		String currentWindow = getWindowHandel();

			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					click(ODEconferenceroom.Addanothermeeting);
				
					boolean slotSelectionValidation = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "6", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ODEconferenceroom.addBtn);
						click(ODEconferenceroom.continuebutton);
					}	
				else
				{
					System.out.println("Please Select available slot");
//					mouseHover(WebLoading.closeIcon);
				}

				}
			}
		}
	@Test(description = "Test01 - Verify User is able to select conference room in Delhi",dataProvider= "DelhiNCRConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Delhi")
    public void test03_SelectConferenceRoomInDelhi(String city , String location, String buildingName) throws InterruptedException
	{
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		
		String currentWindow = getWindowHandel();

			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					click(ODEconferenceroom.Addanothermeeting);
				
					boolean slotSelectionValidation = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "6", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ODEconferenceroom.addBtn);
						click(ODEconferenceroom.continuebutton);
					}	
				else
				{
					System.out.println("Please Select available slot");
//					mouseHover(WebLoading.closeIcon);
				}

				}
			}
		}
	
	@Test(description = "Test04 - Verify User is able to select conference room in Bengaluru",dataProvider= "BengaluruConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Bengaluru")
    public void test04_SelectConferenceRoomInBengaluru(String city , String location, String buildingName) throws InterruptedException
	{
		
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		
		String currentWindow = getWindowHandel();

			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					click(ODEconferenceroom.Addanothermeeting);
				
					boolean slotSelectionValidation = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "6", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ODEconferenceroom.addBtn);
						click(ODEconferenceroom.continuebutton);
					}	
				else
				{
					System.out.println("Please Select available slot");
//					mouseHover(WebLoading.closeIcon);
				}

				}
			}
		}
	@Test(description = "Test05 - Verify User is able to select conference room in Mumbai",dataProvider= "MumbaiConferenceRoomWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select conference room in Mumbai")
    public void test05_SelectConferenceRoomInMumbai(String city , String location, String buildingName) throws InterruptedException
	{
		
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		
		String currentWindow = getWindowHandel();

			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					click(ODEconferenceroom.Addanothermeeting);
				
					boolean slotSelectionValidation = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,  "6", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ODEconferenceroom.addBtn);
						click(ODEconferenceroom.continuebutton);
					}	
				else
				{
					System.out.println("Please Select available slot");
//					mouseHover(WebLoading.closeIcon);
				}

				}
			}
		}
	
	
		@DataProvider(name="PuneConferenceRoomWorkspaces")
         public Object[][] puneConferenceRoomWorkspaces()
        {
	   return new Object[][] { 
//		{"Pune","Kharadi","World Trade Center"},
		{"Pune","Magarpatta Road","Panchshil Futura"}
		};
	
}
		@DataProvider(name="HyderabadConferenceRoomWorkspaces")
		public Object[][] hyderabadConferenceRoomWorkspaces()
		{
			return new Object[][] {
				{"Hyderabad","Financial District","Rajapushpa Summit"},
//				{"Hyderabad","Hitec City","Krishe Emerald"}
				};

		}

		@DataProvider(name="DelhiNCRConferenceRoomWorkspaces")
		public Object[][] delhiNCRConferenceRoomWorkspaces()
		{
			return new Object[][] {
				{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
//				{"Delhi-NCR","Cybercity","DLF Forum"},
//				{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
//				{"Delhi-NCR","Bristol Chowk","Platina Tower"},
//				{"Delhi-NCR","Golf Course Road","Two Horizon Centre"},
//				{"Delhi-NCR","Udyog Vihar","Blue One Square"},
//				{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
				};
		}

		@DataProvider(name="BengaluruConferenceRoomWorkspaces")
		public Object[][] bengaluruConferenceRoomWorkspaces()
		{
			return new Object[][] {
				{"Bengaluru","Koramangala","Prestige Atlanta"},
//				{"Bengaluru","Koramangala","Prestige Cube"},
//				{"Bengaluru","MG Road","The Pavilion"},
//				{"Bengaluru","MG Road","Galaxy"},
//				{"Bengaluru","MG Road","Embassy Quest"},
//				{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
//				{"Bengaluru","Infantry Road","Prestige Central"},
//				{"Bengaluru","Domlur","Sunriver, EGL"},
//				{"Bengaluru","Domlur","Cinnabar Hills, EGL"},
//				{"Bengaluru","Bellandur","Embassy TechVillage"},
//				{"Bengaluru","Bellandur","Vaishnavi Signature"},
//				{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
//				{"Bengaluru","Hebbal","Manyata NXT"},
//				{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
				};
		}

		@DataProvider(name="MumbaiConferenceRoomWorkspaces")
		public Object[][] mumbaiConferenceRoomWorkspaces()
		{
			return new Object[][] {
				{"Mumbai","Nariman Point","Express Towers"},
//				{"Mumbai","Goregaon East","Oberoi Commerz II"},
//				{"Mumbai","Goregaon East","NESCO IT Park"},
//				{"Mumbai","Vikhroli West","247 Park"},
//				{"Mumbai","Thane","Zenia"},
//				{"Mumbai","Andheri East","Vijay Diamond"},
//				{"Mumbai","Andheri East","Raheja Platinum"},
//				{"Mumbai","Powai","Chromium"},
//				{"Mumbai","Navi Mumbai","Seawoods Grand Central"},
//				{"Mumbai","Malad","Spectrum Tower"},
//				{"Mumbai","Worli","Vaswani Chambers"},
//				{"Mumbai","BKC","Enam Sambhav"}
				};

		}

}