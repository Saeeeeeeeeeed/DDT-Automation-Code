package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePageTwo extends BasePage {

    public GooglePageTwo ()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "3")
    WebElement nextpage;

    // cde to count number of results in page 2 using dynamic xpath
    public  int countlinks ()
    {
        List<WebElement> count = driver.findElements(By.xpath("//div[@id='rso']//div[@class='MjjYud']"));
        int totalpagetwo = count.size();
        System.out.println(totalpagetwo);
        return totalpagetwo;
    }

    //code for click on next page
   public GooglePageThree clickonnext ()
   {
       nextpage.click();
       return new GooglePageThree();
   }

    //code to scroll down using javascript .
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public void scrolldown ()
    {
        jse.executeScript("arguments[0].scrollIntoView()",nextpage);
    }
}
