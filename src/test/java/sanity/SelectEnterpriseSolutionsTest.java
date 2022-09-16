package sanity;

import static extensions.UIActions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SelectEnterpriseSolutionsTest extends CommonOps
{


	@Test(description = "Test01 - Verify User is able to Select Enterprise in Pune(Day pass option)",dataProvider = "PuneWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select Enterprise in Pune(Day pass option)")
    public void test01_SelectEnterpriseDayPassInPune(String city , String location, String noOfPeople) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	WebFlows.selectLocationForEnterprise(city, location, noOfPeople);
    	click(Enterprise.dayPassForTeam);
    	loadTime(3);
    	if(Enterprise.dayPassForTeam.getAttribute("class").contains("card_selected"))
    	{
    		WebFlows.fillEnterpriseFormDetails();
    	}
        click(Enterprise.closeBtn);
        WebFlows.logoutOfApplication();

    }

/*	@Test(description = "Test02 - Verify User is able to Select Enterprise in Pune(Private Office option)",dataProvider = "PuneWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select Enterprise in Pune(Private Office option)")
    public void test02_SelectEnterprisePrivateOfficeInPune(String city , String location, String noOfPeople) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	WebFlows.selectLocationForEnterprise(city, location, noOfPeople);
    	click(Enterprise.readyToMoveInrivateOffice);
    	loadTime(3);
    	if(Enterprise.readyToMoveInrivateOffice.getAttribute("class").contains("card_selected"))
    	{
    		WebFlows.fillEnterpriseFormDetails();
    	}
        click(Enterprise.closeBtn);
        WebFlows.logoutOfApplication();

    }

	@Test(description = "Test03 - Verify User is able to Select Enterprise in Pune(All access for Team option)",dataProvider = "PuneWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select Enterprise in Pune(All access for Team option)")
    public void test03_SelectEnterpriseAllAccessForTeamInPune(String city , String location, String noOfPeople) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	WebFlows.selectLocationForEnterprise(city, location, noOfPeople);
    	click(Enterprise.allAccessForTeam);
    	loadTime(3);
    	if(Enterprise.allAccessForTeam.getAttribute("class").contains("card_selected"))
    	{
    		WebFlows.fillEnterpriseFormDetails();
    	}
        click(Enterprise.closeBtn);
        WebFlows.logoutOfApplication();

    }

	@Test(description = "Test04 - Verify User is able to Select Enterprise in Pune(Managed Offices option)",dataProvider = "PuneWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select Enterprise in Pune(Managed Offices option)")
    public void test04_SelectEnterpriseManagedOfficeInPune(String city , String location, String noOfPeople) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	WebFlows.selectLocationForEnterprise(city, location, noOfPeople);
    	click(Enterprise.managedOffices);
    	loadTime(3);
    	if(Enterprise.managedOffices.getAttribute("class").contains("card_selected"))
    	{
    		WebFlows.fillEnterpriseFormDetails();
    	}
        click(Enterprise.closeBtn);
        WebFlows.logoutOfApplication();

    }

	@Test(description = "Test05 - Verify User is able to Select Enterprise in Pune(Custom Built spaces option)",dataProvider = "PuneWorkspaces", groups= {"CO"})
    @Description("This test verifies that User is able to Select Enterprise in Pune(Custom Built spaces option)")
    public void test05_SelectEnterpriseCustomBuiltSpacesInPune(String city , String location, String noOfPeople) throws InterruptedException
    {
		//WebFlows.loadWebsite();
    	WebFlows.loginToApplication();
    	WebFlows.selectLocationForEnterprise(city, location, noOfPeople);
    	click(Enterprise.customBuiltSpaces);
    	loadTime(3);
    	if(Enterprise.customBuiltSpaces.getAttribute("class").contains("card_selected"))
    	{
    		WebFlows.fillEnterpriseFormDetails();
    	}
        click(Enterprise.closeBtn);
        WebFlows.logoutOfApplication();

    }*/

	@DataProvider(name="PuneWorkspaces")
	public Object[][] puneWorkspaces()
	{
		return new Object[][] {
			{"Pune","Kharadi","20-50"},
			//{"Pune","Magarpatta"}
			};
	}

	@DataProvider(name="HyderabadWorkspaces")
	public Object[][] hyderabadWorkspaces()
	{
		return new Object[][] {
			{"Hyderabad","Financial District"},
			{"Hyderabad","Hitec City"}
			};
	}

	@DataProvider(name="DelhiNCRWorkspaces")
	public Object[][] delhiNCRWorkspaces()
	{
		return new Object[][] {
			{"Delhi-NCR","Sector 15 Gurgaon"},
//			{"Delhi-NCR","Cybercity"},
//			{"Delhi-NCR","Noida Sector 160"},
//			{"Delhi-NCR","Bristol Chowk"},
//			{"Delhi-NCR","Golf Course Road"},
//			{"Delhi-NCR","Udyog Vihar"}
			};
	}

	@DataProvider(name="BengaluruWorkspaces")
	public Object[][] bengaluruWorkspaces()
	{
		return new Object[][] {
			{"Bengaluru","Koramangala"},
//			{"Bengaluru","MG Road"},
//			{"Bengaluru","Bannerghatta Main Rd"},
//			{"Bengaluru","Infantry Road"},
//			{"Bengaluru","Domlur"},
//			{"Bengaluru","Bellandur"},
//			{"Bengaluru","Hebbal"},
			{"Bengaluru","Mahadevapura"}
			};
	}

	@DataProvider(name="MumbaiWorkspaces")
	public Object[][] mumbaiWorkspaces()
	{
		return new Object[][] {
			{"Mumbai","Nariman Point"},
//			{"Mumbai","Goregaon East"},
//			{"Mumbai","Vikhroli West"},
//			{"Mumbai","Thane"},
//			{"Mumbai","Andheri East"},
//			{"Mumbai","Powai"},
//			{"Mumbai","Navi Mumbai"},
//			{"Mumbai","Malad"},
//			{"Mumbai","Worli"},
			{"Mumbai","BKC"}
		};
	}


}
