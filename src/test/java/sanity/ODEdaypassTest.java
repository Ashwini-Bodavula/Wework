package sanity;

import static extensions.UIActions.click;

import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.getWindowHandels;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.switchToParentWindow;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;
import static pageObjects.web.Daypass_OD.skipPay;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import pageObjects.web.Daypass_OD;
import utilities.CommonOps;
import workflows.ODEflows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class ODEdaypassTest extends Daypass_OD {

	 @Test(description = "Test01 - Verify admin is able to book a daypass", dataProvider = "PuneDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test01_OD_daypasspune(String city, String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		 //   ODEflows.Daypass_Myself();
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
  /*  @Test(description = "Test02 - Verify admin is able to book a daypass", dataProvider = "BengaluruDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test02_OD_daypassBangalore(String city, String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test03 - Verify admin is able to book a daypass", dataProvider = "HyderabadDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test03_OD_daypassHyderabad(String city, String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
/*	 @Test(description = "Test04 - Verify admin is able to book a daypass", dataProvider = "NoidaDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test04_OD_daypassNoida(String city, String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test05 - Verify admin is able to book a daypass", dataProvider = "MumbaiDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test05_OD_daypassMumbai(String city, String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test06 - Verify admin is able to book a daypass", dataProvider = "GurugramDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test06_OD_daypassGurugram(String city, String location, String Building) throws InterruptedException{
		
	    	ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test06 - Verify admin is able to book a daypass", dataProvider = "HyderabadDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test07_OD_daypass_multipltdates(String city, String location, String Building) throws InterruptedException{
		
	    	ODEflows.loginToODE();
		    ODEflows.selection(city, location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.selectDate(getData("month1"),getData("date1"));
		    ODEflows.selectDate(getData("month2"),getData("date2"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 */
	 @DataProvider(name="PuneDayPassWorkspaces")
		public Object[][] puneDayPassWorkspaces()
		{
			return new Object[][] {
		//		{"Pune","WTC Tower 5"},
				{"Pune","Magarpatta Road"," "}
				};

		}

	 @DataProvider(name="BengaluruDayPassWorkspaces")
		public Object[][] bengaluruDayPassWorkspaces()
		{
			return new Object[][] {
				{"Bengaluru","Central Business District","The Pavilion, Central Business District"},
//				{"Bengaluru","Central Business District","Galaxy, Central Business District"},
//				{"Bengaluru","Central Business District","Prestige Central, Central Business District"},
//				{"Bengaluru","Central Business District","Embassy Quest, Central Business District"},
//				{"Bengaluru","Domlur"," "},
//				{"Bengaluru","Hebbal","RMZ Latitude Commercial, Hebbal"},
//				{"Bengaluru","Hebbal","WeWork Manyata NXT"},
//				{"Bengaluru","Old Madras Road"," " },
				{"Bengaluru","Bannerghatta Main Rd"," "}	
			};
		}
	 @DataProvider(name="HyderabadDayPassWorkspaces")
	     public Object[][] hyderabadDayPassWorkspaces()
		{
			return new Object[][] {
			//	{"Hyderabad","Financial District"," "},
				{"Hyderabad","Hitec City"," "}
				};

		}

		@DataProvider(name="NoidaDayPassWorkspaces")
		public Object[][] delhiNCRDayPassWorkspaces()
		{
			return new Object[][] {
				{"Noida","Sector 16B"," "}
				
				};
		}

		

		@DataProvider(name="MumbaiDayPassWorkspaces")
		public Object[][] mumbaiDayPassWorkspaces()
		{
			return new Object[][] {
				{"Mumbai","Nariman Point","Express Towers"},
//				{"Mumbai","Goregaon East","Oberoi Commerz II, Goregaon East"},
//				{"Mumbai","Goregaon East","NESCO IT Park, Goregaon East"},
//				{"Mumbai","Vikhroli West"," "},
//				{"Mumbai","Thane"," "},
//				{"Mumbai","Andheri East","Vijay Diamond, Andheri East"},
//				{"Mumbai","Andheri East","The Masterpiece, Andheri East"},
//				{"Mumbai","Andheri East","K. Raheja Platinum, Andheri East"},
//				{"Mumbai","Powai"," "},
//				{"Mumbai","Navi Mumbai","Seawoods Grand Central, Navi Mumbai"},
//				{"Mumbai","Malad","Spectrum Tower"},
//				{"Mumbai","Worli"," "},
//				{"Mumbai","BKC","Enam Sambhav"},
//				{"Mumbai","WTC  Tower 5"," "}
				};

		}
		@DataProvider(name="GurugramDayPassWorkspaces")
		public Object[][] GurugramDayPassWorkspaces()
		{
			return new Object[][] {
				{"Gurugram","Udyog Vihar","BlueOne Square, Udyog Vihar"},
//				{"Gurugram","Udyog Vihar","Vi-John Tower, Udyog Vihar"},
//				{"Gurugram","Sector 15"," "},
//				{"Gurugram","Golf Course Road"," "},
//				{"Gurugram","Cybercity"," "},
				{"Gurugram","Bristol Chowk"," "},
				};
		}
}
