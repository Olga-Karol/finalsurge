package components.links;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class BaseLink extends BaseComponent {

    String linkName;
    String linkLocatorPattern;
    By linkLocator;


    public BaseLink(WebDriver driver, String linkName, String linkLocatorPattern) {
        super(driver);
        this.linkName = linkName;
        this.linkLocatorPattern = linkLocatorPattern;
        this.linkLocator = By.xpath(String.format(linkLocatorPattern, linkName));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.elementToBeClickable(linkLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void click(){
        driver.findElement(linkLocator).click();
    }



}
