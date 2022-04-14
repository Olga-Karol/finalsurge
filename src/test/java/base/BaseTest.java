package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.DailyVitalsSteps;
import steps.MainSteps;
import steps.WorkoutSteps;
import utils.CapabilitiesGenerator;
import utils.PropertiesUtils;
import utils.TestListener;
import java.time.Duration;

import static constants.BaseConstants.ATTRIBUTE_KEY_DRIVER;
import static constants.BaseConstants.IMPLICIT_WAIT_DURATION_SEC;


@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected WorkoutSteps workoutSteps;
    protected DailyVitalsSteps dailyVitalsSteps;

    public static String EMAIL = PropertiesUtils.getEnv("valid_email");
    public static String PASSWORD = PropertiesUtils.getEnv("valid_password");

    @BeforeMethod
    public void setup(ITestContext iTestContext){
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().deleteAllCookies();
        setContextAttribute(iTestContext, ATTRIBUTE_KEY_DRIVER, driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_DURATION_SEC));
        mainSteps = new MainSteps(driver);
        workoutSteps = new WorkoutSteps(driver);
        dailyVitalsSteps = new DailyVitalsSteps(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun=true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
