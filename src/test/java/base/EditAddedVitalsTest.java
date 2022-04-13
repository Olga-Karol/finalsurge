package base;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.VitalsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class EditAddedVitalsTest extends BaseTest {

    VitalsModel testVitals = new VitalsModel();
    VitalsModel updatedVitals = VitalsModel.builder()
            .HealthNotes("Heart notes")
            .SleepHours(10)
            .build();

    @Severity(SeverityLevel.CRITICAL)
    @Description("Add a new Daily Vital and update it")
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
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

    @Severity(SeverityLevel.NORMAL)
    @Description("Remove added Daily Vital")
    @AfterMethod(alwaysRun = true)
    public void removeAddedWorkout() {
        mainSteps
                .openDailyVitalsPage()
                .findAddedVitals(updatedVitals)
                .removeVitals();
    }
}
