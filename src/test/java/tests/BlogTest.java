package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BlogTest extends BaseTest {

    @Test
    public void openBlogPageTest() {
        loginPage
                .open()
                .login();
        boolean isBlogPageOpened = blogPage
                .openBlogPage()
                .isPageOpen();

        assertTrue(isBlogPageOpened, "Blog page hasn't opened");

    }


}
