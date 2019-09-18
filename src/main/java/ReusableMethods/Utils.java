package ReusableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.lang.ref.SoftReference;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

           //generate new email
            public String generateemail(String startValue){
                String email = startValue.concat(new Date().toString());
            return email;}

            //random date for email
             public static String randomDate()
             { DateFormat format =new SimpleDateFormat("ddMMyyHHmmss");
             return format.format(new Date());}

             //click on element
             public void clickElement(By by) {
            driver.findElement(by).click(); }

            //enter text in input field
            public void enterText(By by,String text){
                driver.findElement(by).sendKeys(text); }

            //for get text from element
            public String getTextFromElement (By by) {
            return driver.findElement(by).getText(); }

            //wait until element clickable
            public static void waitForelementClickable(By by, long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(by)); }

            //wait until element visible
            public static void waitForElementVisible(By by, long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }

            //wait for alert present
            public static void waitForAlertPresent(long time) {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent()); }

            //select value from dropdown
               public static void selectByValue(By by , String text){
                Select select = new Select(driver.findElement(by));
                select.selectByValue(text); }

                //dropdown select by index
               public static void selectByIndex(By by,int num){
                Select select = new Select(driver.findElement(by));
                select.selectByIndex(0); }

            //when dropdown present
                public static void selectByVisibleText(By by, String text){
                Select select = new Select(driver.findElement(by));
                select.selectByVisibleText(text); }

          //all option is selected
           public void getAllSelectedOptions(By by ,String text){
           Select select = new Select(driver.findElement(by));
            select.getAllSelectedOptions(); }

              //get first selected option
               public void getFirstSelectedoption(By by , String text){
              Select select = new Select(driver.findElement(by));
             select.getFirstSelectedOption();}

             //wait for element to be invisible
                public void waitForElementToBeInvisible(By by , long time){
                WebDriverWait wait = new WebDriverWait(driver ,time);
                wait.until(ExpectedConditions.invisibilityOfAllElements()); }

                //clear text
                 public void clearText(By by){
                driver.findElement(by).clear(); }

                //checking webelement display or not
                public  void checkingWebElementDisplayOrNot(By by , String text){
               driver.findElement(by).isDisplayed(); }

               //imlicity wait
                public void waitForFixTimeGivenInSeconds(By by ,long time){
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); }

              //get css property of element
                public void getCSSPropertyofElement(By by ,String text){
                driver.findElement(by).getCssValue(text); }
}