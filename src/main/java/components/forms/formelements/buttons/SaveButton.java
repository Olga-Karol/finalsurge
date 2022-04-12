package components.forms.formelements.buttons;

import components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveButton extends BaseComponent {

    private static final String UPDATE_SAVE_BUTTON_PATTERN = "input[value='%s'][id='saveButton']";

    private String label;
    private By buttonLocator;


    public SaveButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.cssSelector(String.format(UPDATE_SAVE_BUTTON_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void save(){
        driver.findElement(buttonLocator).click();
    }
}
