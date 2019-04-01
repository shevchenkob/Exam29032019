package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultTotal;

    @FindBy (xpath = "//a[@aria-label='Page 2']")
    private WebElement pageTwo;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsWisible(resultTotal, 5);
    }


    public List<String> getSearchResultsList() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchBlock : searchResultElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchBlock);
            searchResultList.add(searchBlock.getText().toLowerCase());
        }
        return searchResultList;
    }
    public int getSearchResultCount() {
        return searchResultElements.size();
    }

    public SearchPage toNextPage (){
        pageTwo.click();
        return new SearchPage(driver);
    }

    public boolean isPageLoaded() {
        return resultTotal.isDisplayed()
                && driver.getCurrentUrl().contains("search")
                && driver.getTitle().contains("selenium");
    }

}