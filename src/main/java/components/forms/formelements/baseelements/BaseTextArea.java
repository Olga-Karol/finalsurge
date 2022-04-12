package components.forms.formelements.baseelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseTextArea extends BaseComponent {

    public static final String TEXTAREA_LOCATOR_PATTERN = "//label[text()='%s']/ancestor::div[contains(@class, 'workoutarea ')]//textarea";


    private String label;
    private By textAreaLocator;
    private String textareaLocatorPattern;

    public BaseTextArea(WebDriver driver, String label, String textareaLocatorPattern) {
        super(driver);
        this.label = label;
        this.textareaLocatorPattern = textareaLocatorPattern;
        this.textAreaLocator = By.xpath(String.format(textareaLocatorPattern, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void insert(String text) {
        driver.findElement(textAreaLocator).clear();
        driver.findElement(textAreaLocator).sendKeys(text);
    }
}