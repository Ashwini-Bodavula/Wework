package utilities;

import org.openqa.selenium.support.PageFactory;



import pageObjects.web.Bundles_OD;
import pageObjects.web.ConferenceRoomODE;
import pageObjects.web.ConferenceroomPage;
import pageObjects.web.DashboardPage;
import pageObjects.web.DayPassPage;
import pageObjects.web.DaypassODE;
import pageObjects.web.Daypass_OD;
import pageObjects.web.EnterprisePage;
import pageObjects.web.EventsPage;
import pageObjects.web.GetInTouchPage;
import pageObjects.web.HomePage;
import pageObjects.web.LoginODE;
import pageObjects.web.LoginPage;
import pageObjects.web.MyAccPage;
import pageObjects.web.LoginODPage;
import pageObjects.web.PaymentPage;
import pageObjects.web.VirtualOfficePage;
import pageObjects.web.conferenceOD;
import pageObjects.web.webLoading;


// Class Name: ManagePages
// Class Description: This class init the elements/objects of all tested applications, in all the required pages
public class ManagePages extends Base {

    public static void Wework() {
        //main page
    	WebLogin = PageFactory.initElements(driver, LoginPage.class);
        WebLoading = PageFactory.initElements(driver, webLoading.class);
        WebHome = PageFactory.initElements(driver, HomePage.class);
        VirtualOffice = PageFactory.initElements(driver, VirtualOfficePage.class);
        Payment = PageFactory.initElements(driver, PaymentPage.class);
        ConferenceRoom = PageFactory.initElements(driver, ConferenceroomPage.class);
        Events = PageFactory.initElements(driver, EventsPage.class);
        Dashboard = PageFactory.initElements(driver, DashboardPage.class);
        DayPass = PageFactory.initElements(driver, DayPassPage.class);
        GetInTouch = PageFactory.initElements(driver, GetInTouchPage.class);
        Enterprise = PageFactory.initElements(driver, EnterprisePage.class);

        //OD pages
        WebODLogin = PageFactory.initElements(driver, LoginODPage.class);
        Day_OD = PageFactory.initElements(driver, Daypass_OD.class);
        BundlesOD= PageFactory.initElements(driver, Bundles_OD.class);
        ODconference= PageFactory.initElements(driver, conferenceOD.class);
        MyAcc= PageFactory.initElements(driver, MyAccPage.class);
        
        //ODE pages
        ODElogin = PageFactory.initElements(driver,LoginODE.class);
        day_ODE =  PageFactory.initElements(driver, DaypassODE.class);
        ODEconferenceroom = PageFactory.initElements(driver, ConferenceRoomODE.class);

    }


}