package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VitalsPage extends BasePage{

    private static final String BASE_URL = "https://log.finalsurge.com/DailyVitals.cshtml";
    public static final By HEADER_IN_BREADCRUMBS = By.xpath("//ul[@id='breadcrumbs']//li/a[text() = 'Daily Vitals']");
    public static final By ADD_VITALS_BUTTON = By.xpath("//button[@title ='Add Vitals']");
    public static final By VIEW_FILTERED_VITALS_BUTTON = By.xpath("//input[@value = 'View']");


    public VitalsPage(WebDriver driver) {
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

    public void openAddVitalsForm(){
        driver.findElement(ADD_VITALS_BUTTON).click();
    }

    public void filerVitalsByDate(){
        driver. findElement(VIEW_FILTERED_VITALS_BUTTON).click();
    }
}