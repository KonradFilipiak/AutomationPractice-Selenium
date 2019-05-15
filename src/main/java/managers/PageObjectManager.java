package managers;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;
import sections.HeaderSection;

public class PageObjectManager {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger(Logger.class.getName());

    private SignInPage signInPage;
    private MyAccountPage myAccountPage;

    private HeaderSection headerSection;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage() {
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
    }

    public MyAccountPage getMyAccountPage() {
        return (myAccountPage == null) ? myAccountPage = new MyAccountPage(driver) : myAccountPage;
    }

    public HeaderSection getHeaderSection() {
        return (headerSection == null) ? headerSection = new HeaderSection(driver) : headerSection;
    }


    public BasePage getPageByName(String pageName) {
        BasePage page = null;

        switch (pageName.toLowerCase()) {
            case "sign in":
                page = getSignInPage();
                break;
            case "my account":
                page = getMyAccountPage();
                break;
            default:
                log.error("There is no such page in PageObjectManager as: \"%s\"", pageName);
                break;
        }

        return page;
    }
}
