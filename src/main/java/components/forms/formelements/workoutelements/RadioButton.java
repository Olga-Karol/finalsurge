package components.forms.formelements.workoutelements;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseComponent {

    private static final String RADIO_BUTTON_OPTION_LOCATOR_PATTERN =
            "//span[text()='%s']/ancestor::label//input";
    private String option;
    private By radioButtonLocator;


    public RadioButton(WebDriver driver, String option) {
        super(driver);
        this.option = option;
        this.radioButtonLocator = By.xpath(String.format(RADIO_BUTTON_OPTION_LOCATOR_PATTERN, option));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(radioButtonLocator).isDisplayed();
    }

    public void selectOption(){
        driver.findElement(radioButtonLocator).click();
    }
}
