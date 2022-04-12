package components.forms.formelements.baseelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseDropdown extends BaseComponent {

    private String dropdownLocatorPattern;
    private String label;
    private By dropdownLocator;


    public BaseDropdown(WebDriver driver, String dropdownLocatorPattern, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocatorPattern = dropdownLocatorPattern;
        this.dropdownLocator = By.xpath(String.format(dropdownLocatorPattern, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void selectDropdownOption(String option){
            Select dropDown = new Select(driver.findElement(dropdownLocator));
            dropDown.selectByVisibleText(option);
            explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, option));
    }
}
