package browserfactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest
{
    static String browser = "Chrome";

    public static WebDriver driver;
    static String baseUrl = "https://www.saucedemo.com/";


    public void browserSetUp(String baseurl) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver= new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            driver= new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            driver= new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Safari"))
        {
            driver= new SafariDriver();
        }
        else
        {
            System.out.println("Wrong browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(4000);
    }

    public  void closeBrowser()
    {
        driver.quit();
    }
}
