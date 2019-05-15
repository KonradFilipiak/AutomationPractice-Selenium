package managers;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(Logger.class.getName());

    private SignInPage signInPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage() {
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
    }

    public BasePage getPageByName(String pageName) {
        BasePage page = null;

        switch (pageName.toLowerCase()) {
            case "sign in":
                page = getSignInPage();
                break;
            default:
                log.error("There is no such page in PageObjectManager as: \"%s\"", pageName);
                break;
        }

        return page;
    }
}
