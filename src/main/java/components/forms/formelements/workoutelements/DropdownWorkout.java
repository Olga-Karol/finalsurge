package components.forms.formelements.workoutelements;

import components.BaseComponent;
import components.forms.formelements.baseelements.BaseDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropdownWorkout extends BaseDropdown {

    public static final String DROPDOWN_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'span6')]//select";
    //label[text()='%s']/ancestor::div[contains(@class, 'span3')]//select

    public DropdownWorkout(WebDriver driver, String label) {
        super(driver, DROPDOWN_LOCATOR_PATTERN, label);
    }
}
