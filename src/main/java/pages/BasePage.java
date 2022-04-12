package pages;

import base.BaseClass;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends BaseClass {


    public BasePage(WebDriver driver) {
        super(driver);
    }

    abstract public void waitPageLoaded();

    abstract public BasePage openPage();

    public boolean isPageLoaded() {
        try {
            waitPageLoaded();
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
}
