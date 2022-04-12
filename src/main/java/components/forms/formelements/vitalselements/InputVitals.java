package components.forms.formelements.vitalselements;

import components.forms.formelements.baseelements.BaseInput;
import org.openqa.selenium.WebDriver;

public class InputVitals extends BaseInput {


    public static final String INPUT_VITALS_TEXT_DATA_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'span3')]//input";


    public InputVitals(WebDriver driver, String label) {
        super(driver, label, INPUT_VITALS_TEXT_DATA_PATTERN);
    }
}