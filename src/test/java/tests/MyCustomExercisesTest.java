package tests;

import models.CustomExercise;
import models.CustomExerciseFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCustomExercisesTest extends BaseTest {

    @Test(description = "Open My Custom Exercise")
    public void myCustomExerciseShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isMyCustomExercisePageOpened = myCustomExercises
                .openMyCustomExercises()
                .isPageOpen();

        assertTrue(isMyCustomExercisePageOpened, "My Custom Exercise page hasn't opened");

    }

    @Test(description = "Create new Custom Exercise")
    public void newCustomExerciseShouldBeCreatedTest() {
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

    @Test(description = "Edit new Custom Exercise")
    public void newCustomExerciseShouldBeEditingTest() {
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



    @Test(description = "Delete Custom Exercise")
    public void customExerciseShouldBeDeletedTest() {
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
