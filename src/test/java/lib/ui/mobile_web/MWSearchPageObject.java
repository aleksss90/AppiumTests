package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button#cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        SEARCH_BY_TITLE_OR_DESCRIPTION = "xpath://*[@class = 'android.widget.LinearLayout']//*[@text = '{TITLE_OR_DESCRIPTION}']";
        SEARCH_RESULTS_ELEMENTS = "css:ul.page-list>li.page-summary";
        SEARCH_CLEAR = "css:button.clear";
        SEARCH_RESULTS_LIST = "id:org.wikipedia:id/search_results_list";
        SEARCH_RESULTTITLE = "css:a.title";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


}