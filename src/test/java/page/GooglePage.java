package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

@FindBy (name = "q")
private WebElement searchField;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public SearchPage searchGoogle(String searchTerm){
    searchField.sendKeys(searchTerm);
    searchField.sendKeys(Keys.ENTER);
return new SearchPage(driver);
}

    public boolean isPageLoaded() {
        return searchField.isDisplayed()
                && driver.getCurrentUrl().contains("www.google.com")
                && driver.getTitle().equals("Google");
    }
}
