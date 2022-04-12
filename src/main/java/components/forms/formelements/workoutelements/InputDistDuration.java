package components.forms.formelements.workoutelements;


import components.forms.formelements.baseelements.BaseInput;
import org.openqa.selenium.WebDriver;

public class InputDistDuration extends BaseInput {

    public static final String INPUT_DISTANCE_DURATION_DATETIME_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'span6')]//input";

    public InputDistDuration(WebDriver driver, String label) {
        super(driver, label, INPUT_DISTANCE_DURATION_DATETIME_LOCATOR_PATTERN);
    }
}