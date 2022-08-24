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
import workflows.ODEconfrenceroomflows;
import workflows.ODEflows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class ODEconferenceroomTest extends ConferenceRoomODE  {
	
	
	@Test(description = "Test01 - Verify User is able to select conference room in Pune",dataProvider= "PuneConferenceRoomWorkspaces")
    @Description("This test verifies that User is able to select conference room in Pune")
    public void test01_SelectConferenceRoomInPune(String city , String location, String buildingName) throws InterruptedException
    {
		ODEflows.loginToODE();
		ODEconfrenceroomflows.selection(city, location, buildingName);
		ODEconfrenceroomflows.selectdate(getData("month"),getData("date"));
    }
		
    

		@DataProvider(name="PuneConferenceRoomWorkspaces")
         public Object[][] puneConferenceRoomWorkspaces()
        {
	   return new Object[][] { 
//		{"Pune","Kharadi","World Trade Center"},
		{"Pune","Magarpatta Road","Panchshil Futura"}
		};
	
}
    }
