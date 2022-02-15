package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CoachModeTest extends BaseTest {

    @Test(description = "Open Coach Mode page")
    public void coachModePageShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isCoachModePageOpened = coachModePage
                .openCoachModePage()
                .isPageOpen();

        assertTrue(isCoachModePageOpened, "Coach Mode page hasn't opened");

    }

}
