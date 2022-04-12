package components.forms.formelements.workoutelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox extends BaseComponent {

    private static final String CHECKBOX_LOCATOR_PATTERN = "//span[text()='%s']/ancestor::label[contains(@class, 'checkbox')]//input";


    private String label;
    private By checkboxLocator;

    public Checkbox(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.checkboxLocator = By.xpath(String.format(CHECKBOX_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(checkboxLocator).isDisplayed();
    }

    public void check() {
        driver.findElement(checkboxLocator).click();
    }

    public boolean isComponentSelected() {
        return driver.findElement(checkboxLocator).isSelected();
    }
}