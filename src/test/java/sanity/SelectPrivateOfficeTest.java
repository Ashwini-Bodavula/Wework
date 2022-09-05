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
public class SelectPrivateOfficeTest extends CommonOps
{
	@Test(description = "Test01 - Verify User is able to select private office in Pune. (Scroll down in home page and select workspaces)", dataProvider = "PunePrivateOfficeWorkspaces",groups= {"CO"})
	@Description("This test verifies that User is able to select private office in Pune. (Scroll down in home page and select workspaces)")
	public void test01_SelectPrivateOfficeInPune(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String privateOfficeBtn = WebLoading.selectWorkspace(1).getAttribute("class");
		if (privateOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.selectWorkspace(1));
			String privateOfficeSelected = WebLoading.selectWorkspace(1).getAttribute("class");
			if(privateOfficeSelected.contains("card_selected"))
			{
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

/*	@Test(description = "Test02 - Verify User is able to select private office in Hyderabad. (Scroll down in home page and select workspaces)", dataProvider = "HyderabadPrivateOfficeWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select private office in Hyderabad. (Scroll down in home page and select workspaces)")
	public void test02_SelectPrivateOfficeInHyderabad(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String privateOfficeBtn = WebLoading.selectWorkspace(1).getAttribute("class");
		if (privateOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.selectWorkspace(1));
			String privateOfficeSelected = WebLoading.selectWorkspace(1).getAttribute("class");
			if(privateOfficeSelected.contains("card_selected"))
			{
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

	@Test(description = "Test03 - Verify User is able to select private office in Delhi. (Scroll down in home page and select workspaces)", dataProvider = "DelhiNCRPrivateOfficeWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select private office in Delhi. (Scroll down in home page and select workspaces)")
	public void test03_SelectPrivateOfficeInDelhi(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String privateOfficeBtn = WebLoading.selectWorkspace(1).getAttribute("class");
		if (privateOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.selectWorkspace(1));
			String privateOfficeSelected = WebLoading.selectWorkspace(1).getAttribute("class");
			if(privateOfficeSelected.contains("card_selected"))
			{
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

	@Test(description = "Test04 - Verify User is able to select private office in Bengaluru. (Scroll down in home page and select workspaces)", dataProvider = "BengaluruPrivateOfficeWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select private office in Bengaluru. (Scroll down in home page and select workspaces)")
	public void test04_SelectPrivateOfficeInBengaluru(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String privateOfficeBtn = WebLoading.selectWorkspace(1).getAttribute("class");
		if (privateOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.selectWorkspace(1));
			String privateOfficeSelected = WebLoading.selectWorkspace(1).getAttribute("class");
			if(privateOfficeSelected.contains("card_selected"))
			{
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

	@Test(description = "Test05 - Verify User is able to select private office in Mumbai. (Scroll down in home page and select workspaces)", dataProvider = "MumbaiPrivateOfficeWorkspaces", groups= {"CO"})
	@Description("This test verifies that User is able to select private office in Mumbai. (Scroll down in home page and select workspaces)")
	public void test05_SelectPrivateOfficeInMumbai(String city, String location, String buildingName)
			throws InterruptedException
	{
		//WebFlows.loadWebsite();
		WebFlows.loginToApplication();
		WebFlows.selectWorkspace(city, location, buildingName);
		String privateOfficeBtn = WebLoading.selectWorkspace(1).getAttribute("class");
		if (privateOfficeBtn.contains("disabled"))
		{
			mouseHover(WebLoading.closeIcon);

		} else
		{
			click(WebLoading.selectWorkspace(1));
			String privateOfficeSelected = WebLoading.selectWorkspace(1).getAttribute("class");
			if(privateOfficeSelected.contains("card_selected"))
			{
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

	}*/

	@DataProvider(name = "PunePrivateOfficeWorkspaces")
	public Object[][] punePrivateOfficeWorkspaces()
	{		return new Object[][]
				{
			     { "Pune", "Kharadi", "World Trade Center" },
//				 {"Pune","Magarpatta","Panchshil Futura"}
			     };
	}

	@DataProvider(name = "HyderabadPrivateOfficeWorkspaces")
	public Object[][] hyderabadPrivateOfficeWorkspaces() {
		return new Object[][] {
				{ "Hyderabad", "Financial District", "Rajapushpa Summit" },
//				{ "Hyderabad", "Hitec City", "Krishe Emerald" }
				};

	}

	@DataProvider(name = "DelhiNCRPrivateOfficeWorkspaces")
	public Object[][] delhiNCRPrivateOfficeWorkspaces() {
		return new Object[][] {
				{ "Delhi-NCR", "Sector 15 Gurgaon", "32nd Milestone" },
//				{ "Delhi-NCR", "Cybercity", "DLF Forum" },
//				{ "Delhi-NCR", "Noida Sector 16", "Berger Delhi One" },
//				{ "Delhi-NCR", "Bristol Chowk", "Platina Tower" },
//				{ "Delhi-NCR", "Golf Course Road", "Two Horizon Centre" },
//				{ "Delhi-NCR", "Udyog Vihar", "Blue One Square" },
//				{ "Delhi-NCR", "Udyog Vihar", "Vi-John Tower" }
				};
	}

	@DataProvider(name = "BengaluruPrivateOfficeWorkspaces")
	public Object[][] bengaluruPrivateOfficeWorkspaces() {
		return new Object[][] {
				{ "Bengaluru", "Koramangala", "Prestige Atlanta" },
//				{ "Bengaluru", "Koramangala", "Prestige Cube" },
//				{ "Bengaluru", "MG Road", "The Pavilion" },
//				{ "Bengaluru", "MG Road", "Galaxy" },
//				{ "Bengaluru", "MG Road", "Embassy Quest" },
//				{ "Bengaluru", "Bannerghatta Main Rd", "Salarpuria Symbiosis" },
//				{ "Bengaluru", "Infantry Road", "Prestige Central" },
//				{ "Bengaluru", "Domlur", "Sunriver, EGL" },
//			    { "Bengaluru","Domlur","Cinnabar Hills, EGL"}, //private office not available
//				{ "Bengaluru", "Bellandur", "Embassy TechVillage" },
//				{ "Bengaluru", "Bellandur", "Vaishnavi Signature" },
//				{ "Bengaluru", "Hebbal", "RMZ Latitude Commercial" },
//				{ "Bengaluru", "Hebbal", "Manyata NXT" },
//				{ "Bengaluru", "Mahadevapura", "Salarpuria Magnifica" }
				};
	}

	@DataProvider(name = "MumbaiPrivateOfficeWorkspaces")
	public Object[][] mumbaiPrivateOfficeWorkspaces() {
		return new Object[][] {
				{ "Mumbai", "Nariman Point", "Express Towers" },
//				{ "Mumbai", "Goregaon East", "Oberoi Commerz II" },
//				{ "Mumbai", "Goregaon East", "NESCO IT Park" },
//				{ "Mumbai", "Vikhroli West", "247 Park" },
//				{ "Mumbai", "Thane", "Zenia" },
//				{ "Mumbai", "Andheri East", "Vijay Diamond" },
//				{ "Mumbai", "Andheri East", "Raheja Platinum" },
//				{ "Mumbai", "Powai", "Chromium" },
//				{ "Mumbai", "Navi Mumbai", "Seawoods Grand Central" },
//				{ "Mumbai", "Malad", "Spectrum Tower" },
//				{ "Mumbai", "Worli", "Vaswani Chambers" },
//				{ "Mumbai", "BKC", "Enam Sambhav" }
				};

	}

}
