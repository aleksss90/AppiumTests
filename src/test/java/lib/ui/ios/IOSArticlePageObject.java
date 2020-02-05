package lib.ui.ios;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://XCUIElementTypeStaticText[@name='Appium']";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='External links']";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        TITLE_TEXT_TPL = "id:{SUBSTRING}";
        OPTIONS_CONTENTS_BUTTON = "id:Table of contents";
        TITLE_FROM_CONTENTS_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        CLOSE_CONTENTS_BUTTON = "id:Close Table of contents";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}