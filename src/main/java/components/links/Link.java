package components.links;

import org.openqa.selenium.WebDriver;

public class Link extends BaseLink {

    public static final String PROFILE_LINK_LOCATOR_PATTERN = "//a[text()='%s']";


   public Link(WebDriver driver, String linkName) {
        super(driver, linkName, PROFILE_LINK_LOCATOR_PATTERN );

    }
}
