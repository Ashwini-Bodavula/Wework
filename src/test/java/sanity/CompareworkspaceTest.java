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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import extensions.Verifications;
import io.qameta.allure.Description;
import utilities.CommonOps;
import workflows.WebFlows;
import workflows.workspaceflow;

@Listeners(utilities.Listeners.class)

public class CompareworkspaceTest extends CommonOps {
	
	
	@Test(description = "Test01 - Verify User is able to select workspace . (Scroll down in home page and select workspaces)",dataProvider = "Subscriptions", groups= {"CO"})
    @Description("This test verifies that User is able to select workspace . (Scroll down in home page and select workspaces)")
	
	public void test01_Selectworkspace(String workspacetype ) throws InterruptedException
    {
		
		mouseHover(Compareworkspace.workspace);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	click(Compareworkspace.select(workspacetype));
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	String title = Compareworkspace.Workspaces.getText();
		   System.out.println(title);
		   
		   Select select = new Select(driver.findElement(By.xpath("//select[@class='ray-dropdown__input'][1]")));
		  
		   		   List<WebElement> type = select.getOptions();
		   		   
		   	        for(WebElement options: type)
		   	        	if(options.getText().equals("Conference room"))
		   	        	{
		   	        		options.click();
		   	        		break;
		   	        	}
		   	        		if(type.contains("disabled")) {
		   	        			
		   	        			mouseHover(Compareworkspace.closeicon);
		   	        		}		   	        
		   	        			
		   	     Select locationtype = new Select(driver.findElement(By.xpath("//select[@class='ray-dropdown__input'][1]")));
				  
		   		   List<WebElement> alloptions = locationtype.getOptions();
		   		   
		   	        for(WebElement option: alloptions)
		   	        	if(option.getText().equals("Day pass"))
		   	        	{
		   	        		option.click();
		   	        		break;
		   	        	}
		   	        		if(type.contains("disabled"))
		   	        		{
		   	        			
		   	        			mouseHover(Compareworkspace.closeicon);
		   	        		}
		   	        		
		   	        	 else
		   	    		{
		   	    			
		   	        		scrollToElement(Compareworkspace.findworkspace);
		   	    		}	
		   	        
		           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 	            	
	            	click(Compareworkspace.findworkspace);
		   	        	
		        		
}

	
	
	
	
	
	
         @DataProvider(name="Subscriptions")
          public Object[][] subscriptions()
         {
	     return new Object[][] {
		{"Ready-to-move-in private offices"},
		{"Hot desk"},
		{"All Access"},
		{"Office suite"},
		{"Virtual Office"},
		{"WeWork Labs"}
		};

}
         }
		 


    		
    	
    	
    	
