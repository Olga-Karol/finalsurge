package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseClass {

    protected static WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setExplicitlyWaitTimeout (int durationOfSeconds) {
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
    }
}
