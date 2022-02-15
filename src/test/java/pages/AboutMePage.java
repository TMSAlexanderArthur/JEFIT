package pages;

import elements.Button;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.AboutMe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AboutMePage extends BasePage {
    public static final By ABOUT_ME_TITLE = By.xpath("//strong[text() = 'About Me']");

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + ABOUT_ME_TITLE);
        return isExist(ABOUT_ME_TITLE);
    }


    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open About 'Me page'")
    public AboutMePage open() {
        driver.get(BASE_URL + "my-jefit/aboutme/");
        log.info("Open About Me page");
        return this;
    }

    @Step("Create {aboutMe}")
    public AboutMePage create(AboutMe aboutMe) {
        new Input(driver, "t1").write(aboutMe.getT1());
        new Input(driver, "t2").write(aboutMe.getT2());
        new TextArea(driver, "t3").write(aboutMe.getT3());
        new TextArea(driver, "t4").write(aboutMe.getT4());
        new TextArea(driver, "t5").write(aboutMe.getT5());
        new TextArea(driver, "t6").write(aboutMe.getT6());
        new TextArea(driver, "t7").write(aboutMe.getT7());
        new TextArea(driver, "t8").write(aboutMe.getT8());
        new TextArea(driver, "t9").write(aboutMe.getT9());
        new TextArea(driver, "t10").write(aboutMe.getT10());
        new TextArea(driver, "t11").write(aboutMe.getT11());
        new TextArea(driver, "t12").write(aboutMe.getT12());
        new TextArea(driver, "t13").write(aboutMe.getT13());
        new TextArea(driver, "t14").write(aboutMe.getT14());
        new TextArea(driver, "t15").write(aboutMe.getT15());
        log.info("Create " + aboutMe);
        return clickSave();
    }

    @Step("Clear all fields in 'about me'")
    public AboutMePage clearAllFields() {
        new Input(driver, "t1").clear();
        new Input(driver, "t2").clear();
        new TextArea(driver, "t3").clear();
        new TextArea(driver, "t4").clear();
        new TextArea(driver, "t5").clear();
        new TextArea(driver, "t6").clear();
        new TextArea(driver, "t7").clear();
        new TextArea(driver, "t8").clear();
        new TextArea(driver, "t9").clear();
        new TextArea(driver, "t10").clear();
        new TextArea(driver, "t11").clear();
        new TextArea(driver, "t12").clear();
        new TextArea(driver, "t13").clear();
        new TextArea(driver, "t14").clear();
        new TextArea(driver, "t15").clear();
        log.info("Clear all fields in about me and click Save button");
        return clickSave();
    }

    @Step("Click 'Save' button")
    public AboutMePage clickSave() {
        new Button(driver, "Save").click();
        return new AboutMePage(driver);
    }
}