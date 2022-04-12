package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddWorkoutPage extends BasePage{

    private static final String BASE_URL = "https://log.finalsurge.com/WorkoutAdd.cshtml";
    public static final By HEADER_IN_BREADCRUMBS = By.xpath("//ul[@id='breadcrumbs']//li/a[text() = 'Add Workout']");


    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_IN_BREADCRUMBS));

    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}