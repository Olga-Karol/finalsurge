package steps;


import components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public class BaseStep {

    WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void assertPageIsLoaded(BasePage page) {
        Assert.assertTrue(
                page.isPageLoaded(),
                page.getClass().getSimpleName().concat(" is not opened: ")
        );
    }

    public void assertComponentIsDisplayed(BaseComponent component) {
        Assert.assertTrue(
                component.isComponentDisplayed(),
                component.getClass().getSimpleName().concat(" not displayed")
        );
    }
}
