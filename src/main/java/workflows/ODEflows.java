package workflows;

import static extensions.UIActions.click;
import static extensions.UIActions.loadTime;
import static extensions.UIActions.scrollToElement;
import static extensions.UIActions.updateDropDown;
import static extensions.UIActions.updateText;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ODEflows extends CommonOps
{
	 
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

   @Step("Booking a Daypass")
   public static void selection(String city, String location, String Building) throws InterruptedException
   {
	    loadTime(3);
	   	click(ODElogin.weWorkHome);
	   	System.out.println("logged in");
	   
	   	click(day_ODE.city);
	   	updateDropDown(day_ODE.city, city);
	   	click(day_ODE.location);
	   	updateDropDown(day_ODE.location, location);
	   	click(day_ODE.search);
	   	String popup = day_ODE.dialogue.getText();
		if(popup.contains("Select a Building")) 
		{
		   		click(day_ODE.selectBuilding(Building));
	  	}
	   	  
   }
   @Step("Daypass successfull booking")
   public static void Daypass_submission() throws InterruptedException
   {	   
	 if(day_ODE.Continue.isEnabled()) 
	   	{
		click(day_ODE.Continue);
		click(day_ODE.skipPay);
		click(day_ODE.finish);
		loadTime(30);
		String success_msg=day_ODE.msg.getText();
//		Assert.assertEquals(success_msg, "You have successfully booked a daypass at a WeWork.");
//		click(day_ODE.msg_close);
	   	}
   }
  
   @Step ("Select date in Calander UI")
   public static void selectDate(String month, String date) throws InterruptedException
   {
    	while (!day_ODE.monthName.getText().contains(month))
		{
   		  click(day_ODE.nxt_month);
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
   
   @Step("Daypass popup cancel")
   public static void Daypass_cancel() throws InterruptedException
   {
	 click(day_ODE.cancel);
	 String home=ODElogin.Homepage.getText();
	 Assert.assertEquals(home,"Tailored services to choose from" );

   }
  
   @Step("Daypass popup back")
   public static void Daypass_Back() throws InterruptedException
   {
	  if(day_ODE.Continue.isEnabled()) 
	   	{
		  click(day_ODE.Continue);
	      click(day_ODE.back);
	      String header=day_ODE.dialogue.getText();
	       if(header.contains("Day Pass"))
	          {
	        	 Daypass_cancel(); 
	          }
	 System.out.println("Back button failed");
	   	}
   }
   
   @Step("Daypass popup discard")
   public static void Daypass_discard() throws InterruptedException
   {
	   if(day_ODE.Continue.isEnabled()) 
	   	{
		  click(day_ODE.Continue);
		  click(day_ODE.skipPay);
		  click(day_ODE.discard);
		  String home=ODElogin.Homepage.getText();
		  Assert.assertEquals(home,"Tailored services to choose from" ); 
	   	}
   }
   
   @Step("Daypass by deafult Myself selected")
   public static void Daypass_Myself() throws InterruptedException
   {
	   String header=day_ODE.dialogue.getText();
       if(header.contains("Day Pass"))
          {
    	   String sel= day_ODE.mySelf.getCssValue("Color");
    	   System.out.println(sel);   	   
    	   Assert.assertEquals(sel, "rgb(0, 0, 255)");
          }          	   
   }
   
   @Step("Daypass for others selected")
   public static void Daypass_Others() throws InterruptedException
   {
	   String header=day_ODE.dialogue.getText();
       if(header.contains("Day Pass"))
          {
    	   String sel= day_ODE.others.getCssValue("Color");
       	   Assert.assertEquals(sel, "rgb(164, 164, 164)");
       	     if(sel.contains("164")) 
       	      {
       		  click(day_ODE.others); 
       	      Assert.assertEquals(sel, "rgb(0, 0, 255)");      	          	                     	        
	            if(day_ODE.Continue.isEnabled()) 
				  	{
					click(day_ODE.Continue);
					updateText(day_ODE.otherssearch, getData("emp"));
					boolean checked = day_ODE.otherssel.isSelected();
					Assert.assertEquals(checked, false);
					if(!day_ODE.otherssel.isSelected())
					{
						click(day_ODE.otherssel);
						click(day_ODE.Continue);
					}
					click(day_ODE.skipPay);
					click(day_ODE.finish);
					loadTime(7);
					String success_msg=day_ODE.msg.getText();
					Assert.assertEquals(success_msg, "You have successfully booked a daypass at a WeWork.");
					click(day_ODE.msg_close);
				   	}
       	       }
            }
     }
   
   @Step("Daypass with printing")
   public static void Daypass_printing(int count, String print) throws InterruptedException
   {
	  if(day_ODE.Continue.isEnabled()) 
	   	{
		  click(day_ODE.Continue);	    		    
		  if(count == 1)
		   {
		   	return;
		   }
            if(print=="Black") 
             { 
              for(int i=1;i<count;i++)
		      {
		     	click(day_ODE.blackPlus);
		      }	
             } 
            else if(print=="color")
             {
            	for(int i=1;i<count;i++)
  		      {
  		     	click(day_ODE.colourPlus);
  		      }	
             }	
	   	}
	  click(day_ODE.Continue);	
	  click(day_ODE.finish);
	  loadTime(5);
      String success_msg=day_ODE.msg.getText();
	  Assert.assertEquals(success_msg, "You have successfully booked a daypass at a WeWork.");
	  click(day_ODE.msg_close);
   }
   //Building flows
   @Step("Daypass in building page")
   public static void Building_Daypass(String Location, String BuildingName) throws InterruptedException
   {
	  
	   click(ODElogin.hamBurger);
	   click(day_ODE.selLoc(Location));
	   String name = day_ODE.locname.getText();
	   System.out.println(name);
	   if(Location.equalsIgnoreCase(name))
	   {
		   System.out.println("enetred location page");
	     List <WebElement> title=day_ODE.buildingname;
	     int count = title.size();
	     for(int i=0;i<count; i++)
		   {
	    	  String bulName=title.get(i).getText();
	    	  
			  if(bulName.contains(BuildingName))
			   {
				  
				  System.out.println(bulName);
				  scrollToElement(day_ODE.buildingBookbtn(i));
                  click(day_ODE.buildingBookbtn(i));
                  break;
			   }
		   }
	     String Bul_page=day_ODE.buildinginfo.getText();
 	     Assert.assertEquals(Bul_page, BuildingName);
 	     click(day_ODE.building_Daypass);
	   }	   	   
   }


	
}


	

   
 

