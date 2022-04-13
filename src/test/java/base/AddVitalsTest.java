package base;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.VitalsModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class AddVitalsTest extends BaseTest {

    VitalsModel testVitals = new VitalsModel();

    @Severity(SeverityLevel.BLOCKER)
    @Description ("Add a vital")
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void addVitalsTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openDailyVitalsPage()
                .addVital(testVitals)
                .findAddedVitals(testVitals)
                .validateAddedVitals(testVitals);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Remove added Daily Vital")
    @AfterMethod(alwaysRun = true)
    public void removeAddedWorkout() {
        mainSteps
                .openDailyVitalsPage()
                .findAddedVitals(testVitals)
                .removeVitals();
    }
}

