package tests;

import models.CustomExercise;
import models.CustomExerciseFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCustomExercisesTest extends BaseTest {

    @Test
    public void openMyCustomExerciseTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercises
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

    }

    @Test(description = "")
    public void createNewCustomExerciseTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercises
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

        CustomExercise customExercise = CustomExerciseFactory.get();

        myCustomExercises
                .createNewCustomExercise(customExercise);
        boolean isMyEditedExercisePageOpened = myCustomExercises
                .isPageOpen();

        assertTrue(isMyEditedExercisePageOpened, "New Custom Exercise hasn't created");
        assertEquals(myCustomExercises.getCreatedExerciseName(), customExercise.getExerciseName(), "Name of the Exercise doesn't match");
    }

    @Test(description = "")
    public void editNewCustomExerciseTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercises
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

        CustomExercise customExercise = CustomExerciseFactory.get();

        myCustomExercises
                .clickMainEdit()
                .clickEdit()
                .editCustomExercise(customExercise);
        boolean isMyEditedExercisePageOpened = myCustomExercises
                .isPageOpen();

        assertTrue(isMyEditedExercisePageOpened, "Custom Exercise hasn't edited");
        assertEquals(myCustomExercises.getCreatedExerciseName(), customExercise.getExerciseName(), "Name of the Exercise doesn't match");
    }



    @Test(description = "")
    public void deleteCustomExerciseTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercises
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

        myCustomExercises
                .clickMainEdit()
                .clickDelete();
        assertEquals(myCustomExercises.getEmptyExercisesList(), "", "Exercise hasn't deleted");
    }

}
