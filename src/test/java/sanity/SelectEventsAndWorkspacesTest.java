package sanity;

import static extensions.UIActions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectEventsAndWorkspacesTest extends CommonOps {

	@Test(description = "Test01 - Verify User is able to select Events and workspaces", groups = { "CO" })
	@Description("This test verifies that User is able to select Events and workspaces")
	public void test01_SelectEventsAndWorkspaces() throws InterruptedException 
	{
		// WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		click(WebLoading.workspaceDrpdwn);
		click(WebLoading.opt("Event and shoot spaces"));
		click(WebLoading.getInTouchButton);
		scrollToElement(Events.opt("Name*"));
		updateText(Events.opt("Name*"), getData("name"));
		updateText(Events.opt("Email*"), getData("email"));
		updateText(Events.opt("Company name*"), getData("companyName"));
		updateText(Events.opt("Phone*"), getData("phoneNumber"));
		mouseHover(Events.selectRadioButton("private WeWork", "Yes"));
		click(Events.dateField);
		updateText(Events.dateField, getData("date"));
		click(Events.timeField);
		updateText(Events.timeField, getData("time"));
		scrollToElement(Events.plusIcon);
		click(Events.plusIcon);
		Verifications.elementIsVisible(Events.selectdropDown("City"));
		mouseHover(Events.selectdropDown("City"));
		scrollToElement(Events.selectlocation(getData("city")));
		mouseHover(Events.selectlocation(getData("city")));
		scrollToElement(Events.selectdropDown("Building"));
		mouseHover(Events.selectdropDown("Building"));
		Verifications.elementIsVisible(Events.selectlocation(getData("building")));
		scrollToElement(Events.selectlocation(getData("building")));
		mouseHover(Events.selectlocation(getData("building")));
		scrollToElement(Events.selectRadioButton("date/time flexible", "Yes"));
		mouseHover(Events.selectRadioButton("date/time flexible", "Yes"));
		scrollToElement(Events.selectdropDown("Event type"));
		mouseHover(Events.selectdropDown("Event type"));
		mouseHover(Events.selectWorkshops);
		scrollToElement(Events.selectRadioButton("open to WeWork members?", "Yes"));
		mouseHover(Events.selectRadioButton("open to WeWork members?", "Yes"));
		mouseHover(Events.selectRadioButton("additional requirements", "Production"));
		// mouseHover(Events.select("Submit Enquiry"));

	}

}
