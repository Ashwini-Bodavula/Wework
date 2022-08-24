package sanity;

import static extensions.UIActions.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class WebODBundlesTest extends CommonOps {


	    @Test(description = "Test02 - Verify User is able to book a Bundles one 5 day and one 10day ", groups= {"OD"})
	    @Description("This test verifies that User is able to book a Bundles")
	    public void test02_OD_Bundles() throws InterruptedException{

	    	WebFlows.ODLogin();
	    	String currentWindow = getWindowHandel();
	    	click(BundlesOD.Bundles);
	    	click(BundlesOD.Bun_city);
	    	updateDropDown(BundlesOD.Bun_city, "Mumbai");
	        click(BundlesOD.Bun_buildings);
	        updateDropDown(BundlesOD.Bun_buildings, "Navi Mumbai");
	        click(Day_OD.Search);
	        click(BundlesOD.Bun_bulname);
	        updateDropDown(BundlesOD.Bun_bulname,"Seawoods Grand Central, Navi Mumbai");
	        loadTime(2);
	        click(BundlesOD.Proceed);
	        loadTime(2);
	        String paymentWinow = getWindowHandels();
			switchToParentWindow(paymentWinow);
			WebFlows.proceedWithPayment();			
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        Verifications.elementIsVisible(WebLoading.closeIcon);
	        click(WebLoading.closeIcon);
	        WebFlows.ODlogout();
   }

/*	    @Test(description = "Test03 - Verify User is able to book a  two 5 day Bundles", groups= {"OD"})
	    @Description("This test verifies that User is able to book a Bundles")
	    public void test03_OD_Bundles() throws InterruptedException{

	    	WebFlows.ODLogin();
	    	click(BundlesOD.Bundles);
	    	click(BundlesOD.Bun_city);
	    	updateDropDown(BundlesOD.Bun_city, "Mumbai");
	        click(BundlesOD.Bun_buildings);
	        updateDropDown(BundlesOD.Bun_buildings, "Navi Mumbai");
	        click(Day_OD.Search);
	        updateDropDown(BundlesOD.Bun_bulname,"Delhi");
	        click(BundlesOD.fivedayAdd);
	        click(BundlesOD.Proceed);

    }
	    @Test(description = "Test03 - Verify User is able to book a  two 10 day Bundles", groups= {"OD"})
	    @Description("This test verifies that User is able to book a Bundles")
	    public void test04_OD_Bundles() throws InterruptedException{

	    	WebFlows.ODLogin();
	    	click(BundlesOD.Bundles);
	    	click(BundlesOD.Bun_city);
	    	updateDropDown(BundlesOD.Bun_city, "Mumbai");
	        click(BundlesOD.Bun_buildings);
	        updateDropDown(BundlesOD.Bun_buildings, "Navi Mumbai");
	        click(Day_OD.Search);
	        updateDropDown(BundlesOD.Bun_bulname,"Delhi");
	        click(BundlesOD.TendayAdd);
	        click(BundlesOD.Proceed);
    }

	    @Test(description = "Test03 - Verify User is able to book a  two 10 day Bundles", groups= {"OD"})
	    @Description("This test verifies that User is able to book a Bundles")
	    public void test05_OD_Bundles() throws InterruptedException{

	    	WebFlows.ODLogin();;
	    	click(BundlesOD.Bundles);
	    	click(BundlesOD.Bun_city);
	    	updateDropDown(BundlesOD.Bun_city, "Mumbai");
	        click(BundlesOD.Bun_buildings);
	        updateDropDown(BundlesOD.Bun_buildings, "Navi Mumbai");
	        click(Day_OD.Search);
	        updateDropDown(BundlesOD.Bun_bulname,"Delhi");
	        int n =4;
	        for(int i=1;i>n;i++)
	        {
	        	if(n==-1)
	        		click(BundlesOD.Fivedaysub);
	        }
	        click(BundlesOD.TendayAdd);
	        click(BundlesOD.Proceed);

	    }

	    @Test(description = "Test03 - Verify User is able to book a  two 10 day Bundles", groups= {"OD"})
	    @Description("This test verifies that User is able to book a Bundles")
	    public void test06_OD_Bundles() throws InterruptedException{

	    	WebFlows.ODLogin();
	    	click(BundlesOD.Bundles);
	    	click(BundlesOD.Bun_city);
	    	updateDropDown(BundlesOD.Bun_city, "Mumbai");
	        click(BundlesOD.Bun_buildings);
	        updateDropDown(BundlesOD.Bun_buildings, "Navi Mumbai");
	        click(Day_OD.Search);
	        updateDropDown(BundlesOD.Bun_bulname,"Delhi");
	        click(BundlesOD.TendayAdd);
	        click(BundlesOD.Proceed);

	    }*/

//		 @DataProvider(name="PuneDayPassWorkspaces")
//			public Object[][] puneDayPassWorkspaces()
//			{
//				return new Object[][] {
//					{"Pune","Kharadi","World Trade Center"},
//					{"Pune","Magarpatta","Panchshil Futura"}
//					};
//
//			}
//
//			@DataProvider(name="HyderabadDayPassWorkspaces")
//			public Object[][] hyderabadDayPassWorkspaces()
//			{
//				return new Object[][] {
//					{"Hyderabad","Financial District","Rajapushpa Summit"},
//					{"Hyderabad","Hitec City","Krishe Emerald"}
//					};
//
//			}
//
//			@DataProvider(name="DelhiNCRDayPassWorkspaces")
//			public Object[][] delhiNCRDayPassWorkspaces()
//			{
//				return new Object[][] {
//					{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
//					{"Delhi-NCR","Cybercity","DLF Forum"},
//					{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
//					{"Delhi-NCR","Bristol Chowk","Platina Tower"},
//					{"Delhi-NCR","Golf Course Road","Two Horizon Centre"},
//					{"Delhi-NCR","Udyog Vihar","Blue One Square"},
//					{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
//					};
//			}
//
//			@DataProvider(name="BengaluruDayPassWorkspaces")
//			public Object[][] bengaluruDayPassWorkspaces()
//			{
//				return new Object[][] {
//					{"Bengaluru","Koramangala","Prestige Atlanta"},
//					{"Bengaluru","Koramangala","Prestige Cube"},
//					{"Bengaluru","MG Road","The Pavilion"},
//					{"Bengaluru","MG Road","Galaxy"},
//					{"Bengaluru","MG Road","Embassy Quest"},
//					{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
//					{"Bengaluru","Infantry Road","Prestige Central"},
//					{"Bengaluru","Domlur","Sunriver, EGL"}, //Day pass not avilable
//					{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //Day pass not avilable
//					{"Bengaluru","Bellandur","Embassy TechVillage"},
//					{"Bengaluru","Bellandur","Vaishnavi Signature"},
//					{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
//					{"Bengaluru","Hebbal","Manyata NXT"},
//					{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
//					};
//			}
//
//			@DataProvider(name="MumbaiDayPassWorkspaces")
//			public Object[][] mumbaiDayPassWorkspaces()
//			{
//				return new Object[][] {
//					{"Mumbai","Nariman Point","Express Towers"},
//					{"Bengaluru","Domlur","Sunriver, EGL"}, //Day pass not avilable
//					{"Mumbai","Goregaon East","Oberoi Commerz II"},
//					{"Mumbai","Goregaon East","NESCO IT Park"},
//					{"Mumbai","Vikhroli West","247 Park"},
//					{"Mumbai","Thane","Zenia"},
//					{"Mumbai","Andheri East","Vijay Diamond"},
//					{"Mumbai","Andheri East","Raheja Platinum"},
//					{"Mumbai","Powai","Chromium"},
//					{"Mumbai","Navi Mumbai","Seawoods Grand Central"},
//					{"Mumbai","Malad","Spectrum Tower"},
//					{"Mumbai","Worli","Vaswani Chambers"},
//					{"Mumbai","BKC","Enam Sambhav"}
//					};
//
//			}

}
