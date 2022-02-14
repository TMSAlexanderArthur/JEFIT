package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyReportsTest extends BaseTest{

    @Test
    public void overallReportsShouldBeOpened(){
        loginPage.open()
                .login();
        boolean overallReportsIsOpened = myReportsPage.overallReportsOpen()
                        .overallReportsIsOpened();

        assertTrue(overallReportsIsOpened, "page is not opened");
    }

    @Test
    public void barbellSquatInOverallReportsShouldBeOpened(){
        loginPage.open()
                .login();

        String barbellSquatText = myReportsPage.exerciseProgressOpen()
                .barbellSquatIsOpened();

        assertEquals(barbellSquatText, "Barbell Squat Images", "The text doesn't match");
    }

    @Test
    public void neckInBodyProgressShouldBeOpened(){
        loginPage.open()
                .login();

        String neckText = myReportsPage.bodyProgressOpen()
                .neckInBodyProgressIsOpened();

        assertEquals(neckText, "Body stat progress: neck( inches):", "The text doesn't match");
    }

    @Test
    public void compareBodyShouldBeOpened(){
        loginPage.open()
                .login();

        String compareBodyUrl = myReportsPage.compareBodyOpen()
                .compareBodyIsOpened();

        assertEquals(compareBodyUrl, "https://www.jefit.com//my-jefit/training-reports/compare.php", "The url doesn't match");
    }


}
