package pages;

import basepage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends BasePage {

    //initialize page objects
    public GoogleMainPage(){
        PageFactory.initElements(driver, this);
    }

    //Pgae Fctory :Object Repostry

    @FindBy (name = "q")
    WebElement SearchBar;

    @FindBy (xpath = "//img[@alt='Google']")
    WebElement googlelogo;


    //Actions:
    //validation on the page title
    public String ValidatePageTitle ()
    {
        return driver.getTitle();
    }


    //validation on googlepage
    public boolean validategooglepage ()
    {
        return googlelogo.isDisplayed();
    }

    //search in searchbar
    public GoogleSearchResult SearchinGoogle (String Word)
    {
        SearchBar.sendKeys(Word);
        SearchBar.sendKeys(Keys.ENTER);

        return new GoogleSearchResult();

    }

    public void CLear ()
    {
        SearchBar.clear();
    }






}
