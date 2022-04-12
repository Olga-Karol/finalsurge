package components.calendarelements;

import components.BaseComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WorkoutLink extends BaseComponent {

    public static final String WORKOUT_LINK_LOCATOR_PATTERN = "//div[contains(text(), '%s')]//ancestor::div[contains(@class,'ui-droppable')]";

    private String workoutName;
    private static By workoutLinkLocator;
    Logger log = LogManager.getLogger(WorkoutLink.class);


    public WorkoutLink(WebDriver driver, String workoutName) {
        super(driver);
        this.workoutName = workoutName;
        this.workoutLinkLocator = By.xpath(String.format(WORKOUT_LINK_LOCATOR_PATTERN, workoutName));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(workoutLinkLocator).isDisplayed();
    }

    public void clickWorkout(){
        log.info("Open workout update page");
        driver.findElement(workoutLinkLocator).click();
    }

    public static String getWorkoutId(){
        return driver.findElement(workoutLinkLocator).getAttribute("data-wkey");
    }
}
