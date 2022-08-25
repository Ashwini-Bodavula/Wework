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
public class ODEbuldaypassTest extends Daypass_OD {

		 @Test(description = "Test01 - Verify admin is able to book a daypass from building page", dataProvider = "PuneDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test01_ODE_daypassbulpune(String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Building_Daypass(location, Building);
		    //ODEflows.Daypass_Myself();
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test02 - Verify admin is able to book a daypass", dataProvider = "BengaluruDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test02_ODE_daypassBangalore(String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Building_Daypass(location, Building);
		    //ODEflows.Daypass_Myself();
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test03 - Verify admin is able to book a daypass", dataProvider = "HyderabadDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test03_ODE_daypassHyderabad(String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Building_Daypass(location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test04 - Verify admin is able to book a daypass", dataProvider = "NoidaDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test04_ODE_daypassNoida(String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
	   	    ODEflows.Building_Daypass(location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test05 - Verify admin is able to book a daypass", dataProvider = "MumbaiDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test05_ODE_daypassMumbai(String location, String Building) throws InterruptedException{
		
		    ODEflows.loginToODE();
		    ODEflows.Building_Daypass(location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	 @Test(description = "Test06 - Verify admin is able to book a daypass", dataProvider = "GurugramDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void Test06_ODE_daypassGurugram(String location, String Building) throws InterruptedException{
		
	    	ODEflows.loginToODE();
		    ODEflows.Building_Daypass(location, Building);
		    ODEflows.selectDate(getData("month"),getData("date"));
		    ODEflows.Daypass_submission();
		    ODEflows.logoutODE();
	    }
	 
	
	 
	 @DataProvider(name="PuneDayPassWorkspaces")
		public Object[][] puneDayPassWorkspaces()
		{
			return new Object[][] {
				{"Pune","Futura, Magarpatta Road"},
//				{"Pune","WTC, Tower - 5"}
				};

		}

	 @DataProvider(name="BengaluruDayPassWorkspaces")
		public Object[][] bengaluruDayPassWorkspaces()
		{
			return new Object[][] {
//				{"Bengaluru", "Prestige Atlanta, Koramangala"},
				{"Bengaluru","The Pavilion, Central Business District"},
//				{"Bengaluru","Galaxy, Central Business District"," "},
//				{"Bengaluru","Prestige Central, Central Business District"},
//				{"Bengaluru","Embassy Quest, Central Business District"},
//				{"Bengaluru","Embassy GolfLinks"},
//				{"Bengaluru","RMZ Latitude Commercial, Hebbal"},
//				{"Bengaluru","Salarpuria Magnificia, Old Madras Rd" },
////				{"Bengaluru","Vaishnavi Signature, Bellandur "},
//				{"Bengaluru","Salarpuria Symbiosis, Bannerghatta Rd"},
//				{"Bengaluru","Prestige Cube, Koramangala"},
     			{"Bengaluru","Embassy TechVillage, Bellandur"},
////				{"Bengaluru", "WeWork Manyata NXT"}
				
			};
		}
	 @DataProvider(name="HyderabadDayPassWorkspaces")
	     public Object[][] hyderabadDayPassWorkspaces()
		{
			return new Object[][] {
				{"Hyderabad","Krishe Emerald, Hitec City"},
//				{"Hyderabad","Rajapushpa Summit, Financial District"}
				};

		}

		@DataProvider(name="NoidaDayPassWorkspaces")
		public Object[][] NoidaDayPassWorkspaces()
		{
			return new Object[][] {
				{"Noida","Berger Delhi One, Sector 16B "}
				
				};
		}

		

		@DataProvider(name="MumbaiDayPassWorkspaces")
		public Object[][] mumbaiDayPassWorkspaces()
		{
			return new Object[][] {
//				{"Mumbai","Express Towers, nariman Point"},
				{"Mumbai","Oberoi Commerz II, Goregaon East"},
//				{"Mumbai","NESCO IT Park, Goregaon East"},
//				{"Mumbai","247 Park, Vikhroli West"},
//				{"Mumbai","Zenia, Thane"},
//				{"Mumbai","Vijay Diamond, Andheri East"},
//				{"Mumbai","The Masterpiece, Andheri East"},
//				{"Mumbai","K. Raheja Platinum, Andheri East"},
//				{"Mumbai","Chromium, Powai"},
//				{"Mumbai","Seawoods Grand Central, Navi Mumbai"},
//				{"Mumbai","Spectrum Tower, Malad"},
//				{"Mumbai","Vaswani Chambers, Worli"},
//				{"Mumbai","Enam Sambhav, BKC"}
				
				};

		}
		@DataProvider(name="GurugramDayPassWorkspaces")
		public Object[][] GurugramDayPassWorkspaces()
		{
			return new Object[][] {
				{"Gurugram","BlueOne Square, Udyog Vihar"},
//				{"Gurugram","Vi-John Tower, Udyog Vihar"},
//				{"Gurugram","32nd Milestone, Sector 15"},
//				{"Gurugram","Two Horizon Centre, Golf Course Road"},
//				{"Gurugram","DLF Forum, Cybercity"},
//				{"Gurugram","Platina Tower, Bristol Chowk"},
				};
		}
}
