package components.forms;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseForm extends BaseComponent {

    private static final String HEADER_FORM_LOCATOR = "//h4[contains(.,'%s')]";


    private String label;
    private By headerFormLocator;


    public BaseForm(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.headerFormLocator = By.xpath(String.format(HEADER_FORM_LOCATOR, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(headerFormLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

}