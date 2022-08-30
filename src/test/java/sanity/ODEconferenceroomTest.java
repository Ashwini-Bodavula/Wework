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
//		ODEconfrenceroomflows.selectdate(getData("month"),getData("date"));
		
		String currentWindow = getWindowHandel();
//		String conferenceRoomOptn = WebLoading.conferenceRoomOptn.getAttribute("class");
//		if (conferenceRoomOptn.contains("disabled")) {
//			mouseHover(WebLoading.closeIcon);
//
//		} else
//		{
////			click(WebLoading.conferenceRoomOptn);
////			click(WebLoading.bookNowBtn);
			String subscriptionType = ODEconferenceroom.ConferenceRoomS.getText();
			if (subscriptionType.contains("Conference Room"))
			{
				//int hours, String year, String month, String date, String seaterSize, String slot
				boolean slotSelected = ODEconfrenceroomflows.selectConferenceRoomDateAndSlots(4,"2022", "August", "26", "4", "10:00 AM");
				if(slotSelected)
				{
					Assert.assertTrue(true, "Selected available slot");
					scrollToElement(ODEconferenceroom.addBtn);
					click(ODEconferenceroom.addBtn);
					loadTime(2);
					boolean slotSelectionValidation = WebFlows.validateSlotSelection(4,"2022", "August", "26", "4", "10:00 AM");
					if(slotSelectionValidation)
					{
						click(ConferenceRoom.continueBtn);
						boolean slotsValidationinPriceBreakup = WebFlows.verifyPriceBreakupforConferenceRoom(4,"2022", "August", "26", "4", "10:00 AM");
						if(slotsValidationinPriceBreakup)
						{
//							
							
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
//		WebFlows.logoutOfApplication();
     


    
		
    

		@DataProvider(name="PuneConferenceRoomWorkspaces")
         public Object[][] puneConferenceRoomWorkspaces()
        {
	   return new Object[][] { 
//		{"Pune","Kharadi","World Trade Center"},
		{"Pune","Magarpatta Road","Panchshil Futura"}
		};
	
}
    }
