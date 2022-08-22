package extensions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Uninterruptibles;

import io.qameta.allure.Step;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Update Text Element As Human")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch: text.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        elem.sendKeys(value);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse Hover Element, For Two Elements")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element, For A Single Element")
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Refresh Page")
    public static void refreshPage (){
        driver.navigate().refresh();
    }

    @Step("Switch to Login Window")
    public static void switchToLoginWindow(String currentWindow)
    {
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows) {
            if(window != currentWindow){
                driver.switchTo().window(window);
            }
        }
    }

    @Step("Switch to Parent Window")
    public static void switchToParentWindow(String currentWindow) throws InterruptedException{
        driver.switchTo().window(currentWindow);
        Thread.sleep(3000);
    }


    @Step("Get Current Window Handel")
    public static String getWindowHandels() throws InterruptedException
    {
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        String parentWindow = window.next();
        String childwindow1 = window.next();
        return childwindow1;

    }


    @Step("Get Current Window Handel")
    public static String getWindowHandels2(){
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        String parentWindow = window.next();
        String childwindow1 = window.next();
        String childwindow2 = window.next();
        return childwindow2;
    }

    @Step("Get Current Window Handel")
    public static String getWindowHandel(){
        return driver.getWindowHandle();
    }

    @Step ("Get current page title")
    public static String getPageTitle(){
        return driver.getTitle();
    }

    @Step ("Get current page title")
    public static String getPageUrl(){
        return driver.getCurrentUrl();
    }

    @Step ("Scroll to Element")
    public static void scrollToElement (WebElement element) throws InterruptedException
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Verifications.elementIsVisible(element);
        Thread.sleep(2000);
    }
    @Step ("Scroll Page")
    public static void scrollPage(WebElement element, int value) throws InterruptedException
    {
    	Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("document.querySelector('div.formContainer').scrollTop=10000");
        Thread.sleep(1000);
    }

    @Step("Mouse Hover Element, For A Single Element")
    public static void doubleClick(WebElement elem1){
        action.moveToElement(elem1).doubleClick().build().perform();
    }

    @Step("Delete the tex entered in txt box")
    public static void deleteText(WebElement elem1)
    {
    	elem1.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    	elem1.sendKeys(Keys.chord(Keys.DELETE));
    }

    @Step("Delete the tex entered in txt box")
    public static void copyPasteText(WebElement elem1) throws InterruptedException
    {
    	elem1.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    	elem1.sendKeys(Keys.chord(Keys.COMMAND, "c"));
    	elem1.sendKeys(Keys.chord(Keys.DELETE));
    	elem1.sendKeys(Keys.chord(Keys.COMMAND, "v"));

    }



    @Step ("Clear text box")
    public static void clearTextBox (WebElement element) throws InterruptedException {
    	element.clear();
    }

    @Step ("Close current window")
    public static void closeCurrentWindow(){
         driver.close();
    }
    
    @Step ("Wait for page load")
    public static void waitPageLoad(int seconds){
    	driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
    	
    }
    
    @Step ("Wait for page load")
    public static void loadTime(int seconds){
    	driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    	
    }
}
