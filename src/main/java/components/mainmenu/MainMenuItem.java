package components.mainmenu;

import components.BaseComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainMenuItem extends BaseComponent {

    public static final String MENU_ITEM_LOCATOR = "//a[@class='arrow_down' and text()='%s']";
    private String label;
    private WebElement menuItem;
    private By menuItemLocator;

    Logger log = LogManager.getLogger(MainMenuItem.class);

    public MainMenuItem(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.menuItemLocator = By.xpath(String.format(MENU_ITEM_LOCATOR, label));
        this.menuItem = driver.findElement(menuItemLocator);
    }

    public void hover() {
        log.info("Move mouse cursor to [{}] in top menu", label);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuItem).perform();
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