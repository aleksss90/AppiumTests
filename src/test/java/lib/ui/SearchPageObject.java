package lib.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;


abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_RESULT_BY_ID,
            SEARCH_BY_TITLE_OR_DESCRIPTION,
            SEARCH_RESULTS_ELEMENTS,
            SEARCH_CLEAR,
            SEARCH_RESULTS_LIST,
            OPTIONS_CHANGE_LANGUAGE,
            SEARCH_RESULTTITLE;


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getTitleAndDescription(String title_or_description) {
        return SEARCH_BY_TITLE_OR_DESCRIPTION.replace("{TITLE_OR_DESCRIPTION}", title_or_description);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INPUT, "Cannot find search input after clicking search init element");
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }


    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }



    public void waitForElementByTitleAndDescription(String title, String description) {
        String article_title = getTitleAndDescription(title);
        this.waitForElementPresent(article_title, "Cannot find article title", 10);
        String article_description = getTitleAndDescription(description);
        this.waitForElementPresent(article_description, "Cannot find article description", 10);
    }

    public List<WebElement> waitForAllResultsPresent(String error_message)
    {
        return this.waitForElementsPresent(SEARCH_RESULTS_ELEMENTS, error_message, 15);
    }

    public void searchClearIOS()
    {
        this.waitForElementAndClick(SEARCH_CLEAR, "Cannot find ios search clear 'x' button", 5);
    }

}