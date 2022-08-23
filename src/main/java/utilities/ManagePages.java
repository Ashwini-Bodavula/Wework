package utilities;

import org.openqa.selenium.support.PageFactory;

import pageObjects.web.*;



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
        MyAcc= PageFactory.initElements(driver, MyAccPageOD.class);
        
        //ODE pages
        ODElogin = PageFactory.initElements(driver,LoginODE.class);
        day_ODE  = PageFactory.initElements(driver, DaypassODE.class);
        AccODE   = PageFactory.initElements(driver, MyAccPageODE.class);
    }


}