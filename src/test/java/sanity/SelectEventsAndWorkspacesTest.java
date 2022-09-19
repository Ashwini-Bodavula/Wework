package sanity;

import static extensions.UIActions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		        click(Events.dateField);
		        updateText(Events.dateField, "22/10/2022");
		        click(Events.timeField);
		        updateText(Events.timeField, "06:50 AM");
		        click(Events.plusIcon);
		        scrollToElement(Events.selectdropDown(1));
		        mouseHover(Events.selectdropDown(1));
		        mouseHover(Events.selectlocation("Pune"));
		        scrollToElement(Events.selectdropDown(2));
		        mouseHover(Events.selectdropDown(2));
		        mouseHover(Events.selectlocation("Panchshil Futura"));
		        mouseHover(Events.selectRadioBtn(4));
		        scrollToElement(Events.selectdropDown(3));
		        mouseHover(Events.selectdropDown(3));
		        mouseHover(Events.selectWorkshops);
		        mouseHover(Events.selectRadioBtn(6));
		        mouseHover(Events.selectRadioBtn(9));
		        //mouseHover(Events.select("Submit Enquiry"));

    }

}
