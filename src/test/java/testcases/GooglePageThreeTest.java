package testcases;

import basepage.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GooglePageThree;
import pages.GooglePageTwo;
import pages.GoogleSearchResult;
import util.TestUtility;

public class GooglePageThreeTest extends BasePage {

    GoogleMainPage googlesearch;
    GoogleSearchResult result;

    GooglePageTwo pagetwo;

    GooglePageThree pageThree;

    public GooglePageThreeTest ()
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

    @Test (dataProvider = "getdata")
    public void pagenumbervalidation (String URL, String Browser,String Word01, String Word02)
    {
        browserinitialization(URL, Browser);
        googlesearch = new GoogleMainPage();
        googlesearch.SearchinGoogle(Word01);
        googlesearch.CLear();
        result = googlesearch.SearchinGoogle(Word02);
        pagetwo = result.clickonnext();
        pageThree = pagetwo.clickonnext();

        //this line indicates if the number of results are equal in two pages if they are not code will send error message and assertion will direct you to the issue
        Assert.assertEquals(pagetwo.countlinks(),pageThree.countlinkspagethree(),"numbers are not equal");

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();

    }



}
