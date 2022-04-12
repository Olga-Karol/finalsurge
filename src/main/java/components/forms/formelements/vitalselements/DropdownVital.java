package components.forms.formelements.vitalselements;

import components.forms.formelements.baseelements.BaseDropdown;
import org.openqa.selenium.WebDriver;

public class DropdownVital extends BaseDropdown {

    public static final String DROPDOWN_LOCATOR_PATTERN = " //label[text()='%s']/ancestor::div[contains(@class, 'span3')]//select";

      public DropdownVital(WebDriver driver, String label) {
        super(driver, DROPDOWN_LOCATOR_PATTERN, label);
    }
}
