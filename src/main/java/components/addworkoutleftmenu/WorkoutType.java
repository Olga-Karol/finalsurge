package components.addworkoutleftmenu;

import components.BaseComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WorkoutType extends BaseComponent {

    public static final String MENU_ITEM_LOCATOR = "//a[contains(text(),'%s')]/ancestor::div[@class='accordion-heading']/a";
    private String label;
    private By menuItemLocator;

    Logger log = LogManager.getLogger(WorkoutType.class);

    public WorkoutType(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.menuItemLocator = By.xpath(String.format(MENU_ITEM_LOCATOR, label));
    }

    public void click() {
        log.info("Select Activity type [{}]",label);
        driver.findElement(menuItemLocator).click();

    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(menuItemLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
}