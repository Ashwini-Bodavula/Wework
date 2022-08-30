package sanity;

import static extensions.UIActions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectVirtualOfficeTest extends CommonOps
{
	@Test(description = "Test01 - Verify User is able to Select virtual office in Pune", dataProvider = "PuneVirtualOfficeWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to Select virtual office in Pune")
    public void test01_VerifySelectVirtualOfficeInPune(String city , String location, String buildingName , String workspaceLocation) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String homePageWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.VirtualOfficeOptn);
			click(WebLoading.bookNowBtn);
			loadTime(4);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);

			WebFlows.selectBuildingAndPlan(workspaceLocation, "6 Months");
			WebFlows.VirtualOfficeWorkspacePayment(workspaceLocation);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(homePageWindow);
			mouseHover(WebLoading.closeIcon);
		}
		WebFlows.logoutOfApplication();
    }

/*	@Test(description = "Test02 - Verify User is able to Select virtual office in Hyderabad", dataProvider = "HyderabadVirtualOfficeWorkspaces",groups= {"CO"})
    @Description("This test verifies that User is able to Select virtual office in Hyderabad")
    public void test02_VerifySelectVirtualOfficeInHyderabad(String city , String location, String buildingName, String workspaceLocation) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String homePageWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.VirtualOfficeOptn);
			click(WebLoading.bookNowBtn);
			loadTime(4);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			WebFlows.selectBuildingAndPlan(workspaceLocation, "6 Months");
			WebFlows.VirtualOfficeWorkspacePayment(workspaceLocation);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(homePageWindow);
			mouseHover(WebLoading.closeIcon);
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test03 - Verify User is able to Select virtual office in Delhi", dataProvider = "DelhiNCRVirtualOfficeWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select virtual office in Delhi")
    public void test03_VerifySelectVirtualOfficeInDelhi(String city , String location, String buildingName, String workspaceLocation) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String homePageWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.VirtualOfficeOptn);
			click(WebLoading.bookNowBtn);
			loadTime(4);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			WebFlows.selectBuildingAndPlan(workspaceLocation, "6 Months");
			WebFlows.VirtualOfficeWorkspacePayment(workspaceLocation);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(homePageWindow);
			mouseHover(WebLoading.closeIcon);
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test04 - Verify User is able to Select virtual office in Bengaluru", dataProvider = "BengaluruVirtualOfficeWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select virtual office in Bengaluru")
    public void test04_VerifySelectVirtualOfficeInBengaluru(String city , String location, String buildingName, String workspaceLocation) throws InterruptedException
    {
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String homePageWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.VirtualOfficeOptn);
			click(WebLoading.bookNowBtn);
			loadTime(4);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			WebFlows.selectBuildingAndPlan(workspaceLocation, "6 Months");
			WebFlows.VirtualOfficeWorkspacePayment(workspaceLocation);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(homePageWindow);
			mouseHover(WebLoading.closeIcon);
		}
		WebFlows.logoutOfApplication();
    }

	@Test(description = "Test05 - Verify User is able to Select virtual office in Mumbai", dataProvider = "MumbaiVirtualOfficeWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select virtual office in Mumbai")
    public void test05_VerifySelectVirtualOfficeInMumbai(String city , String location, String buildingName, String workspaceLocation) throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String homePageWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if (virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.VirtualOfficeOptn);
			click(WebLoading.bookNowBtn);
			loadTime(4);
			String VirtualOfficeWindow = getWindowHandels();
			switchToParentWindow(VirtualOfficeWindow);
			WebFlows.selectBuildingAndPlan(workspaceLocation, "6 Months");
			WebFlows.VirtualOfficeWorkspacePayment(workspaceLocation);
			UIActions.closeCurrentWindow();
			switchToParentWindow(VirtualOfficeWindow);
			UIActions.closeCurrentWindow();
			switchToParentWindow(homePageWindow);
			mouseHover(WebLoading.closeIcon);
		}
		WebFlows.logoutOfApplication();
	}


	@Test(description = "Test06 - Verify User is able to Select virtual office")
    @Description("This test verifies that User is able to Select virtual office")
    public void test06_VerifySelectVirtualOfficeWithoutLogginIn() throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	scrollToElement(WebLoading.cityDropdown);
        click(WebLoading.cityDropdown);
        click(WebLoading.select("Bengaluru"));
        click(WebLoading.buildingsDropdown);
        click(WebLoading.select("MG Road"));
        click(WebLoading.select("Galaxy"));
        click(WebLoading.exploreBtn);
        String currentWindow = getWindowHandel();
		scrollToElement(WebLoading.VirtualOfficeOptn);
		String virtualOfficeBtn = WebLoading.VirtualOfficeOptn.getAttribute("class");
		if(virtualOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);
			WebFlows.logoutOfApplication();
		}
		else
		{
	        scrollToElement(WebLoading.virtualOffice);
	        click(WebLoading.virtualOffice);
	        click(WebLoading.bookNowBtn);
	        switchToLoginWindow(currentWindow);
	        updateText(WebLogin.emailTestField, getData("Username"));
	        updateText(WebLogin.passwordTestField, getData("Password"));
	        click(WebLogin.submitButton);
	        switchToParentWindow(currentWindow);
	        mouseHover(WebLoading.bookNowBtn);
	        String VirtualOfficeWindow = getWindowHandels();
	        switchToParentWindow(VirtualOfficeWindow);
			click(WebLoading.select("Select Building"));
			scrollToElement(WebLoading.select("Salarpuria Magnificia, Old Madras Rd"));
			click(WebLoading.select("Salarpuria Magnificia, Old Madras Rd"));
			mouseHover(VirtualOffice.nextBtn);
	        Verifications.elementIsVisible(WebLoading.select("24 Months"));
	        if(VirtualOffice.checkoutBtn.isEnabled())
	        {
	        		click(WebLoading.select("Checkout"));
	        }
	        else
	        {
	        	click(WebLoading.select("24 Months"));
	        	mouseHover(VirtualOffice.checkoutBtn);
	        }

	        Verifications.elementIsVisible(WebLoading.select("Proceed to Payment"));
	        scrollToElement(WebLoading.select("Proceed to Payment"));
	        click(WebLoading.select("Proceed to Payment"));
	        String paymentWindow = getWindowHandels2();
	        switchToParentWindow(paymentWindow);

	        String pageTitle = UIActions.getPageTitle();
			String paymentPageTitle = "Payment - WeWork India Management Private Limited - Checkout";
			if (pageTitle.contains(paymentPageTitle))
			{
				click(Payment.changeBtn1);
			}

	        WebFlows.proceedWithPayment();
	        loadTime(2);
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(VirtualOfficeWindow);
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        click(WebLoading.closeIcon);
	        WebFlows.logoutOfApplication();
		}
    }
*/
	@DataProvider(name="PuneVirtualOfficeWorkspaces")
	public Object[][] puneVirtualOfficeWorkspaces()
	{
		return new Object[][] {
			//{"Pune","Kharadi","World Trade Center",""}, //Virtula office not available
			{"Pune","Magarpatta","Panchshil Futura","Futura, Magarpatta Road"}
			};

	}

	@DataProvider(name="HyderabadVirtualOfficeWorkspaces")
	public Object[][] hyderabadVirtualOfficeWorkspaces()
	{
		return new Object[][] {
			{"Hyderabad","Financial District","Rajapushpa Summit","Rajapushpa Summit, Financial District"},
//			{"Hyderabad","Hitec City","Krishe Emerald","Krishe Emerald, Hitec City"}
			};

	}

	@DataProvider(name="DelhiNCRVirtualOfficeWorkspaces")
	public Object[][] delhiNCRVirtualOfficeWorkspaces()
	{
		return new Object[][] {
			{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone",""},
//			{"Delhi-NCR","Bristol Chowk","Platina Tower",""},
//			{"Delhi-NCR","Cybercity","DLF Forum","DLF Forum, Cybercity"},
//			{"Delhi-NCR","Noida Sector 16","Berger Delhi One","Berger Delhi One, Sector 16B"},
//			{"Delhi-NCR","Golf Course Road","Two Horizon Centre","Two Horizon Centre, Golf Course Road"},
//			{"Delhi-NCR","Udyog Vihar","Blue One Square","BlueOne Square, Udyog Vihar"},
//			{"Delhi-NCR","Udyog Vihar","Vi-John Tower","Vi-John Tower, Udyog Vihar"}
			};
	}

	@DataProvider(name="BengaluruVirtualOfficeWorkspaces")
	public Object[][] bengaluruVirtualOfficeWorkspaces()
	{
		return new Object[][] {
			{"Bengaluru","Koramangala","Prestige Atlanta","Prestige Atlanta, Koramangala"},
//			{"Bengaluru","Koramangala","Prestige Cube","Prestige Cube, Koramangala"},
//			{"Bengaluru","MG Road","The Pavilion","The Pavilion, Church Street"},
//			{"Bengaluru","MG Road","Galaxy","Galaxy, Residency Road"},
//			{"Bengaluru","MG Road","Embassy Quest","Embassy Quest, Magrath Road"},
//			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis","Salarpuria Symbiosis, Bannerghatta Rd"},
//			{"Bengaluru","Infantry Road","Prestige Central","Prestige Central, Infantry Road"},
//			{"Bengaluru","Domlur","Sunriver, EGL",""}, //Virtual office not avilable
//			{"Bengaluru","Domlur","Cinnabar Hills, EGL","Embassy GolfLinks"}, //virtual office selection is not enabled, but loc is present in VO list
//			{"Bengaluru","Bellandur","Embassy TechVillage","Embassy TechVillage, Bellandur"},
//			{"Bengaluru","Bellandur","Vaishnavi Signature","Vaishnavi Signature, Bellandur"},
//			{"Bengaluru","Hebbal","RMZ Latitude Commercial","RMZ Latitude Commercial, Hebbal"},
//			{"Bengaluru","Hebbal","Manyata NXT","WeWork Manyata NXT"},
//			{"Bengaluru","Mahadevapura","Salarpuria Magnifica","Salarpuria Magnificia, Old Madras Rd"}
			};
	}

	@DataProvider(name="MumbaiVirtualOfficeWorkspaces")
	public Object[][] mumbaiVirtualOfficeWorkspaces()
	{
		return new Object[][] {
//			{"Mumbai","Nariman Point","Express Towers",""},//not available
			{"Mumbai","Goregaon East","Oberoi Commerz II","Oberoi Commerz II, Goregaon East"},
//			{"Mumbai","Goregaon East","NESCO IT Park","NESCO IT Park, Goregaon East"},
//			{"Mumbai","Vikhroli West","247 Park","247 Park, Vikhroli West"},
//			{"Mumbai","Thane","Zenia","Zenia, Thane"},
//			{"Mumbai","Andheri East","Vijay Diamond",""},//not available
//			{"Mumbai","Andheri East","Raheja Platinum","K. Raheja Platinum, Andheri East"},
//			{"Mumbai","Powai","Chromium","Chromium, Powai"},
//			{"Mumbai","Navi Mumbai","Seawoods Grand Central","Seawoods Grand Central, Navi Mumbai"},
//			{"Mumbai","Malad","Spectrum Tower","Spectrum Tower, Malad"},
//			{"Mumbai","Worli","Vaswani Chambers","Vaswani Chambers, Worli"},
//			{"Mumbai","BKC","Enam Sambhav","Enam Sambhav, BKC"}
			};

	}
}
