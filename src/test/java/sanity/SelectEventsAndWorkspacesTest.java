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
    {	
		
			//	WebFlows.loadWebsite();
				WebFlows.loginToApplication();
		        click(WebLoading.workspaceDrpdwn);
		        click(WebLoading.opt("Event and shoot spaces"));
		        click(WebLoading.getInTouchButton);
		        scrollToElement(Events.opt("Name*"));
		        updateText(Events.opt("Name*"), getData("name"));
		        updateText(Events.opt("Email*"), getData("email"));
		        updateText(Events.opt("Company name*"), getData("companyName"));
		        updateText(Events.opt("Phone*"), getData("phoneNumber"));
		        mouseHover(Events.selectRadioBtn(2));
		        Thread.sleep(2000);
		        click(Events.select("CalendarIcon"));
		        Thread.sleep(2000);
		        WebFlows.selectDate(getData("month2"),getData("date2"));
		        WebFlows.selectTime("2 hours", "20 minutes");
		        click(Events.plusIcon);
		        Thread.sleep(2000);
		        mouseHover(Events.selectdropDown(1));
		        Thread.sleep(1000);
		        mouseHover(Events.selectlocation("Pune"));
		        Thread.sleep(2000);
		        mouseHover(Events.selectdropDown(2));
		        mouseHover(Events.selectlocation("Panchshil Futura"));
		        Thread.sleep(2000);
		        mouseHover(Events.selectRadioBtn(4));
		        Thread.sleep(2000);
		        mouseHover(Events.selectdropDown(3));
		        mouseHover(Events.selectWorkshops);
		        Thread.sleep(2000);
		        mouseHover(Events.selectRadioBtn(6));
		        mouseHover(Events.selectRadioBtn(9));
		        Thread.sleep(4000);
		        //mouseHover(Events.productionRadioBtn);
		        //mouseHover(Events.select("Submit Enquiry"));

    }

}
