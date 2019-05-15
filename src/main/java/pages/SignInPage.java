package pages;

import base.BasePage;
import ngelements.NGButton;
import ngelements.NGTextBlock;
import ngelements.NGTextInput;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    private NGTextInput signInEmailInput;

    @FindBy(id = "passwd")
    private NGTextInput passwordInput;

    @FindBy(id = "SubmitLogin")
    private NGButton signInButton;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger')]/ol")
    private NGTextBlock loginErrorMessage;

    public SignInPage(WebDriver driver) {
        super(driver, "/index.php?controller=authentication&back=my-account");
    }

    @Override
    protected void load() {
        driver.get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertEquals(getUrl(), driver.getCurrentUrl());
    }

    public void logIn(String email, String password) {
        provideSignInEmail(email);
        providePassword(password);
        clickSignInButton();
    }

    public void provideSignInEmail(String email) {
        signInEmailInput.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordInput.sendVulnerableData(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isLoginErrorMessageVisible() {
        return loginErrorMessage.exists();
    }
}
