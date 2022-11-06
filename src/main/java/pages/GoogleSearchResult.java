package pages;

import basepage.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult extends BasePage {

    public GoogleSearchResult ()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "2")
            WebElement nextpage;



    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public void scrolldown ()
    {
        jse.executeScript("arguments[0].scrollIntoView()",nextpage);
    }



    public GooglePageTwo clickonnext()
    {

        nextpage.click();

        return new GooglePageTwo();
    }


}
