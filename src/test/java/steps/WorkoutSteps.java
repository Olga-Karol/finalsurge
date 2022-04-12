package steps;

import components.addworkoutleftmenu.WorkoutType;
import components.addworkoutleftmenu.subtype.WorkoutSubType;
import components.forms.formelements.buttons.SaveButton;
import components.forms.CreateForm;
import components.forms.detailsforms.DetailsComponent;
import components.forms.formelements.workoutelements.*;
import io.qameta.allure.Step;
import models.RunWorkoutModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.UpdateWorkoutPage;
import pages.WorkoutDetailsPage;
import static components.forms.detailsforms.DetailsComponent.*;
import static components.forms.detailsforms.DetailsComponent.TEXT_ACTIVITY_TYPE_FIELD_LOCATOR;
import static components.forms.detailsforms.DetailsComponent.TEXT_DATETIME_FIELD_LOCATOR;
import static components.forms.detailsforms.DetailsComponent.TEXT_NAME_WORKOUT_FIELD_LOCATOR;
import static constants.CreationFormTitles.ADD_NEW_WORKOUT_FORM_TITLE;
import static constants.SaveButtonLabels.ADD_WORKOUT_BUTTON_LABEL;
import static constants.DateTimeParser.*;
import static constants.LabelsWorkoutForm.*;
import static constants.SaveButtonLabels.UPDATE_WORKOUT_BUTTON_LABEL;
import static constants.TextParserConstants.DASH;
import static constants.WorkoutLeftMenuLabels.WORKOUT_SUBTYPE;
import static constants.WorkoutLeftMenuLabels.WORKOUT_TYPE;
import static utils.ConvertDateFormat.*;
import static utils.WorkoutDetailsParser.*;


public class WorkoutSteps extends BaseStep {

    private CreateForm createForm;
    private WorkoutType workoutType;
    private WorkoutSubType workoutSubType;
    private WorkoutDetailsPage workoutDetailsPage;
    private SaveButton saveButton;
    private UpdateWorkoutPage updateWorkoutPage;


    public WorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public WorkoutSteps addNewWorkout(RunWorkoutModel runWorkoutModel) {
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        workoutType = new WorkoutType(driver, WORKOUT_TYPE);
        workoutSubType = new WorkoutSubType(driver, WORKOUT_SUBTYPE);
        saveButton = new SaveButton(driver, ADD_WORKOUT_BUTTON_LABEL);
        workoutType.click();
        assertComponentIsDisplayed(workoutSubType);
        workoutSubType.click();
        CreateForm form = new CreateForm(driver, ADD_NEW_WORKOUT_FORM_TITLE);
        assertComponentIsDisplayed(form);
        fillWorkoutForm (runWorkoutModel);
        saveButton.save();
        assertPageIsLoaded(workoutDetailsPage);
        return this;
    }


    @Step
    public WorkoutSteps updateAddedWorkout(RunWorkoutModel updatedRunWorkoutModel){
        updateWorkoutPage = new UpdateWorkoutPage(driver);
        updateWorkoutPage.openPage();
        assertPageIsLoaded(updateWorkoutPage);
        updatelWorkoutForm(updatedRunWorkoutModel);
        saveButton = new SaveButton(driver, UPDATE_WORKOUT_BUTTON_LABEL);
        saveButton.save();
        assertPageIsLoaded(workoutDetailsPage);
        return this;
    }


    @Step("Make sure filled workout data matches to data on the Details page")
    public void validateAddedWorkout(RunWorkoutModel expectedModel) {
        workoutDetailsPage.openPage();
        RunWorkoutModel actualModel = getActualWorkout();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Workout is not valid: %s", actualModel)
        );
    }

    private void fillWorkoutForm(RunWorkoutModel runWorkoutModel) {
        new InputWorkoutName(driver, WORKOUT_NAME).insert(runWorkoutModel.getWorkoutName());
        new TextAreaWorkout(driver, WORKOUT_DESCRIPTION).insert(runWorkoutModel.getWorkoutDescription());
        new InputDistDuration(driver, DATE).insert(runWorkoutModel.getDate());
        new InputWorkoutName(driver, TIME_OF_DAY).insert(runWorkoutModel.getTimeOfDay());
        new Checkbox(driver, SHOW_PLANNED).check();
        new InputDistDuration(driver, PLANNED_DISTANCE).insert(String.valueOf(runWorkoutModel.getPlannedDistance()));
        new DropdownWorkout(driver, PLANNED_DISTANCE).selectDropdownOption(runWorkoutModel.PlannedDistanceUnit);
        new InputDistDuration(driver, PLANNED_DURATION).insert(runWorkoutModel.getPlannedDuration());
        new InputBasicWorkout(driver, DISTANCE).insert(String.valueOf(runWorkoutModel.getDistance()));
        new DropdownForUnits(driver, DISTANCE , "DistType").selectDropdownOption(runWorkoutModel.getDistanceUnit());
        new InputBasicWorkout(driver, DURATION ).insert(String.valueOf(runWorkoutModel.getDuration()));
        new InputBasicWorkout(driver, PACE).insert(runWorkoutModel.getPace());
        new DropdownForUnits(driver, PACE, "PaceType").selectDropdownOption(runWorkoutModel.getPaceUnit());
        new Checkbox(driver, MARK_AS_RACE).check();
        new InputDistDuration(driver, OVERALL_PLACE).insert(String.valueOf(runWorkoutModel.getOverallPlace()));
        new InputDistDuration(driver, AGE_GROUP_PLACE).insert(String.valueOf(runWorkoutModel.getAgeGroupPlace()));
        new RadioButton(driver, runWorkoutModel.getRadioButtonOption()).selectOption();
        new DropdownWorkout(driver, PERCEIVED_EFFORT).selectDropdownOption(runWorkoutModel.getPerceivedEffort());
        new InputHeartrate(driver, MIN_HR).insert(String.valueOf(runWorkoutModel.getMinHR()));
        new InputHeartrate(driver, MAX_HR).insert(String.valueOf(runWorkoutModel.getMaxHR()));
        new InputHeartrate(driver, AVG_HR).insert(String.valueOf(runWorkoutModel.getAvgHR()));
        new InputHeartrate(driver, CALORIES_BURNED).insert(String.valueOf(runWorkoutModel.getCaloriesBurned()));
    }

    private void updatelWorkoutForm(RunWorkoutModel runWorkoutModel) {
        new InputWorkoutName(driver, WORKOUT_NAME).insert(runWorkoutModel.getWorkoutName());
        new TextAreaWorkout(driver, WORKOUT_DESCRIPTION).insert(runWorkoutModel.getWorkoutDescription());
        new InputDistDuration(driver, DATE).insert(runWorkoutModel.getDate());
        new InputWorkoutName(driver, TIME_OF_DAY).insert(runWorkoutModel.getTimeOfDay());
        new InputDistDuration(driver, PLANNED_DISTANCE).insert(String.valueOf(runWorkoutModel.getPlannedDistance()));
        new DropdownWorkout(driver, PLANNED_DISTANCE).selectDropdownOption(runWorkoutModel.PlannedDistanceUnit);
        new InputDistDuration(driver, PLANNED_DURATION).insert(runWorkoutModel.getPlannedDuration());
        new InputBasicWorkout(driver, DISTANCE).insert(String.valueOf(runWorkoutModel.getDistance()));
        new DropdownForUnits(driver, DISTANCE , "DistType").selectDropdownOption(runWorkoutModel.getDistanceUnit());
        new InputBasicWorkout(driver, DURATION ).insert(String.valueOf(runWorkoutModel.getDuration()));
        new InputBasicWorkout(driver, PACE).insert(runWorkoutModel.getPace());
        new DropdownForUnits(driver, PACE, "PaceType").selectDropdownOption(runWorkoutModel.getPaceUnit());
        new InputDistDuration(driver, OVERALL_PLACE).insert(String.valueOf(runWorkoutModel.getOverallPlace()));
        new InputDistDuration(driver, AGE_GROUP_PLACE).insert(String.valueOf(runWorkoutModel.getAgeGroupPlace()));
        new RadioButton(driver, runWorkoutModel.getRadioButtonOption()).selectOption();
        new DropdownWorkout(driver, PERCEIVED_EFFORT).selectDropdownOption(runWorkoutModel.getPerceivedEffort());
        new InputHeartrate(driver, MIN_HR).insert(String.valueOf(runWorkoutModel.getMinHR()));
        new InputHeartrate(driver, MAX_HR).insert(String.valueOf(runWorkoutModel.getMaxHR()));
        new InputHeartrate(driver, AVG_HR).insert(String.valueOf(runWorkoutModel.getAvgHR()));
        new InputHeartrate(driver, CALORIES_BURNED).insert(String.valueOf(runWorkoutModel.getCaloriesBurned()));
    }

    private RunWorkoutModel getActualWorkout() {
        RunWorkoutModel actualModel = new RunWorkoutModel();

        actualModel.setWorkoutName(new DetailsComponent(driver, TEXT_NAME_WORKOUT_FIELD_LOCATOR).getValue());
        actualModel.setWorkoutType(new DetailsComponent(driver, TEXT_ACTIVITY_TYPE_FIELD_LOCATOR).getValue());
        String dateTimeValue = new DetailsComponent(driver, TEXT_DATETIME_FIELD_LOCATOR).getValue();
        actualModel.setDate(convertDateTime(defaultParser(dateTimeValue, DASH, 0), INPUT_DATETIME_FORMAT, OUTPUT_DATE_FORMAT));
        actualModel.setTimeOfDay(defaultParser(dateTimeValue, DASH, 1));

        String workoutDesc = new DetailsComponent(driver, TEXT_WORKOUT_DESCRIPTION_LOCATOR).getValue();
        actualModel.setWorkoutDescription(getWorkoutDescData(workoutDesc).get(0));
        actualModel.setPlannedDistanceUnit(getWorkoutDescData(workoutDesc).get(1));
        actualModel.setPlannedDistanceUnit(getWorkoutDescData(workoutDesc).get(2));
        actualModel.setPlannedDuration(getWorkoutDescData(workoutDesc).get(3));

        String workoutStats = new DetailsComponent(driver, TEXT_WORKOUT_STATISTICS_LOCATOR).getValue();
        actualModel.setDistance(Double.parseDouble(getWorkoutStatistics(workoutStats).get(4)));
        actualModel.setDistanceUnit(getWorkoutStatistics(workoutStats).get(5));
        actualModel.setDuration(getWorkoutStatistics(workoutStats).get(6));
        actualModel.setPace(getWorkoutStatistics(workoutStats).get(7));
        actualModel.setPaceUnit(getWorkoutStatistics(workoutStats).get(8));

        String raceResults = new DetailsComponent(driver, TEXT_RACE_RESULTS_LOCATOR).getValue();
        actualModel.setOverallPlace(Integer.parseInt(getPaceResults(raceResults).get(9)));
        actualModel.setAgeGroupPlace(Integer.parseInt(getPaceResults(raceResults).get(10)));

        String feelings = new DetailsComponent(driver, TEXT_PERCEIVED_EFFORT_LOCATOR).getValue();
        actualModel.setRadioButtonOption(getFeelings(feelings).get(11));
        actualModel.setPerceivedEffort(getFeelings(feelings).get(12));

        String heartRate = new DetailsComponent(driver, TEXT_HEARTRATE_LOCATOR).getValue();
        actualModel.setMinHR(Integer.parseInt(getHeartRate(heartRate).get(13)));
        actualModel.setAvgHR(Integer.parseInt(getHeartRate(heartRate).get(14)));
        actualModel.setMaxHR(Integer.parseInt(getHeartRate(heartRate).get(15)));
        actualModel.setCaloriesBurned(Integer.parseInt(getHeartRate(heartRate).get(16)));

        return actualModel;
    }
}
