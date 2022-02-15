package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BlogTest extends BaseTest {

    @Test(description = "Open blog page")
    public void blogPageShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isBlogPageOpened = blogPage
                .openBlogPage()
                .isPageOpen();

        assertTrue(isBlogPageOpened, "Blog page hasn't opened");

    }


}
