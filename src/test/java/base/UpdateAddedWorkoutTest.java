package base;

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

    @Test(description = "Add a new workout and update it")
    public void updateAddedWorkoutTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openAddWorkoutPage()
                .addNewWorkout(testWorkout)
                .updateAddedWorkout(updatedWorkout)
                .validateAddedWorkout(updatedWorkout);
    }

    @AfterMethod(alwaysRun=true, description = "Remove all added test workout")
    public void removeAddedWorkout(){
        postconditionSteps = new PostconditionSteps(driver);
        String testWorkoutName = updatedWorkout .getWorkoutName();
        postconditionSteps.removeTestWorkouts(testWorkoutName);
    }
}
