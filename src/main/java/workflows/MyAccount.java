package workflows;

import static extensions.UIActions.*;

import java.util.ArrayList;
import java.util.List;

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
	{   String title;
		scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
    	title=MyAcc.pagetitle.getText();
    	Assert.assertEquals(title,"Dashboard");	
    	
    	title=MyAcc.activesub.getText();
   		Assert.assertEquals(title,"No active subscriptions yet!");	
   		if(title.equals("No active subscriptions yet!"))  
   		{
   			click(MyAcc.buyNow);
   		}
   		scrollToElement(WebLoading.accountDropdown);
    	click(WebLoading.accountDropdown);
    	click(MyAcc.MyAccount);
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
        clearTextBox(MyAcc.Name);
        updateText(MyAcc.Name, getData("Name"));
        clearTextBox(MyAcc.Phone);
        updateText(MyAcc.Phone, getData("Phone"));
        clearTextBox(MyAcc.GSTIN);
        updateText(MyAcc.GSTIN, getData("GSTIN"));
        click(MyAcc.save);
  //    loadTime(3);
        String msg=MyAcc.save_msg.getText();
        Assert.assertEquals(msg,"Details Updated Successfully");
        click(WebODLogin.msg_close);
        String pname= MyAcc.Name.getAttribute("value");
        Assert.assertEquals(pname,getData("Name") );
        String phone=MyAcc.Phone.getAttribute("value");
        Assert.assertEquals(phone,getData("Phone") );
        String gstin=MyAcc.GSTIN.getAttribute("value");
        Assert.assertEquals(gstin,getData("GSTIN") );        

	}
}
