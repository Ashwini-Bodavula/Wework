package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.web.WifiPage;


public class Base {
    //Abstract objects - init via CommonOps
        //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static String platform;
    protected static String url;


        //Web
    protected static WebDriver driver;

    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Page Objects - Web - init via ManagePages
    protected static pageObjects.web.LoginPage WebLogin;
    protected static pageObjects.web.webLoading WebLoading;
    protected static pageObjects.web.HomePage WebHome;
    protected static pageObjects.web.VirtualOfficePage VirtualOffice;
    protected static pageObjects.web.PaymentPage Payment;
    protected static pageObjects.web.ConferenceroomPage ConferenceRoom;
    protected static pageObjects.web.EventsPage Events;
    protected static pageObjects.web.DashboardPage Dashboard;
    protected static pageObjects.web.DayPassPage DayPass;
    protected static pageObjects.web.GetInTouchPage GetInTouch;
    protected static pageObjects.web.EnterprisePage Enterprise;
    
    //protected static pageObjects.web.EnterprisePage enterprise;
    protected static pageObjects.web.WBSPage Wbs;
    protected static pageObjects.web.ReferralsPage Referral;
    protected static pageObjects.web.CareersPage Careers;
    protected static pageObjects.web.ODAdminUsersPage ODAdminUser;
    
    

    //OD
    protected static pageObjects.web.LoginODPage WebODLogin;
    protected static pageObjects.web.Daypass_OD Day_OD;
    protected static pageObjects.web.Bundles_OD BundlesOD;
    protected static pageObjects.web.conferenceOD ODconference;
    protected static pageObjects.web.MyAccPage MyAcc;
    protected static pageObjects.web.BookingsDaypass Daypass;
    protected static pageObjects.web.WifiPage Wifi;

    

    

    //ODE
    protected static pageObjects.web.LoginODE ODElogin;
    protected static pageObjects.web.DaypassODE day_ODE; 
    protected static pageObjects.web.MyAccPageODE AccODE;
    
  
}

