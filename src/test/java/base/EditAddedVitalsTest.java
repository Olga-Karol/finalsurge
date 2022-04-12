package base;


import models.VitalsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class EditAddedVitalsTest extends BaseTest {

    VitalsModel testVitals = new VitalsModel();
    VitalsModel updatedVitals = VitalsModel.builder()
            .HealthNotes("Heart notes")
            .SleepHours(10)
            .build();

    @Test(description = "Add a new Daily Vital and update it", retryAnalyzer = utils.RetryAnalyzer.class)
    public void editVitalsTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openDailyVitalsPage()
                .addVital(testVitals)
                .findAddedVitals(testVitals)
                .updateAddedVitals(updatedVitals)
                .validateAddedVitals(updatedVitals);
    }

    @AfterMethod(alwaysRun = true, description = "Remove added Daily Vital")
    public void removeAddedWorkout() {
        mainSteps
                .openDailyVitalsPage()
                .findAddedVitals(updatedVitals)
                .removeVitals();
    }
}
