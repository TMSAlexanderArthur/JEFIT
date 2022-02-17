package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Log4j2
public class FriendsPage extends BasePage {
    public static final By FRIENDS_SPAN = By.xpath("//li[contains(text(),'0')]");
    public static final By MY_FRIENDS_TITLE = By.xpath("//div[@id='friendsListTab']");
    public static final By CONTENT_BOX_TEXT = By.xpath("//div[@class='contentBox']/div[contains(@style, 'text')]");

    public static final By BLOCKED_LIST_LINK = By.xpath("//a[@onclick]");
    public static final By BLOCKED_LIST_TITLE = By.xpath("//div[contains(text(), 'block')]");

    public static final By INCOMING_REQUESTS_TAB = By.xpath("//div[contains(@onclick, 'incomingRequest')]");
    public static final By INCOMING_REQUESTS_CONTENT = By.xpath("//div[@class='contentBox']/div[contains(text(), 'request')]");

    public static final By SEARCH_FRIENDS_TAB = By.xpath("//div[contains(@onclick, 'searchFriends')]");
    public static final By SEARCH_FRIENDS_CONTENT = By.xpath("//div[@class='contentBox']//div[normalize-space()='Search and add your friends!']");
    public static final By SEARCH_FRIENDS_INPUT = By.xpath("//input[@id='suggestionsinput']");
    public static final By SEARCH_FRIENDS_BUTTON = By.xpath("//input[@id='searchFriend']");
    public static final By ADD_FRIEND_BUTTON = By.xpath("//a[normalize-space()='+ Add']");
    public static final By FRIEND_REQUEST_SENT_ACTION = By.xpath("//a[@class='unclickable']");

    public FriendsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + MY_FRIENDS_TITLE);
        return isExist(MY_FRIENDS_TITLE);
    }

    @Step("Open My Friends")
    public FriendsPage openMyFriends() {
        Actions action = new Actions(driver);
        log.info("Initialize a new Action ");
        driver.findElement(FRIENDS_SPAN).click();
        log.info("Moving the cursor to an element " + FRIENDS_SPAN + " and click");
        return this;
    }

    @Step("Open Blocked List")
    public void openBlockedList() {
        driver.findElement(BLOCKED_LIST_LINK).click();
        log.info("Click on blocked list link by " + BLOCKED_LIST_LINK);
        WebElement blockListIsEmpty = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(BLOCKED_LIST_TITLE));
        log.debug("Explicit Wait element " + BLOCKED_LIST_TITLE);
    }

    @Step("Open incoming request")
    public void openIncomingRequests() {
        driver.findElement(INCOMING_REQUESTS_TAB).click();
        log.info("Click on element--> " + INCOMING_REQUESTS_TAB);
        WebElement incomingRequestText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(INCOMING_REQUESTS_CONTENT));
        log.debug("Explicit Wait element " + INCOMING_REQUESTS_CONTENT);
    }

    @Step("Open Search Friends")
    public FriendsPage openSearchFriends() {
        driver.findElement(SEARCH_FRIENDS_TAB).click();
        log.info("Click on element--> " + SEARCH_FRIENDS_TAB);
        WebElement searchAndAddText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(SEARCH_FRIENDS_CONTENT));
        log.debug("Explicit Wait element " + SEARCH_FRIENDS_CONTENT);
        return this;
    }

    @Step("Get text from an element content box")
    public String getContentBoxText() {
        log.info("Get text from an element --> " + CONTENT_BOX_TEXT);
        return driver.findElement(CONTENT_BOX_TEXT).getText();
    }

    @Step("Add new friend")
    public void addNewFriend() {
        driver.findElement(SEARCH_FRIENDS_INPUT).sendKeys("rivegd");
        log.info("Input 'rivegd' in element --> " + SEARCH_FRIENDS_INPUT);
        driver.findElement(SEARCH_FRIENDS_BUTTON).click();
        log.info("Click button search friends by " + SEARCH_FRIENDS_BUTTON);
        driver.findElement(ADD_FRIEND_BUTTON).click();
        log.info("Click button add friend by " + ADD_FRIEND_BUTTON);

    }

    @Step("Request sent invitation is displayed")
    public boolean requestSentInvitationIsDisplayed() {
        log.info("Find element --> " + FRIEND_REQUEST_SENT_ACTION);
        return driver.findElement(FRIEND_REQUEST_SENT_ACTION).isDisplayed();
    }


}
