package sections;

import base.BaseSection;
import ngelements.NGButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderSection extends BaseSection {

    @FindBy(xpath = "//div[contains(@class, 'header_user_info')]/a[contains(@class, 'login')]")
    private NGButton signInButton;

    @FindBy(id = "contact-link")
    private NGButton contactUsButton;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isInitialized() {
        return contactUsButton.exists();
    }
}
