package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateWorkoutPage extends BasePage{

    public static final By HEADER_IN_BREADCRUMBS = By.xpath("//ul[@id='breadcrumbs']//li/a[text() = 'Update Workout']");
    private static final By UPDATE_WORKOUT_LINK_LOCATOR = By.className("dropdown-toggle");


    public UpdateWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_IN_BREADCRUMBS));

    }

    @Override
    public BasePage openPage() {
        driver.findElement(UPDATE_WORKOUT_LINK_LOCATOR).click();
        return this;
    }
}