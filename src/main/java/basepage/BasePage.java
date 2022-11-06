package basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BasePage {
   public static WebDriver driver;
   // public static EventFiringWebDriver a_driver;

   public static Properties prop;
    public BasePage (){

        //this code was for extracting data from properties file, it's not used now I was starting with it to be sure functions is working .
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void browserinitialization (String URL, String Browser)     //initializing browsers
    {



        String BrowserName = Browser;
        if (BrowserName.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if (BrowserName.equals("FF") )
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (BrowserName.equals("IE")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }



        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtility.Page_Load_Time, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtility.Implicit_Wait,TimeUnit.SECONDS);
        driver.navigate().to(URL);


    }





}
