package components.forms.formelements.vitalselements;

import components.forms.formelements.baseelements.BaseTextArea;
import org.openqa.selenium.WebDriver;

public class TextAreaVitals extends BaseTextArea {

    public static final String TEXTAREA_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'formSep')]//textarea";

    public TextAreaVitals(WebDriver driver, String label) {
        super(driver, label, TEXTAREA_LOCATOR_PATTERN);
    }
}