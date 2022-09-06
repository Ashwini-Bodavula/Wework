package workflows;

import static extensions.UIActions.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.maven.plugins.annotations.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import extensions.UIActions;
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
	//	Assert.assertEquals(success_msg, "You have successfully booked a daypass at a WeWork.");
		click(day_ODE.msg_close);
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
   
 //My Accounts
   @Step("Daypass myaccount page")
   public static void Enterprise_confirmed(String status, String update, String update1) throws InterruptedException
   {
	  String Alertmsg ;
	  loadTime(5);
	  click(ODElogin.weWorkHome);
	  click(ODElogin.hamBurger);
	  click(AccODE.MyAccount);
//	  click(AccODE.Enterprise);
	  Verifications.verifyTextInElement(AccODE.Enterprise_Heading,"Enterprise Wide Bookings"); 
	  if(status.equals("CONFIRMED"))
	   {
		  String stat=AccODE.orderType.getAttribute("value");
		  Assert.assertEquals(stat, "completed");
		  String row1=AccODE.bookingTable.getText();
		  click(AccODE.status(status));
		  boolean value=AccODE.updatestatus(update).isEnabled();
		   if(value)
		   {
		     if(update.equalsIgnoreCase("Cancel"))
		     { 	
			   click(AccODE.updatestatus(update));
			   if(update1.equalsIgnoreCase("cancel All"))
			   {
				 click(AccODE.updatestatus(update1));
				 loadTime(5);
				 Alertmsg = AccODE.msg.getText();
				 Assert.assertEquals(Alertmsg, "Order Cancelled Successfully");
				 click(day_ODE.msg_close);
			     
	     	   }
			   else if(update1.equalsIgnoreCase("Done"))
			   {
				  List <WebElement> orders=driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-4']"));
				  int count= orders.size();
				  if(count==1)
				  {
					  click(AccODE.updatestatus("Cancel All")); 
					  Alertmsg = AccODE.msg.getText();
					  Assert.assertEquals(Alertmsg, "Order Cancelled Successfully");
				  }
				  else
				  {
					  System.out.println(count);
					  for(int i=1;i<count;i++) 
					  {
					   click(AccODE.delete);
					   loadTime(1);
					   
					  }
					  click(AccODE.updatestatus("Done"));
					  loadTime(2);
					  Alertmsg = AccODE.msg.getText();
					  Assert.assertEquals(Alertmsg, "Order Modified Successfully, please refresh page after 20s to see the changes");
				  }		
				 
				  click(day_ODE.msg_close);
 	    	   }
			   else
			    {
				   click(AccODE.updatestatus("Back"));
				   String page=AccODE.order.getText();
				  // page.contains("Order");
				   Verifications.verifycontains(page,"Order");
			    }			   			   
		   }
		  } 
	   }
   }
 
   public static void Enterprise_Rescheduled(String status, String update, String update1) throws InterruptedException
   {
	  String Alertmsg ;
	  loadTime(5);
	  click(ODElogin.weWorkHome);
	  click(ODElogin.hamBurger);
	  click(AccODE.MyAccount);
//	  click(AccODE.Enterprise);
	  Verifications.verifyTextInElement(AccODE.Enterprise_Heading,"Enterprise Wide Bookings"); 
	  if(status.equals("CONFIRMED"))
	   {
		  String stat=AccODE.orderType.getAttribute("value");
		  Assert.assertEquals(stat, "completed");
		  String row1=AccODE.bookingTable.getText();
		  click(AccODE.status(status));
		  boolean value=AccODE.updatestatus(update).isEnabled();
		   if(value)
		   {
		     if(update.equalsIgnoreCase("Reschedule"))
		     { 	
			   click(AccODE.updatestatus(update));
			   List <WebElement> orders=driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-md-4']"));
				  int count= orders.size();
		     }
		  } 
	   }
   }
   public static void Enterprise_pending(String status, String update) throws InterruptedException
   {
	   String Alertmsg ;
	   loadTime(5);
	 
   	  click(AccODE.Enterprise);
	  Verifications.verifyTextInElement(AccODE.Enterprise_Heading,"Enterprise Wide Bookings"); 
	  if(status.equals("PENDING"))
	   {
		  click(AccODE.orderType);
		  updateDropDown(AccODE.orderType,"Pending");
		  String stat=AccODE.orderType.getText();
		  Assert.assertEquals(stat, "pending");
		 // String row1=AccODE.bookingTable.getText();
		  click(AccODE.status(status));
		 
		   if(update.equalsIgnoreCase("Approve"))
		   { 	
			   click(AccODE.updatestatus(update));
			   Alertmsg = AccODE.msg.getText();
			   Assert.assertEquals(Alertmsg, "Order Approved Successfully");
			   click(day_ODE.msg_close);
		   } 
		   if(update.equalsIgnoreCase("Rejected"))
		   { 	
			   click(AccODE.updatestatus(update));
			   Alertmsg = AccODE.msg.getText();
			   Assert.assertEquals(Alertmsg, "Order Rejected Successfully");
			   click(day_ODE.msg_close);
		   }
	       if(update.equalsIgnoreCase("cancel All"))
			{
				 click(AccODE.updatestatus(update));
				 Alertmsg = AccODE.msg.getText();
				 Assert.assertEquals(Alertmsg, "Order Cancelled Successfully");
				 click(day_ODE.msg_close);			     
	     	} 	    	   		  			   			   		   		  
     }
   }
   
   @Step("verify profile")
   public static void ODE_profile() throws InterruptedException
   {
     //  	click(AccODE.MyAccount);
           click(AccODE.profile);
           Boolean email=MyAcc.Email.isEnabled();
           Assert.assertEquals(false, false);
           //String name = "test";
           clearTextBox(AccODE.Name);
           updateText(AccODE.Name, getData("Name"));
           clearTextBox(AccODE.Phone);
           updateText(AccODE.Phone, getData("Phone"));
           click(MyAcc.save);
           loadTime(3);          
           String msg=MyAcc.save_msg.getText();
           Assert.assertEquals(msg,"User updated");
           click(WebODLogin.msg_close);
           String pname= MyAcc.Name.getAttribute("value");
           Assert.assertEquals(pname, "tester");
           String phone=MyAcc.Phone.getAttribute("value");
           Assert.assertEquals(phone, "8905641237");
           
   	
   }
   
   @Step("verify support")
   public static void ODE_support() throws InterruptedException
   {
          // click(AccODE.MyAccount);
           click(AccODE.Support);
           String sup;           
           sup=AccODE.supQueries.getText();
           Assert.assertEquals(sup, "Reach out to us for any queries on support.ondemand@wework.co.in");
   	 
    }
   
   @Step("Adding employee")
   public static void ODE_AddEmployee() throws InterruptedException
   {
	   click(AccODE.Employees);
	   click(AccODE.addEmp);
	   String generatedString = RandomStringUtils.randomAlphabetic(10);
       updateText(AccODE.Name, generatedString );
       updateText(AccODE.Phone, getData("Phone"));
	   updateText(AccODE.emp_Id,getData("empID"));
	   updateDropDown(AccODE.emp_Role,"Manager");
	   updateText(AccODE.emp_Mgr,getData("manager"));	
	   String msg=MyAcc.save_msg.getText();
       Assert.assertEquals(msg,"Email Added");
       click(day_ODE.msg_close);
	   
   }
 
   @Step("search employee")
   public static void ODE_searchEmployee() throws InterruptedException
   {
	   click(AccODE.Employees);
	   updateText(AccODE.searchemp, getData("emp"));
	   String emptable=AccODE.emp_table.getText();
	   if(emptable.contains(getData("emp"))) 
	   {
		   System.out.println("search worked");
	   }
	   else
		   System.out.println("search failed");	   
   }
   
   @Step("Edit employee")
   public static void ODE_editEmployee() throws InterruptedException
   {
	   click(AccODE.Employees);
	   String emptable=AccODE.emp_table.getText();
	   if(emptable.contains("abc")) 
	   {
		   click(AccODE.emp_edit);
		   clearTextBox(AccODE.Name);
		   String name = RandomStringUtils.randomAlphabetic(10);
           updateText(AccODE.Name, name);
           clearTextBox(AccODE.Phone);
           updateText(AccODE.Phone, getData("Phone"));
           click(MyAcc.save);
		   String msg1=AccODE.msg.getText();
		   Assert.assertEquals(msg1, "Employee Updated");	
		   click(day_ODE.msg_close);
	   }
	 	   
   }
   
 }

