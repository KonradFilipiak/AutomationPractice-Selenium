package steps;

import base.BaseTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

public class LoginSteps extends BaseTest {

    @When("^User logs? in with (valid credentials|wrong password|empty password|empty email|invalid email|wrong email|empty credentials)$")
    public void userLogsInWith(String condition) {
        String email = "";
        String password = "";

        switch (condition) {
            case "valid credentials":
                email = propertiesLoader.getUserEmail();
                password = propertiesLoader.getUserPassword();
                break;
            case "wrong password":
                email = propertiesLoader.getUserEmail();
                password = "WrongPassword1!";
                break;
            case "empty password":
                email = propertiesLoader.getUserEmail();
                break;
            case "empty email":
                password = propertiesLoader.getUserPassword();
                break;
            case "invalid email":
                email = "invalid-email";
                password = propertiesLoader.getUserPassword();
                break;
            case "wrong email":
                email = "example-of-wrong-email@konradfilipiak.com";
                password = propertiesLoader.getUserPassword();
                break;
            case "empty credentials":
                break;
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
