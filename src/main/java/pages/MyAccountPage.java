package pages;

import base.BasePage;
import ngelements.NGButton;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[contains(@title, 'Orders')]")
    private NGButton orderHistoryAndDetailsButton;

    public MyAccountPage(WebDriver driver) {
        super(driver, "/index.php?controller=my-account");
    }

    @Override
    protected void load() {
        driver.get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(getUrl(), driver.getCurrentUrl());
    }

    @Override
    public boolean isInitialized() {
        return orderHistoryAndDetailsButton.exists();
    }
}
