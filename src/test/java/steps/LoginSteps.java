package steps;

import base.BaseTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class LoginSteps extends BaseTest {

    @When("^User logs? in with valid credentials$")
    public void userLogsInWith() {
        String email = propertiesLoader.getUserEmail();
        String password = propertiesLoader.getUserPassword();

        pages.getSignInPage().logIn(email, password);
    }

    @When("^User logs? in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userLogsInWith(String email, String password) {
        if (email.equals("correct-email")) {
            email = propertiesLoader.getUserEmail();
        }

        pages.getSignInPage().logIn(email, password);
    }

    @Then("^Login error message is shown: \"([^\"]*)\"$")
    public void loginErrorMessageIsShown(String expectedMessage) {
        try {
            Assert.assertEquals(expectedMessage, pages.getSignInPage().getLoginErrorMessage());
        } catch (NoSuchElementException e) {
            Assert.fail("Login error message is not visible");
        }
    }

    @Then("^User (is|is not) logged in$")
    public void userLoggedIn(String condition) {
        switch (condition) {
            case "is":
                Assert.assertTrue(pages.getHeaderSection().isUserLoggedIn());
                break;
            case "is not":
                Assert.assertTrue(pages.getHeaderSection().isUserLoggedOut());
                break;
        }
    }
}
