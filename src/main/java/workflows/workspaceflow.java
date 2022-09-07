package workflows;

import static extensions.UIActions.click;
import static extensions.UIActions.getWindowHandel;
import static extensions.UIActions.scrollToElement;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class workspaceflow extends CommonOps {
	

	 @Parameters({"URL"})
 @Step("Launch browser for main website")
   public static void loadWebsite(String URL){
     //  UIActions.Browser("chrome","CO");
       CommonOps.URL(URL);
   }

	 
	 
	 @Step("select workspace type")
	 public static void selecttype(String type) throws InterruptedException {
		 
		 String currentWindow = getWindowHandel();
	    	scrollToElement(Compareworkspace.selectworkspace);
		    Verifications.elementIsVisible(Compareworkspace.selectworkspace);
		    String typeselection = Compareworkspace.selectworkspace.getText();
		    if(typeselection.equals("select workspace type")) {
		    	
		    	click(Compareworkspace.selectworkspace);
				click(Compareworkspace.select(type));

				

		    	
		    }
		    
		    

		 
	
		 
		 
		 
		 
	 }



	 
}
