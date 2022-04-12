package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.DailyVitalsSteps;
import steps.MainSteps;
import steps.PostconditionSteps;
import steps.WorkoutSteps;
import utils.CapabilitiesGenerator;
import utils.PropertiesUtils;
import utils.TestListener;
import java.time.Duration;


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
        setContextAttribute(iTestContext, "driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
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
