package steps;

import components.calendarelements.Dropdown;
import components.calendarelements.WorkoutLink;
import io.qameta.allure.Step;
import modals.DeleteConfirmation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CalendarPage;

import java.util.List;

import static constants.WorkoutContextMenuOption.WORKOUT_CONTEXT_MENU_OPTION;
import static constants.TextParserConstants.COLON;
import static utils.WorkoutDetailsParser.defaultParser;

public class PostconditionSteps extends BaseStep {

    public static final By WORKOUT_TITLE_IN_CALENDAR = By.xpath("//div[@class='fc-event-activity-title']");

    private DeleteConfirmation deleteConfirmation;
    private CalendarPage calendarPage;
    private WorkoutLink workoutLink;
    private Dropdown dropdown;

    public PostconditionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Find added workout(s) and remove it")
    public void removeTestWorkouts(String testWorkoutName) {
        calendarPage = new CalendarPage(driver);
        calendarPage.openPage();
        assertPageIsLoaded(calendarPage);
        List<WebElement> workouts = driver.findElements(WORKOUT_TITLE_IN_CALENDAR);
        for (WebElement workout : workouts) {
            String workoutTitle = defaultParser(workout.getText(), COLON, 0);
            if (workoutTitle.equals(testWorkoutName))
                try {
                    deleteAddedWorkout(workoutTitle);
                } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                    deleteAddedWorkout(workoutTitle);
                }
        }
    }

    private void deleteAddedWorkout(String workoutName) {
        workoutLink = new WorkoutLink(driver, workoutName);
        workoutLink.clickWorkout();
        dropdown = new Dropdown(driver, workoutName);
        dropdown.selectOption(WORKOUT_CONTEXT_MENU_OPTION);
        deleteConfirmation = new DeleteConfirmation(driver);
        deleteConfirmation.isComponentDisplayed();
        deleteConfirmation.deleteConfirmation();
    }
}



