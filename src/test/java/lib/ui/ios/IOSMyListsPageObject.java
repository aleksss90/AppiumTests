package lib.ui.ios;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
        FOLDER_BY_IMAGE_ID = "id:org.wikipedia:id/item_image_1";
        ARTICLE_BY_ID = "id:org.wikipedia:id/page_list_item_title";
        CLICK_ARTICLE_MY_LIST = "id:org.wikipedia:id/page_list_item_container";
        CLOSE_SYNC_POP_UP = "id:Close";
    }

    public IOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}