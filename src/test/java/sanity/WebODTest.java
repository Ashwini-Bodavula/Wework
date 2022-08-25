package sanity;

import static extensions.UIActions.*;
import static pageObjects.web.Daypass_OD.skipPay;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import pageObjects.web.Daypass_OD;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class WebODTest extends Daypass_OD {

	 @Test(description = "Test01 - Verify User is able to book a daypass", dataProvider = "PuneDayPassWorkspaces", groups= {"OD"})
			 //dataProvider = "MumbaiDayPassWorkspaces")
	   // @Description("This test verifies that User is able to book a daypass")
	    public void test01_OD_daypass(String city,String Location) throws InterruptedException{
		// Daypass_OD Daypass =new Daypass_OD();
	    	WebFlows.ODLogin();
	    	loadTime(8);
	    	System.out.println("Daypass city");
	    	click(Day_OD.Day_city);
	    	updateDropDown(Day_OD.Day_city, city);
	        click(Day_OD.Day_buildings);
	        updateDropDown(Day_OD.Day_buildings, Location);
	        click(Day_OD.Search);
	    	//scrollToElement(Day_OD.selectDate("25"));
	        if(Day_OD.selectDate("25").isEnabled()) {
	        	click(Day_OD.selectDate("25"));
	        }
	        else {
	        click(Day_OD.calarrow);
	    	click(Day_OD.selectDate("25"));
	        }
	    	click(Day_OD.day_continue);
//	    	if(Day_OD.day_remove.isDisplayed())
//	    	{
//	    		click(Day_OD.day_remove);
//	    	loadTime(1);
//	    	}
//	    	click(Day_OD.day_AddMember);
//	    	updateText(Day_OD.day_MemberName, getData("Name"));
//	    	updateText(Day_OD.day_MemberEmail, getData("Email"));
//	    	click(Day_OD.day_Save);
//	    	loadTime(2);
	    	scrollToElement(Day_OD.SkipPay);
		    skipPay();
	    	//click(Day_OD.SkipPay);
	    	System.out.println("clicked skip");
	    	click(Day_OD.ConfirmPayment);
	    	String currentWindow = getWindowHandel();
	    	String paymentWindow = getWindowHandels();
	        switchToParentWindow(paymentWindow);
	        loadTime(2);
	        WebFlows.proceedWithPayment();
	        UIActions.closeCurrentWindow();
	        switchToParentWindow(currentWindow);
	        Verifications.elementIsVisible(WebLoading.closeIcon);
	        click(WebLoading.closeIcon);
	    	WebFlows.ODlogout();

	    }

	 @DataProvider(name="PuneDayPassWorkspaces")
		public Object[][] puneDayPassWorkspaces()
		{
			return new Object[][] {
	//			{"Pune","Kharadi","World Trade Center"},
				{"Pune","Magarpatta Road"}
				};

		}

	/*	@DataProvider(name="HyderabadDayPassWorkspaces")
		public Object[][] hyderabadDayPassWorkspaces()
		{
			return new Object[][] {
				{"Hyderabad","Financial District","Rajapushpa Summit"},
				{"Hyderabad","Hitec City","Krishe Emerald"}
				};

		}

		@DataProvider(name="DelhiNCRDayPassWorkspaces")
		public Object[][] delhiNCRDayPassWorkspaces()
		{
			return new Object[][] {
				{"Delhi-NCR","Sector 15 Gurgaon","32nd Milestone"},
				{"Delhi-NCR","Cybercity","DLF Forum"},
				{"Delhi-NCR","Noida Sector 16","Berger Delhi One"},
				{"Delhi-NCR","Bristol Chowk","Platina Tower"},
				{"Delhi-NCR","Golf Course Road","Two Horizon Centre"},
				{"Delhi-NCR","Udyog Vihar","Blue One Square"},
				{"Delhi-NCR","Udyog Vihar","Vi-John Tower"}
				};
		}

		@DataProvider(name="BengaluruDayPassWorkspaces")
		public Object[][] bengaluruDayPassWorkspaces()
		{
			return new Object[][] {
				{"Bengaluru","Koramangala","Prestige Atlanta"},
				{"Bengaluru","Koramangala","Prestige Cube"},
				{"Bengaluru","MG Road","The Pavilion"},
				{"Bengaluru","MG Road","Galaxy"},
				{"Bengaluru","MG Road","Embassy Quest"},
				{"Bengaluru","Bannerghatta Main Rd","Salarpuria Symbiosis"},
				{"Bengaluru","Infantry Road","Prestige Central"},
				{"Bengaluru","Domlur","Sunriver, EGL"}, //Day pass not avilable
				{"Bengaluru","Domlur","Cinnabar Hills, EGL"}, //Day pass not avilable
				{"Bengaluru","Bellandur","Embassy TechVillage"},
				{"Bengaluru","Bellandur","Vaishnavi Signature"},
				{"Bengaluru","Hebbal","RMZ Latitude Commercial"},
				{"Bengaluru","Hebbal","Manyata NXT"},
				{"Bengaluru","Mahadevapura","Salarpuria Magnifica"}
				};
		}

		@DataProvider(name="MumbaiDayPassWorkspaces")
		public Object[][] mumbaiDayPassWorkspaces()
		{
			return new Object[][] {
				{"Mumbai","Nariman Point","Express Towers"},
				{"Bengaluru","Domlur","Sunriver, EGL"}, //Day pass not avilable
				{"Mumbai","Goregaon East","Oberoi Commerz II"},
				{"Mumbai","Goregaon East","NESCO IT Park"},
				{"Mumbai","Vikhroli West","247 Park"},
				{"Mumbai","Thane","Zenia"},
				{"Mumbai","Andheri East","Vijay Diamond"},
				{"Mumbai","Andheri East","Raheja Platinum"},
				{"Mumbai","Powai","Chromium"},
				{"Mumbai","Navi Mumbai","Seawoods Grand Central"},
				{"Mumbai","Malad","Spectrum Tower"},
				{"Mumbai","Worli","Vaswani Chambers"},
				{"Mumbai","BKC","Enam Sambhav"}
				};

		}*/

}
