package components.calendarelements;

import components.BaseComponent;
import components.addworkoutleftmenu.WorkoutType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static components.calendarelements.WorkoutLink.getWorkoutId;

public class Dropdown extends BaseComponent {

    public static final String DROPDOWN_MENU_LOCATOR_PATTERN = "//div[contains(text(), '%s')]";
    public static final String DROPDOWN_OPTIONS_LOCATOR_PATTERN = "//div[contains(text(), '%s')]//ancestor::div[contains (@class,'ui-droppable open')]//ul";
    public static final String MENU_OPTION_LOCATOR_PATTERN = "//a[@data-key='%s' and text() ='%s']";

    String workoutName;
    By dropdownMenuLocator;
    By dropdownOptionsLocator;
    Logger log = LogManager.getLogger(Dropdown.class);

    public Dropdown(WebDriver driver, String workoutName) {
        super(driver);
        this.workoutName=workoutName;
        dropdownMenuLocator = By.xpath(String.format(DROPDOWN_MENU_LOCATOR_PATTERN, workoutName));
        dropdownOptionsLocator = By.xpath(String.format(DROPDOWN_OPTIONS_LOCATOR_PATTERN, workoutName));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenuLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }


    public void selectOption(String optionLabel){
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptionsLocator));
        String workoutId = getWorkoutId();
        By menuOptionLocator = By.xpath(String.format(MENU_OPTION_LOCATOR_PATTERN, workoutId, optionLabel));
        log.info("Click [{}] option in context menu action for workoutId [{}]", optionLabel, workoutId);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(menuOptionLocator));
    }
}
