package components.forms.formelements.workoutelements;

import components.BaseComponent;
import components.forms.formelements.baseelements.BaseTextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextAreaWorkout extends BaseTextArea {

    public static final String TEXTAREA_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'workoutarea ')]//textarea";

    public TextAreaWorkout(WebDriver driver, String label) {
        super(driver, label, TEXTAREA_LOCATOR_PATTERN);
    }
}