package lib.ui.android;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        FOLDER_BY_IMAGE_ID = "id:org.wikipedia:id/item_image_1";
        ARTICLE_BY_ID = "id:org.wikipedia:id/page_list_item_title";
        CLICK_ARTICLE_MY_LIST = "id:org.wikipedia:id/page_list_item_container";
    }
    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}