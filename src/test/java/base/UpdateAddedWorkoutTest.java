package base;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.RunWorkoutModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.PostconditionSteps;


public class UpdateAddedWorkoutTest extends BaseTest {

    PostconditionSteps postconditionSteps;
    RunWorkoutModel testWorkout = new RunWorkoutModel();
    RunWorkoutModel updatedWorkout = RunWorkoutModel.builder()
            .WorkoutName("Updated workout name")
            .WorkoutDescription("Updated Description")
            .AgeGroupPlace(5)
            .PerceivedEffort("4 (Moderate)")
            .MaxHR(20)
            .build();


    @Severity(SeverityLevel.CRITICAL)
    @Description("Add a new workout and update it")
    @Test
    public void updateAddedWorkoutTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openAddWorkoutPage()
                .addNewWorkout(testWorkout)
                .updateAddedWorkout(updatedWorkout)
                .validateAddedWorkout(updatedWorkout);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Remove all added test workout")
    @AfterMethod(alwaysRun=true)
    public void removeAddedWorkout(){
        postconditionSteps = new PostconditionSteps(driver);
        String testWorkoutName = updatedWorkout .getWorkoutName();
        postconditionSteps.removeTestWorkouts(testWorkoutName);
    }
}
