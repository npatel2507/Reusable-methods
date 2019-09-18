package ReusableMethods;

import javafx.scene.text.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.concurrent.TimeUnit;

public class Registration extends Utils {
    LoadProps loadProps = new LoadProps();

    @BeforeMethod
    public void openbrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //open the browser
        driver = new ChromeDriver();

        //open the website
        driver.get(loadProps.getProperty("url"));
    }
     @AfterMethod
     public void closeBrowser()
     {driver.quit();}

     @Test
     public void userShouldbeAbleToRegisterSuccessfully() {

        //click on register botton
         clickElement(By.xpath("//a[@class='ico-register']"));

         //enter first name
         enterText(By.id("FirstName"),loadProps.getProperty("Firstname"));

         //enter last name
         enterText(By.xpath("//input[@name= 'LastName']"),loadProps.getProperty("Lastname"));

         //select date of birth
         selectByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),loadProps.getProperty("Date"));

         //select month
         selectByValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),loadProps.getProperty("Month"));

         //select year
         selectByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"),loadProps.getProperty("Year"));

         //enter email
         enterText(By.name("Email"),("test"+ randomDate() +"@gmail.com"));

         //enter the password
         enterText(By.xpath("//input[@type=\"password\" and @id=\"Password\"]"),loadProps.getProperty("Password"));

         //enter confirm password
         enterText(By.name("ConfirmPassword"),loadProps.getProperty("ConfirmPassword"));

         //click on register
         clickElement(By.xpath("//input[@class=\"button-1 register-next-step-button\"]"));

         String expectedMassage = "Your registration completed";
         String actualMessage = getTextFromElement(By.className("result"));

         Assert.assertEquals(actualMessage, expectedMassage);
     }
    @Test
    public void userShouldReferAProductToAFriend(){

        //click on register botton
        clickElement(By.xpath("//a[@class='ico-register']"));

        //enter first name
        enterText(By.id("FirstName"),loadProps.getProperty("Firstname"));

        //enter last name
        enterText(By.xpath("//input[@name= 'LastName']"),loadProps.getProperty("Lastname"));

        //select date of birth
        selectByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),loadProps.getProperty("Date"));

        //select month
        selectByValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),loadProps.getProperty("Month"));

        //select year
        selectByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"),loadProps.getProperty("Year"));

        //enter email
        enterText(By.name("Email"),("test"+ randomDate() +"@gmail.com"));

        //enter the password
        enterText(By.xpath("//input[@type=\"password\" and @id=\"Password\"]"),loadProps.getProperty("Password"));

        //enter confirm password
        enterText(By.name("ConfirmPassword"),loadProps.getProperty("ConfirmPassword"));

        //click on register
        clickElement(By.xpath("//input[@class=\"button-1 register-next-step-button\"]"));

        //click on nopcommerce logo
        clickElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));

        //click on apple macbook
        clickElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]"));

        //click on email friend
        clickElement(By.xpath("//input[@value=\"Email a friend\"]"));

        //Enter friend email address
        enterText(By.id("FriendEmail"),loadProps.getProperty("FriendEmail"));

        //enter comment
        enterText(By.name("PersonalMessage"),loadProps.getProperty("PersonalMessage"));

        //click on send email friend
        clickElement(By.xpath("//input[contains(@name,'send-email')]"));

        String expectedMassage = "Your message has been sent.";
        String actualMessage = getTextFromElement(By.className("result"));

        Assert.assertEquals(actualMessage, expectedMassage);
    }
    @Test
    public void userShouldBeNevigateToCameraAndPhoto()
    {
        //click on electronics
        clickElement(By.xpath("//h2/a[@title=\"Show products in category Electronics\"]"));

        //click on camera and photos
        clickElement(By.xpath("//h2/a[@title=\"Show products in category Camera & photo\"]"));

        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.linkText("Camera & photo"));

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void userShouldBeAbleToFilterJewelryByPrice$700To$3000()
    {
        //click on jewelry
        clickElement(By.linkText("Jewelry"));

        String expectedTitle = "Jewelry";
        String actualTitle = getTextFromElement(By.linkText("Jewelry"));

        Assert.assertEquals(actualTitle, expectedTitle);

        //click on $700.00 - $3,000.00
        clickElement(By.xpath("//a[@href=\"//demo.nopcommerce.com/jewelry?price=700-3000\"]"));

        String expectedprice = "$700.00 - $3,000.00";
        String actualprice = getTextFromElement(By.xpath("//span[@class=\"item\"]"));

        Assert.assertEquals(actualprice, expectedprice);

        String Productprice = getTextFromElement(By.xpath("//span[@class=\"price actual-price\"]"));
        String price1 = String.valueOf(Productprice.replace("$",""));
        String price2 = String.valueOf(price1.replace(",",""));

        double price = Double.valueOf(price2);

        Assert.assertTrue(price>=700 && price<=3000);
    }
    @Test
    public void userShouldBeAbleToAddTwoBooksInBasket() {

        //click on books
        clickElement(By.linkText("Books"));

        //click on Fahrenheit 451 by Ray Bradbury
        clickElement(By.xpath("//img[@alt=\"Picture of Fahrenheit 451 by Ray Bradbury\"]"));

        //click on add to cart
        clickElement(By.xpath("//input[@id=\"add-to-cart-button-37\"]"));

        //click on shopping cart
        clickElement(By.xpath("//span[@class=\"cart-label\"]"));

        String expectedResult = "Fahrenheit 451 by Ray Bradbury";
        String actualResult = getTextFromElement(By.xpath("//a[@class=\"product-name\"]"));

        Assert.assertEquals(actualResult, expectedResult);

        //click on books
        clickElement(By.linkText("Books"));

        //click on First Prize Pies
        clickElement(By.linkText("First Prize Pies"));

        //click on add to cart
        clickElement(By.xpath("//input[@id=\"add-to-cart-button-38\"]"));

        //click on shopping cart
        clickElement(By.xpath("//span[@class=\"cart-label\"]"));

        String expectedResult2 = "First Prize Pies";
        String actualResult2 = getTextFromElement(By.linkText("First Prize Pies"));

        Assert.assertEquals(actualResult2, expectedResult2);
    }
}
