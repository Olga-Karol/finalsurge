package components.links;

import org.openqa.selenium.WebDriver;

public class IconLink extends BaseLink {

    public static final String DELETE_LINK_LOCATOR_PATTERN = "//a[@title='%s']";


    public IconLink(WebDriver driver, String linkName) {
        super(driver, linkName, DELETE_LINK_LOCATOR_PATTERN);
    }
}
