package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void GoogleSearchTest() {

        String searchTerm = "selenium";

        Assert.assertTrue(googlePage.isPageLoaded(), "Google.com page is not loaded.");
        SearchPage searchPage = googlePage.searchGoogle(searchTerm);

        Assert.assertTrue(searchPage.isPageLoaded(), "SearchPage page is not loaded.");
        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "Search results count on page 1 is wrong.");
        List<String> searchResultsList = searchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "SearchTerm: " + searchTerm + " not found on page 1 in: \n" + searchResult);
        }
        searchPage.toNextPage();
        Assert.assertTrue(searchPage.isPageLoaded(), "SearchPage page is not loaded.");
        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "Search results count on page 1 is wrong.");
        List<String> searchResultsList1 = searchPage.getSearchResultsList();
        for (String searchResult : searchResultsList1) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "SearchTerm: " + searchTerm + " not found on page 1 in: \n" + searchResult);
        }
    }
}
