package workflows;

import static extensions.UIActions.*;

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

public class MyAccount extends CommonOps
{
	

	@Step("Dashboard view details")
	public static void dashboardViewdetails() throws InterruptedException
	{   
		String title;
		scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	title=MyAcc.pagetitle.getText();
    	Assert.assertEquals(title,"Dashboard");
    	boolean details= MyAcc.viewdetails.isDisplayed();
    	if(!details)
    	{
    		String text= driver.findElement(By.xpath("//div[contains(text(),'upcoming')]")).getText();
    		Assert.assertEquals(text, "No upcoming On demand bookings yet!");
    	}
    	else 
    	{
    	click(MyAcc.viewdetails);
    	title=MyAcc.poptitle.getText();
   		Assert.assertEquals(title,"Day pass booking");	
   		click(MyAcc.close);
    	}
    
	}
	
	@Step("Dashboard viewAll")
	public static void dashboardViewAll() throws InterruptedException
	{   String title;
		scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	title=MyAcc.pagetitle.getText();
    	Assert.assertEquals(title,"Dashboard");	
    	click(MyAcc.viewAll);
    	title=MyAcc.pagetitle.getText();
   		Assert.assertEquals(title,"Bookings");	
   		click(MyAcc.dashboard);   
	}
	
	@Step("Dashboard subscriptions")
	public static void dashboard_active() throws InterruptedException
	{   String title, text;
		scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	title=MyAcc.pagetitle.getText();
    	Assert.assertEquals(title,"Dashboard");	
    	
    	text=MyAcc.activesub.getText();
   		Assert.assertEquals(text,"No active subscriptions yet!");	
   		if(text.equals("No active subscriptions yet!"))  
   		{
   			click(MyAcc.buyNow);
   		}
   		
	}
	
	@Step("verify profile")
	public static void profile() throws InterruptedException
	{
		String title;
		click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
        click(MyAcc.profile);
        title=MyAcc.pagetitle.getText();
        Assert.assertEquals(title,"Profile");
        deleteText(MyAcc.Name);       
        updateText(MyAcc.Name, getData("Name"));
        deleteText(MyAcc.Phone);      
        updateText(MyAcc.Phone, getData("Phone"));
        deleteText(MyAcc.GSTIN);
        updateText(MyAcc.GSTIN, getData("GSTIN"));
        loadTime(3);
        scrollToElement(MyAcc.save); 
        click(MyAcc.save);     
        String msg=MyAcc.save_msg.getText();
        Assert.assertEquals(msg,"Details Updated Successfully");
        String pname= MyAcc.Name.getAttribute("value");
        Assert.assertEquals(pname,getData("Name") );
        String phone=MyAcc.Phone.getAttribute("value");
        Assert.assertEquals(phone,getData("Phone") );
        String gstin=MyAcc.GSTIN.getAttribute("value");
        Assert.assertEquals(gstin,getData("GSTIN") );        

	}
	
	@Step("verify adding team member")
	public static void add_TeamMember() throws InterruptedException
	{
		String title, email, add;
		click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	click(MyAcc.ondemand);
    	click(MyAcc.Team);
    	title=MyAcc.pagetitle.getText();
        Assert.assertEquals(title,"Team");
    	updateText(MyAcc.Name, getData("Name"));
    	String generatedString = RandomStringUtils.randomAlphabetic(10);
    	email= generatedString+"@gmail.com";    	
    	updateText(MyAcc.MemberEmail, email);
    	click(MyAcc.save);
    	loadTime(2);
       //click(MyAcc.Name);
    	Verifications.elementIsVisible(MyAcc.save_msg);
        add=MyAcc.save_msg.getText();
        Assert.assertEquals(add,"Added member successfully");
    	    	
	}
	
	@Step("verify removing team member team member")
	public static void remove_TeamMember() throws InterruptedException
	{
		String  remove;
		add_TeamMember();
        driver.navigate().refresh();
        click(MyAcc.ondemand);
    	click(MyAcc.Team);
        click(MyAcc.remove);
        remove=MyAcc.remove_msg.getText();
        Verifications.elementIsVisible(MyAcc.remove_msg);
        Assert.assertEquals(remove,"Member Deleted from the Team Successfully");           	    	
	}
	
	@Step("verify removing team member team member")
	public static void credits_Reedem() throws InterruptedException
	{
	
		String title;
		click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	click(MyAcc.ondemand);
    	click(MyAcc.Credits);
    	title=MyAcc.pagetitle.getText();
        Assert.assertEquals(title,"Credits");
        String bulding_name=MyAcc.cred_building.getText();
        click(MyAcc.Reedem);
        title=MyAcc.poptitle.getText();
        Assert.assertEquals(title, bulding_name);
        WebFlows.selectDate("October", "15");
    //    webflows.daypassBooking();
        
	}
	
	@Step("verify removing team member team member")
	public static void credits_Bundle() throws InterruptedException
	{
	
		String title;
		click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	click(MyAcc.ondemand);
    	click(MyAcc.Credits);
    	title=MyAcc.pagetitle.getText();
        Assert.assertEquals(title,"Credits");
        click(MyAcc.buyBundle);
        
	}
	
	
}
