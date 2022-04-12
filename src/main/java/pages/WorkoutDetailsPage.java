package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkoutDetailsPage extends BasePage{

    public static final By HEADER_IN_BREADCRUMBS = By.xpath("//ul[@id='breadcrumbs']//li/a[text() = 'Workout Details']");


    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_IN_BREADCRUMBS));
    }

    @Override
    public BasePage openPage() {
        driver.findElement(HEADER_IN_BREADCRUMBS).click();
        return this;
    }
}