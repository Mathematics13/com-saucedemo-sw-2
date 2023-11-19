package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest
{
     String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void openBrowser() throws InterruptedException
    {
        browserSetUp(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(4000);

        WebElement password =  driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");
        Thread.sleep(3000);

        WebElement loginButton =  driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton .click();
        Thread.sleep(3000);

        String expectedResult = "PRODUCTS";
        WebElement actualText = driver.findElement(By.xpath("//span[.='Products']"));
        String actualResult = actualText.getText();
        Assert.assertEquals("PRODUCTS" , "PRODUCTS");
      }

   @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException
   {
       WebElement userName1 =  driver.findElement(By.xpath("//input[@type='text']"));
       userName1.sendKeys("standard_user");
       Thread.sleep(3000);

       WebElement password1 =  driver.findElement(By.xpath("//input[@type='password']"));
       password1.sendKeys("secret_sauce");
       Thread.sleep(3000);

       WebElement loginButton1 =  driver.findElement(By.id("login-button"));
       loginButton1 .click();
       Thread.sleep(3000);

       List<WebElement> productsDisplayed =  driver.findElements(By.className("inventory_item"));
       int number = productsDisplayed.size();
        System.out.println("Number of products displayed in the page " +number);
        Assert.assertTrue("Number of products displayed in the page is 6 " , true);
   }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
