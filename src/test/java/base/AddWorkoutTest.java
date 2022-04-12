package base;

import models.RunWorkoutModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import steps.PostconditionSteps;

import java.text.ParseException;


public class AddWorkoutTest extends BaseTest{

    PostconditionSteps postconditionSteps;
    RunWorkoutModel testWorkout = new RunWorkoutModel();

    @Test(description = "Add a workout")
    public void addWorkoutTest() {
        mainSteps
                .openFinalSurgeLoginPage()
                .validCredentialsLogin()
                .openAddWorkoutPage()
                .addNewWorkout(testWorkout)
                .validateAddedWorkout(testWorkout);
    }

    @AfterMethod(alwaysRun=true, description = "Remove all added test workout")
    public void removeAddedWorkout(){
        postconditionSteps = new PostconditionSteps(driver);
        String testWorkoutName = testWorkout.getWorkoutName();
        postconditionSteps.removeTestWorkouts(testWorkoutName);
    }
}

