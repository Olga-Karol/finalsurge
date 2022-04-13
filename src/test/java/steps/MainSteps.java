package steps;

import components.addworkoutleftmenu.WorkoutType;
import components.links.BaseLink;
import components.links.Link;
import components.mainmenu.MainMenuItem;
import components.mainmenu.submenu.SubMenuItem;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;
import static base.BaseTest.EMAIL;
import static base.BaseTest.PASSWORD;
import static constants.MainMenuLabels.*;
import static constants.ProfileElements.LOG_OUT;


public class MainSteps extends BaseStep{

    private LoginPage loginPage;
    private CalendarPage calendarPage;
    private MainMenuItem mainMenuItem;
    private SubMenuItem subMenuItem;
    private AddWorkoutPage addWorkout;
    private BaseLink link;
    private LogoutPage logoutPage;
    private VitalsPage vitalsPage;
    private WorkoutType workoutType;

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public MainSteps openFinalSurgeLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.waitPageLoaded();
        assertPageIsLoaded(loginPage);
        return this;
    }

    @Step ("Authentication")
    public MainSteps validCredentialsLogin() {
        loginPage.authentication(EMAIL, PASSWORD);
        calendarPage = new CalendarPage(driver);
        calendarPage.waitPageLoaded();
        assertPageIsLoaded(calendarPage);
        return this;
    }

    @Step ("Open Add Workout page")
    public WorkoutSteps openAddWorkoutPage(){
        mainMenuItem = new MainMenuItem(driver, WORKOUTS_ITEM_LABEL);
        assertComponentIsDisplayed(mainMenuItem);
        mainMenuItem.hover();
        subMenuItem = new SubMenuItem(driver, SUBMENU_ADD_WORKOUT_LABEL);
        assertComponentIsDisplayed(subMenuItem);
        subMenuItem.click();
        addWorkout = new AddWorkoutPage(driver);
        assertPageIsLoaded(addWorkout);
        return new WorkoutSteps(driver);
    }

    @Step ("Open Add Vitals page")
    public DailyVitalsSteps openDailyVitalsPage(){
        mainMenuItem = new MainMenuItem(driver, DAILY_VITALS_ITEM_LABEL);
        assertComponentIsDisplayed(mainMenuItem);
        mainMenuItem.hover();
        subMenuItem = new SubMenuItem(driver, SUBMENU_VIEW_ADD_VITALS);
        assertComponentIsDisplayed(subMenuItem);
        subMenuItem.click();
        vitalsPage = new VitalsPage(driver);
        vitalsPage.waitPageLoaded();
        assertPageIsLoaded(vitalsPage);
        return new DailyVitalsSteps(driver);
    }

    @Step("Log out")
    public void logOut(){
        BaseLink link = new Link(driver, LOG_OUT);
        link.click();
        assertPageIsLoaded(new LogoutPage(driver));
    }
}
