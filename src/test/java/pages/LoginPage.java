package pages;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class LoginPage extends BasePage{

    public String email = System.getenv().getOrDefault("JEFIT_EMAIL", PropertyReader.getProperty("jefit.email"));
    public String password = System.getenv().getOrDefault("JEFIT_PASSWORD", PropertyReader.getProperty("jefit.password"));
    public static final By LOGIN_BUTTON = By.xpath("//input[@value = 'Login']");
    public static final By ERROR_MESSAGE = By.id("invalidpassworderrormessage");

    public LoginPage open(){
        driver.get(BASE_URL+"login/");
        return this;
    }

    public ProfileHomePage login(){
        new Input(driver, "Username or Email").write(email);
        new Input(driver, "Password").write(password);
        new Button(driver, "Login").click();
        return new ProfileHomePage(driver);
    }

    public LoginPage loginWithsWrongData(String login,String password){
        new Input(driver, "Username or Email").write(login);
        new Input(driver, "Password").write(password);
        new Button(driver, "Login").click();
        return this;
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }
}
