package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePageThree extends BasePage {
    public GooglePageThree ()
    {
        PageFactory.initElements(driver, this);
    }

    //code to count number of pages in page 3 .
    public  int countlinkspagethree ()
    {
        List<WebElement> countpagethree = driver.findElements(By.xpath("//div[@id='rso']//div[@class='MjjYud']"));
        int totalpagethree = countpagethree.size();
        System.out.println(totalpagethree);
        return totalpagethree;
    }

}
