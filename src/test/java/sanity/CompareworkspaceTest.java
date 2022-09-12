package sanity;

import static extensions.UIActions.click;
import static extensions.UIActions.loadTime;
import static extensions.UIActions.mouseHover;
import static extensions.UIActions.scrollToElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import utilities.CommonOps;
import workflows.ODEflows;
import workflows.WebFlows;
import workflows.workspaceflow;

@Listeners(utilities.Listeners.class)

public class CompareworkspaceTest extends CommonOps {
	
	
	@Test(description = "Test01 - Verify User is able to select workspace . (Scroll down in home page and select workspaces)",dataProvider = "Subscriptions", groups= {"CO"})
    @Description("This test verifies that User is able to select workspace . (Scroll down in home page and select workspaces)")
	
	public void test01_Selectworkspace(String subscriptiontype,String secondddinput, String thirdddinput) throws InterruptedException{
    
		
		mouseHover(Compareworkspace.workspace);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    	click(Compareworkspace.select(subscriptiontype));
    	String formtitle = Compareworkspace.formtitle.getText();
    	
	   	Thread.sleep(1000);

	   	if(subscriptiontype.equalsIgnoreCase(formtitle)) {
	   		Assert.assertTrue(true, "subscription type and formtitle are equal" );
	   	}else {
	   		
	   		Assert.assertTrue(false, "subscription type and formtitle are not equal" );
	   	}
	   	   	
	   	Thread.sleep(5000);

     String workspacetitle = Compareworkspace.name.getText();
    	
	   	Thread.sleep(1000);

    		if(formtitle.equalsIgnoreCase(workspacetitle)){
		   		Assert.assertTrue(true, "form tilte and  workspace title are equal" );
            } else {
	   		Assert.assertTrue(false, "form title and workspace title are not equal" );

            }
    		
    	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    	String title = Compareworkspace.Workspaces.getText();

		   Select locationtype1 = new Select(driver.findElement(By.xpath("//select[@class='ray-dropdown__input'][1]")));
		  
		   		   List<WebElement> type = locationtype1.getOptions();
		   		   
		   		   boolean match = false;  
		  		   for(WebElement options:type)
		   		   {
		   			   
		   				   if(options.getText().equalsIgnoreCase(subscriptiontype)) {
		   					   match = true;
		   				   }
		   			   
		   			   
		   		   }
		   		  
		   	if(match) {
		   		Assert.assertTrue(false, "is present in second dropdown" );
		   	}else {
		   		Assert.assertTrue(true, "is not present in second dropdown" );

		   	}
		   		   
		   	locationtype1.selectByVisibleText(secondddinput);
		   	
		   	Thread.sleep(1000);
		    if(type.contains("disabled"))
		    {
		    	mouseHover(Compareworkspace.closeicon);
		    }     				   	        
		   	      
		   	       //last drop down validation		
		   	       		
		   	     Select locationtype2 = new Select(driver.findElement(By.xpath("//select[@class='ray-dropdown__input'][1]")));
			
		   		   List<WebElement> alloptions = locationtype2.getOptions();		   		   
		   		  match = false;  
		   		   for(WebElement options:alloptions)
		   		   {
		   			   
		   				   if(options.getText().equalsIgnoreCase(subscriptiontype)) {
		   					   match = true;
		   				   }
		   				 
		   				   if(options.getText().equalsIgnoreCase(secondddinput)) {
		   					   match = true;
		   				   }
		   		   }
		   		  
		   	if(match) {
		   		//System.out.println(workspacetype.trim()+"is present in third dropdown ");
		   		//System.out.println(secondddinput.trim()+"is present in third dropdown ");
		   		
		   		Assert.assertTrue(false, "is present in third dropdown" );
		   		Assert.assertTrue(false, "is present in third dropdown" );
		   		
		   	}else {
		   		//System.out.println(workspacetype.trim()+" is not present in third dropdown ");
		   		//System.out.println(secondddinput.trim()+" is not present in third dropdown ");
		   		
		   		Assert.assertTrue(true, "is not present in second dropdown" );
		   		Assert.assertTrue(true, "is present in second dropdown" );
				   
		   	}
		   	
		   	Thread.sleep(1000);
		    Select locationtype3 = new Select(driver.findElement(By.xpath("//select[@class='ray-dropdown__input'][1]")));
			//System.out.println("third dropdown selection: "+thirdddinput);
			
		   	locationtype3.selectByVisibleText(thirdddinput);
		   	Thread.sleep(20);
		   
		   	String xbuttonspath = "//button[contains(text(), 'Find a Workspace')]";
		   	
			   List<WebElement> b = driver.findElements(By.xpath(xbuttonspath));
//			   System.out.println("going to wait 10second");
		   	Thread.sleep(10000);
		      for(WebElement options:b)
	   		   {
	   			   
//	   			System.out.println(""+options.getText());
	   		   }
			 	Thread.sleep(20000);
//			 	System.out.println("going to click on button");
			   	scrollToElement(b.get(1));
			   	Thread.sleep(10000);
			   b.get(1).click();
				   
				Thread.sleep(30000);

	}
		
	
	@DataProvider(name="Subscriptions")
          public Object[][] subscriptions()
         {
	     return new Object[][] {
	  {"Ready-to-move-in private offices","Conference room","Day pass"},
	    {"Hot desk","Conference room","Day pass"},
		{"All Access","Conference room","Day pass"},
		{"Office suite","Conference room","Day pass"},
		{"Virtual Office","Conference room","Day pass"},
//		
		};

}
         }
		 


    		
    	
    	
    	
