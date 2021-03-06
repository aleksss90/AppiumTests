package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            TITLE_ON_LIST,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTION_REMOVE_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            FOLDER_XPATH_TMP,
            TITLE_XPATH_TMP,
            MY_LISTS,
            MY_CREATED_LISTS,
            TITLE_TEXT_TPL,
            OPTIONS_CONTENTS_BUTTON,
            TITLE_FROM_CONTENTS_TPL,
            CLOSE_CONTENTS_BUTTON,
            FIRST_WORD_ON_TITLE,
            OPTIONS_CHANGE_LANGUAGE_BUTTON,
            SHARE_LINK_BUTTON,
            FIND_IN_PAGE_BUTTON,
            FONT_AND_THEME_BUTTON,
            EXISTING_LIST_LINK_TPL;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getTitleXpath(String substring) {
        return TITLE_XPATH_TMP.replace("{TITLE}", substring);
    }

    private static String getTitleElement(String substring) {
        return TITLE_TEXT_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getArticleTitleFromContents(String article_title) {
        return TITLE_FROM_CONTENTS_TPL.replace("{TITLE}", article_title);
    }

    private static String getListElement(String name_of_list) {
        return EXISTING_LIST_LINK_TPL.replace("{NAME_OF_LIST}", name_of_list);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }


    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder ",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void closeArticle() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Method closeArticle() do nothing to platform" + Platform.getInstance().getPlatformVar());
        }


    }


    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to readinglist", 5);
    }

    public void removeArticleFromSavedIfItAdded() {
        if (this.isElementPresent(OPTION_REMOVE_TO_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTION_REMOVE_TO_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from save",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }


    public void clickContentsOption() {
        this.waitForElementAndClick(
                OPTIONS_CONTENTS_BUTTON,
                "Can not find and click Contents button",
                5
        );
    }

    public WebElement waitForTitleContents(String article_title) {
        return this.waitForElementPresent(getArticleTitleFromContents(article_title), "Can not find article title from contents: " + article_title, 15);
    }

    public void closeContents() {
        this.waitForElementAndClick(
                CLOSE_CONTENTS_BUTTON,
                "Can not find and click CLose Contents button",
                5
        );
    }

    public String waitForContentOfArticle() {
        WebElement element = this.waitForElementPresent(FIRST_WORD_ON_TITLE, "Can not find first word of ", 10);
        return element.getText();
    }

    public void addArticleToExistingList(String name_of_list) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForOptionsMenuToRender();

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can not find option to adding article to reading list",
                5
        );

        this.waitForElementAndClick(
                getListElement(name_of_list),
                "Can not find created folder with name " + name_of_list,
                5
        );
    }

    public void waitForOptionsMenuToRender() {
        waitForElementPresent(
                OPTIONS_CHANGE_LANGUAGE_BUTTON,
                "Can not find option to change language",
                5);
        waitForElementPresent(
                SHARE_LINK_BUTTON,
                "Can not find option to share article",
                5);
        waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Can not find option to add article to list",
                5);
        waitForElementPresent(
                FIND_IN_PAGE_BUTTON,
                "Can not find option to find smth at article",
                5);
        waitForElementPresent(
                FONT_AND_THEME_BUTTON,
                "Can not find option to change font and theme",
                5);
    }

    public String getAttributeArticleTitleFromContents(String article_title) {
        WebElement titleElement = waitForTitleContents(article_title);
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else {
            return titleElement.getAttribute("name");
        }
    }

}