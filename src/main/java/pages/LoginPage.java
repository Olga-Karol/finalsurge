package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private static final String BASE_URL = "https://log.finalsurge.com/login.cshtml";

    public static final By EMAIL = By.id("login_name");
    public static final By PASSWORD = By.id("login_password");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");


    Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
        setExplicitlyWaitTimeout(10);
    }

    @Override
    public void waitPageLoaded(){
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
       }

    public void authentication(String email, String password){
        log.info("Insert [{}] into [{}] field", email, "email");
        driver.findElement(EMAIL).sendKeys(email);
        log.info("Insert [{}] into [{}] field", "*******", "password");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Click [{}] button", "Login");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
