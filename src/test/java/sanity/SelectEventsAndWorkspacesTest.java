package sanity;

import static extensions.UIActions.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;
@Listeners(utilities.Listeners.class)
public class SelectEventsAndWorkspacesTest extends CommonOps
{

	@Test(description = "Test01 - Verify User is able to select Events and workspaces", groups= {"CO"})
    @Description("This test verifies that User is able to select Events and workspaces")
    public void test01_SelectEventsAndWorkspaces() throws InterruptedException
    {	//yet to complete
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
        click(WebLoading.workspaceDrpdwn);
        click(WebLoading.opt("Event and shoot spaces"));
        click(WebLoading.getInTouchButton);
        scrollToElement(Events.select("Name*"));
        updateText(Events.opt("Name*"), getData("name"));
        updateText(Events.opt("Email*"), getData("email"));
        updateText(Events.opt("Company name*"), getData("companyName"));
        updateText(Events.opt("Phone*"), getData("phoneNumber"));
        mouseHover(Events.noRadioBtn1);
        loadTime(4);
        click(Events.calendarIcon);
        click(Events.selectDate("29"));
        click(Events.clockIcon);
        scrollToElement(Events.selectHour("6 hours"));
        mouseHover(Events.selectHour("6 hours"));
       // click(Events.selectHour("6"));
        scrollToElement(Events.selectMinute("40 minutes"));
        mouseHover(Events.selectMinute("40 minutes"));
       // click(Events.selectMinute("30"));
        	loadTime(1);
        	click(Events.plusIcon);
        mouseHover(Events.cityDropdown);
       // click(Events.cityDropdown);
        //scrollToElement(Events.select("Pune"));
        mouseHover(Events.selectlocation("Pune"));
        scrollToElement(Events.buildingDropdown);
        mouseHover(Events.buildingDropdown);
        mouseHover(Events.selectlocation("Panchshil Futura"));
        loadTime(2);
        mouseHover(Events.yesRadioBtn2);
       // scrollToElement(Events.select("Panchshil Futura"));

        scrollToElement(Events.eventTypeDropdown);
        mouseHover(Events.eventTypeDropdown);
        scrollToElement(Events.select("Shoots"));
        mouseHover(Events.select("Shoots"));
        loadTime(2);
        mouseHover(Events.yesRadioBtn3);
        mouseHover(Events.productionRadioBtn);
        mouseHover(Events.select("Submit Enquiry"));

    }

}
