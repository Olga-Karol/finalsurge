package base;

import models.VitalsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class AddVitalsTest extends BaseTest {

    VitalsModel testVitals = new VitalsModel();

    @Test(description = "Add a vital", retryAnalyzer = utils.RetryAnalyzer.class)
    public void addVitalsTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openDailyVitalsPage()
                .addVital(testVitals)
                .findAddedVitals(testVitals)
                .validateAddedVitals(testVitals);
    }

    @AfterMethod(alwaysRun = true, description = "Remove added Daily Vital")
    public void removeAddedWorkout() {
        mainSteps
                .openDailyVitalsPage()
                .findAddedVitals(testVitals)
                .removeVitals();
    }
}

