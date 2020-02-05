package lib.ui.ios;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:No results found";
        SEARCH_RESULT_BY_ID = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_BY_TITLE_OR_DESCRIPTION = "xpath://*[@class = 'android.widget.LinearLayout']//*[@text = '{TITLE_OR_DESCRIPTION}']";
        SEARCH_RESULTS_ELEMENTS = "xpath://XCUIElementTypeCollectionView//*[contains(@type,'XCUIElementTypeCell')]";
        SEARCH_CLEAR = "id:Clear text";
        SEARCH_RESULTS_LIST = "id:org.wikipedia:id/search_results_list";
    }
    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

}