package utilities;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;


public class CommonOps extends Base {

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch (Exception e){
            System.out.println("Error Reading XML File: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

 //    Method Name: beforeMethod
//    @BeforeMethod(alwaysRun = true)
//    @Parameters({"PlatformName"})
//    public void beforeMethod(String platform) {
//        if (!platform.equalsIgnoreCase("api")) {
//            try {
//                MonteScreenRecorder.startRecord(method.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    // Method Name: initBrowser

    @Step("Launch browser")
   public static void Browser(String browser){

        if (browser.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browser.equalsIgnoreCase("ie"))
            driver = initIEDriver();

        else
            throw new RuntimeException("Invalid Browser Type");
    }
    
   
    public static void URL(String URL)    {
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
     /*   if(URL.equalsIgnoreCase("OD")) {
            driver.get(getData("OD"));
           }
        
        else if(URL.equalsIgnoreCase("CO")) {
           driver.get(getData("COURL"));
           }*/
        switch(URL) {
        case "ODD":
        	driver.get(getData("ODD"));
        	break;
        case "ODS":
        	driver.get(getData("ODS"));
        	break;
        case "OD":
        	driver.get(getData("OD"));
        	break;
        case "CO":
        	driver.get(getData("CO"));
        	break;
        case "COD":
        	driver.get(getData("COD"));
        	break;
        case "COS":
        	driver.get(getData("COS"));
        	break;    
        case "ODED":
        	driver.get(getData("ODED"));
        	break;	
        case "ODES":
        	driver.get(getData("ODES"));
        	break;	
        case "ODE":
        	driver.get(getData("ODE"));
        	break;	
        case "VO":
        	driver.get(getData("VO"));
        	break;
        case "VOD":
        	driver.get(getData("VOD"));
        	break;
        case "VOS":
        	driver.get(getData("VSD"));
        	break;
        case "adminD":
        	driver.get(getData("adminD"));
        	break;
        }
        ManagePages.Wework();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        action = new Actions(driver);
    }


    @Step("Launch Chrome browser")
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
    	driver = new ChromeDriver(options);
        options.setHeadless(true);
       	options.addArguments("disable-dev-shm-usage"); 
       	options.addArguments("no-sandbox");
        options.addArguments("--disable-gpu");
//       	options.addArguments("USER AGENT");
//       	options.addArguments("window-size=1400,539");
        return driver;
    }

    // Method Name: initFireFoxDriver

    @Step("Launch Firefox browser")
    public static WebDriver initFirefoxDriver() {
       
    	WebDriverManager.firefoxdriver().setup();
    	  //	WebDriver driver = new FirefoxDriver();
    	  	FirefoxOptions options = new FirefoxOptions();
    	  	options.setHeadless(true);
    	  	WebDriver driver = new FirefoxDriver(options);
    	    return driver;
    	
    }

    // Method Name: initIEDriver

    @Step("Launch IE browser")
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @Parameters({"platformName","browser", "URL"})
    @BeforeMethod(alwaysRun = true)
	   public void startSession(String PlatformName , String browser, String url) {
	   platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
        {
        	 Browser(browser);
            URL(url);
        }
        else
            throw new RuntimeException("Invalid platform type");

    }

    // Method Name: closeSession

    @AfterClass(alwaysRun = true)
    public void closeSession()
    {
    	driver.quit();
     }


    // Method Name: afterMethod

    @AfterMethod(alwaysRun = true)
    
    public void afterMethod(){
    /*	url=URL;
        if (platform.equalsIgnoreCase("web"))
        {
        	if(URL.equalsIgnoreCase("OD")) {
        driver.get(getData("ODURL"));
    	 driver.quit();
        	}
        	else if(URL.equalsIgnoreCase("CO")) {
        		driver.get(getData("COURL"));
           	 driver.quit();
        	}

        }*/
    	driver.quit();

    }
   @Step("wait for page to load")
    public static void waitForLoad()
    {
        new WebDriverWait(driver, 60).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

/* public static void initBrowser1(String browserType) {
if (browserType.equalsIgnoreCase("chrome"))
    driver = initChromeDriver();
else if (browserType.equalsIgnoreCase("firefox"))
    driver = initFirefoxDriver();
else if (browserType.equalsIgnoreCase("ie"))
    driver = initIEDriver();

else
    throw new RuntimeException("Invalid Browser Type");

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
driver.get(getData("ODURL"));
ManagePages.Wework();
action = new Actions(driver);
}*/
// Method Name: initChromeDriver


}


