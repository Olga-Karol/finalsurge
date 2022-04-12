package components.forms.formelements.baseelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseInput extends BaseComponent {


    private String label;
    private By inputLocator;
    private String inputLocatorPattern;

    public BaseInput(WebDriver driver, String label, String inputLocatorPattern) {
        super(driver);
        this.label = label;
        this.inputLocatorPattern = inputLocatorPattern;
        this.inputLocator = By.xpath(String.format(inputLocatorPattern, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void insert(String text) {
        //setExplicitlyWaitTimeout(5);
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        driver.findElement(inputLocator).clear();
        driver.findElement(inputLocator).sendKeys(text);
    }
}