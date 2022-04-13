package base;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.RunWorkoutModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.PostconditionSteps;

import java.text.ParseException;


public class AddWorkoutTest extends BaseTest{

    PostconditionSteps postconditionSteps;
    RunWorkoutModel testWorkout = new RunWorkoutModel();

    @Severity(SeverityLevel.BLOCKER)
    @Description("Add a workout")
    @Test
    public void addWorkoutTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openAddWorkoutPage()
                .addNewWorkout(testWorkout)
                .validateAddedWorkout(testWorkout);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all added test workout")
    @AfterMethod(alwaysRun=true)
    public void removeAddedWorkout(){
        postconditionSteps = new PostconditionSteps(driver);
        String testWorkoutName = testWorkout.getWorkoutName();
        postconditionSteps.removeTestWorkouts(testWorkoutName);
    }
}

