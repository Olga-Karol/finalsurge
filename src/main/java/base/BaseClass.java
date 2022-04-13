package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.BaseConstants.EXPLICIT_WAIT_DURATION_SEC;

public abstract class BaseClass {

    protected static WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_DURATION_SEC));
    }

    public void setExplicitlyWaitTimeout (int durationOfSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
    }
}
