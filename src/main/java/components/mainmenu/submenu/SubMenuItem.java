package components.mainmenu.submenu;

import components.BaseComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubMenuItem extends BaseComponent {

    public static final String MENU_BUTTON_LOCATOR = "//a[text()='%s']";
    private String label;
    private WebElement menuButton;
    private By buttonLocator;

    Logger log = LogManager.getLogger(SubMenuItem.class);

    public SubMenuItem(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(MENU_BUTTON_LOCATOR, label));
        this.menuButton = driver.findElement(buttonLocator);
    }

    public void click() {
        Actions actions = new Actions(driver);
        log.info("Move mouse cursor to [{}] in submenu and click it", label);
        actions.moveToElement(menuButton).click().perform();
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
}