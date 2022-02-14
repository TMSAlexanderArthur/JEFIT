package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.NotificationsPage.MY_JEFIT_SPAN;

public class FriendsPage extends BasePage {
    public static final By FRIENDS_SPAN = By.xpath("//span[text()='Friends']");
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
    public boolean isPageOpen() {
        return isExist(MY_FRIENDS_TITLE);
    }

    public FriendsPage openMyFriends() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(MY_JEFIT_SPAN);
        action.moveToElement(we).moveToElement(driver.findElement(FRIENDS_SPAN)).click().build().perform();
        return this;
    }

    public void openBlockedList() {
        driver.findElement(BLOCKED_LIST_LINK).click();
        WebElement blockListIsEmpty = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(BLOCKED_LIST_TITLE));
    }

    public void openIncomingRequests() {
        driver.findElement(INCOMING_REQUESTS_TAB).click();
        WebElement incomingRequestText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(INCOMING_REQUESTS_CONTENT));
    }

    public FriendsPage openSearchFriends() {
        driver.findElement(SEARCH_FRIENDS_TAB).click();
        WebElement searchAndAddText = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(SEARCH_FRIENDS_CONTENT));
        return this;
    }

    public String getContentBoxText() {
        return driver.findElement(CONTENT_BOX_TEXT).getText();
    }

    public void addNewFriend() {
        driver.findElement(SEARCH_FRIENDS_INPUT).sendKeys("rivegd");
        driver.findElement(SEARCH_FRIENDS_BUTTON).click();
        driver.findElement(ADD_FRIEND_BUTTON).click();
    }

    public boolean requestSentInvitationIsDisplayed() {
        return driver.findElement(FRIEND_REQUEST_SENT_ACTION).isDisplayed();
    }


}
