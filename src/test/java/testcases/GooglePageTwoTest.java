package testcases;

import basepage.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GooglePageThree;
import pages.GooglePageTwo;
import pages.GoogleSearchResult;
import util.TestUtility;

public class GooglePageTwoTest extends BasePage {

    GoogleMainPage googlesearch;
    GoogleSearchResult result;

    GooglePageTwo pagetwo;

    GooglePageThree pageThree;

   public GooglePageTwoTest ()
   {
       super();
   }

    @BeforeMethod
    public void setup()
    {
        System.out.println("starting test");
    }
    @DataProvider
    public Object [][] getdata()
    {
        Object data [][] = TestUtility.gettestdata("data");
        return data;
    }

    @Test(priority = 1, dataProvider = "getdata")
    public void countlinksonpage (String URL, String Browser,String Word01, String Word02)
    {
        browserinitialization(URL, Browser);
        googlesearch = new GoogleMainPage();
        googlesearch.SearchinGoogle(Word01);
        googlesearch.CLear();
        result = googlesearch.SearchinGoogle(Word02);
        pagetwo = result.clickonnext();
        System.out.println( "number of pages " + pagetwo.countlinks());
    }

    @Test(priority = 2, dataProvider = "getdata")
    public void scrollandnextpage (String URL, String Browser, String Word01, String Word02)
    {
        browserinitialization(URL, Browser);
        googlesearch = new GoogleMainPage();
        googlesearch.SearchinGoogle(Word01);
        googlesearch.CLear();
        driver.manage().timeouts();
        result = googlesearch.SearchinGoogle(Word02);
        pagetwo = result.clickonnext();
        pagetwo.scrolldown();
        pageThree = pagetwo.clickonnext();

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
