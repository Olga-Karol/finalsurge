package components.forms.formelements.workoutelements;


import components.forms.formelements.baseelements.BaseInput;
import org.openqa.selenium.WebDriver;

public class InputHeartrate extends BaseInput {


    public static final String INPUT_HEARTRATE_CALORIES_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'span4')]//input";


    public InputHeartrate(WebDriver driver, String label) {
        super(driver, label, INPUT_HEARTRATE_CALORIES_LOCATOR_PATTERN);
    }
}