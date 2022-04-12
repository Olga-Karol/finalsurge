package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage{

    private static final String BASE_URL = "https://log.finalsurge.com/logout.cshtml";

    private static By SIGIN_BUTTON = By.className("signup");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(SIGIN_BUTTON));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
