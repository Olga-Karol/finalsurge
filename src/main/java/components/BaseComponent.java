package components;

import base.BaseClass;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends BaseClass {

    public BaseComponent(WebDriver driver) {
        super(driver);
    }

        abstract public boolean isComponentDisplayed();
    }