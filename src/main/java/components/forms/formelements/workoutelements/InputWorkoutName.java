package components.forms.formelements.workoutelements;

import components.BaseComponent;
import components.forms.formelements.baseelements.BaseInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWorkoutName extends BaseInput {

    public static final String INPUT_WORKOUT_NAME_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'workoutarea ')]//input";

    public InputWorkoutName(WebDriver driver, String label) {
        super(driver, label, INPUT_WORKOUT_NAME_LOCATOR_PATTERN);
    }
}