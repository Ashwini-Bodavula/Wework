package workflows;

import static extensions.UIActions.click;
import static extensions.UIActions.loadTime;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ODEconfrenceroomflows extends CommonOps {
	

	 
    @Step("Login to the ODE application")
    public static void loginToODE() throws InterruptedException
    {
    	
        Verifications.elementIsVisible(ODElogin.Login);
        click(ODElogin.Login);    
        updateText(WebLogin.emailTestField, getData("Eadmin"));
        updateText(WebLogin.passwordTestField, getData("pwd"));
        click(WebLogin.submitButton);
        waitForLoad();   
    }
    
    @Step("Login to the ODE application as manager")
    public static void loginToODEmgr() throws InterruptedException
    {
    	
        Verifications.elementIsVisible(ODElogin.Login);
        click(ODElogin.Login);    
        updateText(WebLogin.emailTestField, getData("manager"));
        updateText(WebLogin.passwordTestField, getData("pwd"));
        click(WebLogin.submitButton);
        waitForLoad(); 
    }
    
    @Step("Login to the ODE application as Employee")
    public static void loginToODEemp() throws InterruptedException
    {
    	
        Verifications.elementIsVisible(ODElogin.Login);
        click(ODElogin.Login);    
        updateText(WebLogin.emailTestField, getData("emp"));
        updateText(WebLogin.passwordTestField, getData("pwd"));
        click(WebLogin.submitButton);
        waitForLoad(); 
    }

    @Step("Logout of the application")
    public static void logoutODE() throws InterruptedException
    {
    	
    	click(ODElogin.hamBurger);
	    Verifications.elementIsVisible(ODElogin.logOut);
	    click(ODElogin.logOut);
    }

   @Step("select a conferenceroom")
   public static void selection(String city, String location, String Building ) throws InterruptedException
   {
	    loadTime(5);
	   	click(ODElogin.weWorkHome);
	   	System.out.println("logged in");
	   	click(ODEconferenceroom.ConferenceRoom);
	   	click(ODEconferenceroom.city);
	   	updateDropDown(ODEconferenceroom.city, city);
	   	click(ODEconferenceroom.location);
	   	updateDropDown(ODEconferenceroom.location, location);
	   	click(ODEconferenceroom.search);
	   	click(ODEconferenceroom.date);
   }
//    @Step ("Select Number of hours for conference room")
//    public static void selectNumberOfHours(int hourse) throws InterruptedException
//		   {
//		   	    for(int i=1;i<hourse;i++)
//		   	    {
//		   	    	click(ODEconferenceroom.increaseHours);
//		   	    }
//		   	    Thread.sleep(2000);
//		   	    
//		    	String numberofhours = ODEconferenceroom.numberofhours.getText();
//		    	int hoursInt = Integer.parseInt(numberofhours);
//		    	if(hourse==hoursInt)
//		    	{
//		    		Assert.assertTrue(true, hourse+" hours selected");
//		    		
//		    	}
//		    	else
//		    	{
//		    		Assert.assertTrue(false, hourse +" hours not selected");
//		    		
//		    	}
		    	
		   

             @Step ("Select date for conference room")
           public static void selectdate(String month, String date) {
            	 while (!ODEconferenceroom.monthName.getText().contains(month))
         		{
            		  click(ODEconferenceroom.nxt_month);
            		loadTime(1);
         		}

         		 List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'MuiPickersDay')]"));
         		 int count = dates.size();
         		 for (int j = 0; j < count; j++)
         	     {
         			String currentDate = dates.get(j).getText();
         			  if (currentDate.contains(date))
         		      {
         				String attributeValue = dates.get(j).getAttribute("class");
         				  if(attributeValue.contains("dayDisabled"))
         				   {
         					System.out.println("Please select weeekdays");
         					break;
         			       }
         				   else
         			       {
         					click(dates.get(j));
         					loadTime(2);
         					break;
         			       }

         			   }
         		   }
            }
            
            	 
            	 
            	 
            	 
            	 
             }

             
	
          
		


  




   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

