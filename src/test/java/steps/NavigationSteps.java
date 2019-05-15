package steps;

import base.BasePage;
import base.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class NavigationSteps extends BaseTest {

    @Given("^User is on \"([^\"]*)\" page$")
    public void userIsOnPage(String pageName) {
        BasePage page = pages.getPageByName(pageName);
        page.get();
    }

    @Then("^User is redirected to \"([^\"]*)\" page$")
    public void userIsRedirectedToPage(String pageName) {
        BasePage page = pages.getPageByName(pageName);
        Assert.assertTrue(page.isInitialized());
    }
}
