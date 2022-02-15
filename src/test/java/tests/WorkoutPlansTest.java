package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WorkoutPlansTest extends BaseTest {

    @Test(description = "Open Workout Plans")
    public void workoutPlansShouldBeOpenedTest() {
        loginPage
                .open()
                .login();
        boolean isWorkoutPlansPageOpened = workoutPlansPage
                .openWorkoutPlans()
                .isPageOpen();

        assertTrue(isWorkoutPlansPageOpened, "Workout Plans page hasn't opened");
    }

}
