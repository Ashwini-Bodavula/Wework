package sanity;

import static extensions.UIActions.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

public class WeWorkWebAppTest extends CommonOps
{
/*
	    @Test(description = "Test01 - Verify User is able to select multiple options in subscriptions",dataProvider = "PuneWorkspaces", groups= {"CO"})
	    @Description("This test verifies that User is able to select multiple options in subscriptions")
	    public void test01_selectMultipleOptionsInSubscriptions(String city, String location, String buildingName) throws InterruptedException
	    {

	    //	WebFlows.loadWebsite();
			WebFlows.loginToApplication();
			WebFlows.selectWorkspace(city, location, buildingName);
			String privateOfficeBtn = WebLoading.privateOfficeOptn.getAttribute("class");
			if (privateOfficeBtn.contains("disabled"))
			{
				mouseHover(WebLoading.closeIcon);

			} else
			{
				//selecting multiple subscriptions (private office, Hot desk and All access)
				click(WebLoading.hotDeskOptn);
				click(WebLoading.AllAccessOptn);
				click(WebLoading.privateOfficeOptn);
				String hotDeskSelected = WebLoading.hotDeskOptn.getAttribute("class");
				if(hotDeskSelected.contains("card_selected"))
				{
					Assert.assertTrue(false, "Wrong subscription selected");
				}

				String allAccessSelected = WebLoading.AllAccessOptn.getAttribute("class");
				if(allAccessSelected.contains("card_selected"))
				{
					Assert.assertTrue(false, "Wrong subscription selected");
				}

				String privateOfficeSelected = WebLoading.privateOfficeOptn.getAttribute("class");
				if(privateOfficeSelected.contains("card_selected"))
				{
					Assert.assertTrue(true, "Correct subscription selected");
					click(WebLoading.bookNowBtn);
					String subscriptionType = WebLoading.workspaceTitle.getText();
			    	if(subscriptionType.equals("Private Office"))
			    	{
			    		WebFlows.fillTheFormDetails();
			    	}
			    	else
			    	{
			    		Assert.assertTrue(false, "Subscription type mismatch");
			    	}
				}
			}
			WebFlows.logoutOfApplication();
	    }

	@Test(description = "Test02 - Verify User is able to select Multiple options in On-Demand.",dataProvider = "HyderabadWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to select Multiple options in On-Demand.")
    public void test02_SelectMultipleOptionsInOD(String city , String location, String buildingName) throws InterruptedException
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
			click(WebLoading.conferenceRoomOptn);
			click(WebLoading.dayPassBtn);
			String conferenceRoomSelected = WebLoading.conferenceRoomOptn.getAttribute("class");
			if(conferenceRoomSelected.contains("card_selected"))
			{
				Assert.assertTrue(false, "Wrong On-Demand option selected");
			}

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


	
	
	
	@Test(description = "Test03 - Verify User is able to fill WBS form.")
    @Description("This test verifies that User is able to fill WBS form.")
    public void test03_SelectWBS() throws InterruptedException
    {
		//WebFlows.loadWebsite(getData("CO"));
		WebFlows.loginToApplication();
		loadTime(2);
		WebFlows.fillWBSForm();
		WebFlows.logoutOfApplication();
    }	
	
	

@Test(description = "Test04 - Verify User is able to fill referrals form.")
    @Description("This test verifies that User is able to fill referrals form")
    public void test04_SelectRefferals() throws InterruptedException
    {
		//WebFlows.loadWebsite(getData("CO"));
	    WebFlows.loginToApplication();
		scrollToElement(WebLoading.referralsLink);
		click(WebLoading.referralsLink);
		loadTime(4);
		Thread.sleep(2000);
		scrollToElement(Referral.FAQ1);
		loadTime(4);
		Verifications.elementIsVisible(Referral.FAQ1);
		loadTime(4);
		click(Referral.FAQ1);
		scrollToElement(Referral.referralLinkInFAQ1);
		String referralLinkText = Referral.referralLinkInFAQ1.getText();
		String actualReferralLinkText = "https://wework.co.in/referrals";
		Assert.assertEquals(referralLinkText, actualReferralLinkText);
		scrollToElement(Referral.getStartedBtn);
		click(Referral.getStartedBtn);
		scrollToElement(Referral.fullName);
		updateText(Referral.fullName, getData("name"));
		updateText(Referral.Email, getData("email"));
		updateText(Referral.phoneNumber, getData("phoneNumber"));
		updateText(Referral.companyName, getData("companyName"));
		click(Referral.preferredOfficeLocationDropdwon);
		click(Referral.selectLocation("Pune"));
		click(Referral.workspaceIntrestedInDrpdwn);
		click(Referral.selectWorkspace("All Access"));
		scrollToElement(Referral.increaseNoOfDesk);
		click(Referral.addReferralBtn);
		boolean errormessageDisplayed = Referral.errorMessage.isDisplayed();
		Assert.assertTrue(errormessageDisplayed);
		click(Referral.increaseNoOfDesk);
		click(Referral.increaseNoOfDesk);
		updateText(Referral.referrerName, getData("name"));
		updateText(Referral.referrerEmail, getData("email"));
		updateText(Referral.referrerPhone, getData("phoneNumber"));
//		click(referral.addReferralBtn);
		WebFlows.logoutOfApplication();
		
    }
	
	
	@Test(description = "Test05 - Verify User is able to fill careers form.")
    @Description("This test verifies that User is able to fill careers form")
    public void test05_SelectCareers() throws InterruptedException
    {
		//WebFlows.loadWebsite(getData("CO"));
		WebFlows.loginToApplication();
		scrollToElement(WebLoading.CareersLink);
		click(WebLoading.CareersLink);
		loadTime(3);
		Thread.sleep(1000);
		waitForLoad();
		click(Careers.joinUsBtn);
		loadTime(4);
		boolean openingsBtnPresent = Careers.viewopeningsBtn.isDisplayed();
		Assert.assertTrue(openingsBtnPresent, "Button present");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://weworkindia.hire.trakstar.com/");
		driver.navigate().back();
		waitForLoad();	
		WebFlows.logoutOfApplication();
	
    }*/
	
	
	
	@Test(description = "Test06 - Verify User is able to fill careers form.")
    @Description("This test verifies that User is able to fill careers form")
    public void test06_SelectCareersFromContactUsBtn() throws InterruptedException
    {
		//WebFlows.loadWebsite(getData("CO"));
		WebFlows.loginToApplication();
		click(WebLoading.contactUsBtn);
		scrollToElement(Careers.submitButton);
		String textInSubmitBtnBfrSelectingChkBox = Careers.submitButton.getText();
		Assert.assertEquals(textInSubmitBtnBfrSelectingChkBox, "Get in touch");
		boolean nameEnabled = Careers.firstName.isEnabled();
		Assert.assertTrue(nameEnabled);
		scrollToElement(Careers.jobOportunitiescheckBox);
		mouseHover(Careers.jobOportunitiescheckBox);
		waitForLoad();
		boolean nameDisabledled = Careers.firstName.isEnabled();
		Assert.assertFalse(nameDisabledled);
		scrollToElement(Careers.submitButton);
		String textInSubmitBtnAfrSelectingChkBox = Careers.submitButton.getText();
		Assert.assertEquals(textInSubmitBtnAfrSelectingChkBox, "Explore Now");
		click(Careers.submitButton);
		waitForLoad();
		Thread.sleep(1000);
		click(Careers.joinUsBtn);
		boolean openingsBtnPresent = Careers.viewopeningsBtn.isDisplayed();
		Assert.assertTrue(openingsBtnPresent, "Button present");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://weworkindia.hire.trakstar.com/");
		driver.navigate().back();
		waitForLoad();
		WebFlows.logoutOfApplication();
		loadTime(4);
		
    }
	
	
	    @DataProvider(name = "PuneWorkspaces")
		public Object[][] puneWorkspaces()
		{		return new Object[][]
					 {
					 {"Pune","Magarpatta","Panchshil Futura"}
				     };
		}

	    @DataProvider(name="HyderabadWorkspaces")
		public Object[][] hyderabadWorkspaces()
		{
			return new Object[][] {
				{"Hyderabad","Financial District","Rajapushpa Summit"},
				{"Hyderabad","Hitec City","Krishe Emerald"}

				};

		}

}
