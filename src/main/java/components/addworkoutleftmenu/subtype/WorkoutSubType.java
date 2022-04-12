package components.addworkoutleftmenu.subtype;

import components.BaseComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkoutSubType extends BaseComponent {

    public static final String SUB_LINK_LOCATOR = "//a[(text()='%s')]/ancestor::li[@class='subtypeselector']/a";
    private String label;
    private By LinkLocator;

    Logger log = LogManager.getLogger(WorkoutSubType.class);

    public WorkoutSubType(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.LinkLocator = By.xpath(String.format(SUB_LINK_LOCATOR, label));
    }

    public void click() {
        log.info("Click [{}] subtype", label);
        driver.findElement(LinkLocator).click();
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LinkLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
}