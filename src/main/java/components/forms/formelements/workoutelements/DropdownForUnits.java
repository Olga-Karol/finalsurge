package components.forms.formelements.workoutelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropdownForUnits extends BaseComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//label[text()='%s']/ancestor::div[contains(@class, 'span6')]//select[@name='%s']";
    private String label;
    private String name;
    private By dropdownLocator;


    public DropdownForUnits(WebDriver driver, String label, String name) {
        super(driver);
        this.label = label;
        this.name = name;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, label, name));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    public void selectDropdownOption(String option){
            Select dropDown = new Select(driver.findElement(dropdownLocator));
            dropDown.selectByVisibleText(option);
            explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, option));
    }
}
