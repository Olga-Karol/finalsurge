package modals;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteConfirmation extends BaseComponent {

    public static final By MODAL_TITLE_LOCATOR = By.className("modal-body");
    public static final By OK_BUTTON_LOCATOR = By.xpath("//a[text()='OK']");


    public DeleteConfirmation(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_TITLE_LOCATOR));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void deleteConfirmation(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(OK_BUTTON_LOCATOR));
    }

}
