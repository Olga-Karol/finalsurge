package components.forms.formelements.workoutelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputBasicWorkout extends BaseComponent {

    public static final String INPUT_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'span6')]//input[@name='%s']";


    private String label;
    private By inputLocator;

    public InputBasicWorkout(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void insert(String text) {
        driver.findElement(inputLocator).clear();
        driver.findElement(inputLocator).sendKeys(text);
    }
}