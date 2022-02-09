package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ExercisesTest extends BaseTest {

    @Test
    public void openExercisesPageTest() {
        loginPage
                .open()
                .login();
        boolean isExercisesPageOpened = exercisesPage
                .openExercisePage()
                .isPageOpen();

        assertTrue(isExercisesPageOpened, "Exercises page hasn't opened");

    }

    @Test
    public void openAllExercisesDatabaseTest() {
        loginPage
                .open()
                .login();
        exercisesPage
                .openExercisePage()
                .openAllExerciseDatabase();
        boolean isAllExercisesDatabasePageOpened = allExerciseDatabasePage
                .isPageOpen();

        assertTrue(isAllExercisesDatabasePageOpened, "All Exercises Database page hasn't opened");

    }

}
