package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyReportsTest extends BaseTest{

    @Test(description = "Open Overall Reports")
    public void overallReportsShouldBeOpenedTest(){
        loginPage.open()
                .login();
        boolean overallReportsIsOpened = myReportsPage.overallReportsOpen()
                        .overallReportsIsOpened();

        assertTrue(overallReportsIsOpened, "page is not opened");
    }

    @Test(description = "Open Barbell Squat in Overall Reports")
    public void barbellSquatInOverallReportsShouldBeOpenedTest(){
        loginPage.open()
                .login();

        String barbellSquatText = myReportsPage.exerciseProgressOpen()
                .barbellSquatIsOpened();

        assertEquals(barbellSquatText, "Barbell Squat Images", "The text doesn't match");
    }

    @Test(description = "Open Neck in Body Progress")
    public void neckInBodyProgressShouldBeOpenedTest(){
        loginPage.open()
                .login();

        String neckText = myReportsPage.bodyProgressOpen()
                .neckInBodyProgressIsOpened();

        assertEquals(neckText, "Body stat progress: neck( inches):", "The text doesn't match");
    }

    @Test(description = "Open Compare Body")
    public void compareBodyShouldBeOpenedTest(){
        loginPage.open()
                .login();

        String compareBodyUrl = myReportsPage.compareBodyOpen()
                .compareBodyIsOpened();

        assertEquals(compareBodyUrl, "https://www.jefit.com//my-jefit/training-reports/compare.php", "The url doesn't match");
    }


}
