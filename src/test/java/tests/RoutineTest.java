package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RoutineTest extends BaseTest {

    @Test
    public void routineShouldBeCreated() {
        loginPage.open()
                .login();

        boolean routinePageIsOpened = routinesPage.open()
                .createRoutine()
                .isPageOpen();

        assertTrue(routinePageIsOpened, "Page is not opened");

        assertEquals(routinesPage.getRoutineName(), routinesPage.returnRoutineFakerText(), "The text doesn't match");

        routinesPage.deleteRoutine();
    }

    @Test
    public void routineShouldBeEditing() {
        loginPage.open()
                .login();
        String createdRoutineName = routinesPage.open()
                .createRoutine()
                .getRoutineName();

        String editingRoutineName = routinesPage.editRoutine()
                .getEditingRoutineName();

        boolean routineIsOpened = !createdRoutineName.equals(editingRoutineName);

        assertTrue(routineIsOpened, "Page is noy opened");

        routinesPage.deleteRoutine();
    }

    @Test
    public void Routine5x5ShouldBeDownloaded() {
        loginPage.open()
                .login();
        routinesPage.open()
                .download5x5Routine()
                .open();

        assertEquals(routinesPage.getRoutineName(), "5x5 Strength Training Program"
                , "The text doesn't match");

        routinesPage.deleteRoutine();
    }

    @Test
    public void routineShouldBeDeleted() {
        loginPage.open()
                .login();
        routinesPage.open()
                .createRoutine()
                .deleteRoutine();

        assertEquals(routinesPage.routineIsDeletedText(),
                "You have not setup a default routine yet. Please create one or set one as default routine"
        , "The text doesn't match");

    }

    @Test
    public void sharedWithMeTabShouldBeOpened() {
        loginPage.open()
                .login();
        String sharedWithMeUrl = routinesPage.open()
                .openSharedWithMeTab()
                .getSharedWithMeUrl();

        assertEquals(sharedWithMeUrl, "https://www.jefit.com//my-jefit/my-routines/shared-with-me.php", "The url doesn't match");
    }

    @Test
    public void mySubmitsTabShouldBeOpened() {
        loginPage.open()
                .login();

        boolean mySubmitsTabIsOpened = routinesPage.open()
                .openMySubmitsTab()
                .mySubmitsTabIsOpened();

        assertTrue(mySubmitsTabIsOpened, "Page is not opened");
    }



}
