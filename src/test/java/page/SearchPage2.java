package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage2 extends BasePage{


    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultTotal;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResultElements;

    public SearchPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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


    public boolean isPageLoaded() {
        return resultTotal.isDisplayed()
                && driver.getCurrentUrl().contains("search")
                && driver.getTitle().contains("selenium");
    }


}
