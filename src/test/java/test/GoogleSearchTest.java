package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GooglePage;
import page.SearchPage1;
import page.SearchPage2;
import page.GooglePage;

import java.util.List;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void GoogleSearchTest() {

        String searchTerm = "selenium";

        Assert.assertTrue(googlePage.isPageLoaded(), "Google.com page is not loaded.");
        SearchPage1 searchPage1 = googlePage.searchGoogle(searchTerm);

        Assert.assertTrue(searchPage1.isPageLoaded(), "SearchPage1 page is not loaded.");
        Assert.assertEquals(searchPage1.getSearchResultCount(), 9, "Search results count on page 1 is wrong.");
        List<String> searchResultsList = searchPage1.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "SearchTerm: " + searchTerm + " not found on page 1 in: \n" + searchResult);
        }
        SearchPage2 searchPage2 = searchPage1.toNextPage();
        Assert.assertTrue(searchPage2.isPageLoaded(), "SearchPage2 page is not loaded.");
        Assert.assertEquals(searchPage2.getSearchResultCount(), 10, "Search results count on page 2 is wrong.");
        List<String> searchResultsListOnPage2 = searchPage2.getSearchResultsList();
        for (String searchResult : searchResultsListOnPage2) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "SearchTerm: " + searchTerm + " not found on page 2 in: \n" + searchResult);
        }
    }
}
