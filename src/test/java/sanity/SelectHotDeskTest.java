package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.mouseHover;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class SelectHotDeskTest extends CommonOps
{
	@Test(description = "Test01 - Verify User is able to select Hotdesk in Pune. (Scroll down in home page and select workspaces)", dataProvider = "PuneHotdeskWorkspaces",groups= {"CO"})
	@Description("This test verifies that User is able to select Hotdesk in Pune. (Scroll down in home page and select workspaces)")
	public void test01_SelectHotdeskInPune(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String hotdeskOptnBtn = WebLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.hotDeskOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = WebLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
	    		WebFlows.fillTheFormDetails();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
		}
		WebFlows.logoutOfApplication();
	}

/*	@Test(description = "Test02 - Verify User is able to select Hotdesk in Hyderabad. (Scroll down in home page and select workspaces)", dataProvider = "HyderabadHotdeskWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select Hotdesk in Hyderabad. (Scroll down in home page and select workspaces)")
	public void test02_SelectHotdeskInHyderabad(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String hotdeskOptnBtn = WebLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.hotDeskOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = WebLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
	    		WebFlows.fillTheFormDetails();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
		}
		WebFlows.logoutOfApplication();
	}

	@Test(description = "Test03 - Verify User is able to select Hotdesk in Delhi-NCR. (Scroll down in home page and select workspaces)", dataProvider = "DelhiNCRHotdeskWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select Hotdesk in Delhi-NCR. (Scroll down in home page and select workspaces)")
	public void test03_SelectHotdeskInDelhiNCR(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String hotdeskOptnBtn = WebLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.hotDeskOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = WebLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
	    		WebFlows.fillTheFormDetails();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
		}
		WebFlows.logoutOfApplication();
	}

	@Test(description = "Test04 - Verify User is able to select Hotdesk in Bengaluru. (Scroll down in home page and select workspaces)", dataProvider = "BengaluruHotdeskWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select Hotdesk in Bengaluru. (Scroll down in home page and select workspaces)")
	public void test04_SelectHotdeskInBengaluru(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String hotdeskOptnBtn = WebLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.hotDeskOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = WebLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
	    		WebFlows.fillTheFormDetails();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
		}
		WebFlows.logoutOfApplication();
	}

	@Test(description = "Test05 - Verify User is able to select Hotdesk in Mumbai. (Scroll down in home page and select workspaces)", dataProvider = "MumbaiHotdeskWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select Hotdesk in Mumbai. (Scroll down in home page and select workspaces)")
	public void test05_SelectHotdeskInMumbai(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String hotdeskOptnBtn = WebLoading.hotDeskOptn.getAttribute("class");
		if (hotdeskOptnBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.hotDeskOptn);
			click(WebLoading.bookNowBtn);
			String subscriptionType = WebLoading.workspaceTitle.getText();
	    	if(subscriptionType.equals("Hot Desk"))
	    	{
	    		WebFlows.fillTheFormDetails();
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false, "Subscription type mismatch");
	    	}
		}
		WebFlows.logoutOfApplication();
	}
*/
	@DataProvider(name="PuneHotdeskWorkspaces")
	public Object[][] puneHotdeskWorkspaces()
	{
		return new Object[][] {
			{"Pune","Kharadi","World Trade Center"},
//			{"Pune","Magarpatta","Panchshil Futura"}
			};

	}

	@DataProvider(name="HyderabadHotdeskWorkspaces")
	public Object[][] hyderabadHotdeskWorkspaces()
	{
		return new Object[][] {
			{"Hyderabad","Financial District","Rajapushpa Summit"},
//			{"Hyderabad","Hitec City","Krishe Emerald"}
			};

	}

	@DataProvider(name="DelhiNCRHotdeskWorkspaces")
	public Object[][] delhiNCRHotdeskWorkspaces()
	{
		return new Object[][] {
			{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
//			{"Delhi-NCR","Cybercity","DLF Forum"},
//			{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
//			{"Delhi-NCR","Bristol Chowk","Platina Tower"},
//			{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
			};
	}

	@DataProvider(name="BengaluruHotdeskWorkspaces")
	public Object[][] bengaluruHotdeskWorkspaces()
	{
		return new Object[][] {
			{"Bengaluru","Koramangala","Prestige Atlanta"},
//			{"Bengaluru","Koramangala","Prestige Cube"},
//			{"Bengaluru","MG Road","The Pavilion"},
//			{"Bengaluru","MG Road","Galaxy"},
//			{"Bengaluru","MG Road","Embassy Quest"},
//			{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
//			{"Bengaluru","Infantry Road","Prestige Central"},
//			{"Bengaluru","Domlur","Sunriver, EGL"}, //hotdesk not available
//			{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //hotdesk not available
//			{"Bengaluru","Bellandur","Embassy TechVillage"},
//			{"Bengaluru","Bellandur","Vaishnavi Signature"},
//			{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
//			{"Bengaluru","Hebbal","Manyata NXT"},
//			{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
			};
	}

	@DataProvider(name="MumbaiHotdeskWorkspaces")
	public Object[][] mumbaiHotdeskWorkspaces()
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
