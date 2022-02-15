package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GetEliteTest extends BaseTest {

    @Test(description = "Open Get Elite page")
    public void getElitePageShouldBeAddedTest() {
        loginPage
                .open()
                .login();
        boolean isGetElitePageOpened = getElitePage
                .openGetElitePage()
                .isPageOpen();

        assertTrue(isGetElitePageOpened, "Get Elite page hasn't opened");

    }

}
