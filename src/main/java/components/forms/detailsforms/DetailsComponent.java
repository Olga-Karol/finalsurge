package components.forms.detailsforms;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailsComponent extends BaseComponent {


    public static final By TEXT_DATETIME_FIELD_LOCATOR = By.xpath("//div[1][@class='formSep']//small");
    public static final By TEXT_ACTIVITY_TYPE_FIELD_LOCATOR = By.className("activityTypeName");
    public static final By TEXT_NAME_WORKOUT_FIELD_LOCATOR = By.xpath("//div[1][@class='formSep']//div[3]");
    public static final By TEXT_WORKOUT_DESCRIPTION_LOCATOR = By.xpath("//p[@class=' testme dont-break-out']");
    public static final By TEXT_WORKOUT_STATISTICS_LOCATOR = By.xpath("//div[@id='EditProfile']//div[@class='formSep'][2]");
    public static final By TEXT_RACE_RESULTS_LOCATOR = By.xpath("//div[@id='EditProfile']//div[@class='formSep'][3]");
    public static final By TEXT_PERCEIVED_EFFORT_LOCATOR = By.xpath("//div[@id='EditProfile']//div[@class='formSep'][4]");
    public static final By TEXT_HEARTRATE_LOCATOR = By.xpath("//p[@class='formSep']");

    By textFieldLocator;

    public DetailsComponent(WebDriver driver, By textFieldLocator) {
        super(driver);
        this.textFieldLocator = textFieldLocator;
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }


    public String getValue() {
        return driver.findElement(textFieldLocator).getText();
    }
}