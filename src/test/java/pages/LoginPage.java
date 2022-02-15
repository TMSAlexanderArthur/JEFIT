package pages;

import elements.Button;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
public class LoginPage extends BasePage {
    public String email = System.getenv().getOrDefault("JEFIT_EMAIL", PropertyReader.getProperty("jefit.email"));
    public String password = System.getenv().getOrDefault("JEFIT_PASSWORD", PropertyReader.getProperty("jefit.password"));
    public static final By LOGIN_BUTTON = By.xpath("//input[@value = 'Login']");
    public static final By ERROR_MESSAGE = By.id("invalidpassworderrormessage");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + LOGIN_BUTTON);
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open Login page")
    public LoginPage open() {
        driver.get(BASE_URL + "login/");
        log.info("Open Login page");
        return this;
    }

    @Step("Log in with valid email and password")
    public ProfileHomePage login() {
        new Input(driver, "vb_login_username").write(email);
        new Input(driver, "vb_login_password").write(password);
        new Button(driver, "Login").click();
        log.info("Valid login and password entered and login button pressed");
        return new ProfileHomePage(driver);
    }

    @Step("Log in with wrong email or password")
    public LoginPage loginWithsWrongData(String login, String password) {
        new Input(driver, "vb_login_username").write(login);
        new Input(driver, "vb_login_password").write(password);
        log.info("Combination of invalid login data : Wrong Login - " + login +
                " and Wrong Pass - " + password);
        new Button(driver, "Login").click();
        log.info("Click Login button");
        return this;
    }

    @Step("Get error message ")
    public String getErrorMessage() {
        log.info("Get the error text by " + ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}