package com.nextBaseCRM.step_definitions;

import com.nextBaseCRM.pages.LoginPage;
import com.nextBaseCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class CRMLoginStepDefinitions {

    //private static final Logger log = LoggerFactory.getLogger(CRMLoginStepDefinitions.class);
    LoginPage loginPage = new LoginPage();


    @Given("user on the login page")
    public void user_on_the_login_page() {
        //Driver.getDriver().get("url");
        Driver.getDriver().get("https://login1.nextbasecrm.com");
    }

    @When("user entered valid username")
    public void userEnteredValidUsername() {
        loginPage.enterValidUserName();
    }

    @And("entered valid password")
    public void enteredValidPassword() {
        loginPage.enterValidPassword();
    }


    @When("clicked on login button")
    public void clicked_on_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("User {string} in")
    public void userIn(String status) {
    }

    @Then("User successfully logged in")
    public void user_successfully_logged_in() {
        System.out.println("The current text is: " + loginPage.loginVerification());
        Assert.assertEquals("CRM",loginPage.loginVerification());
    }


    @When("user entered invalid username")
    public void userEnteredInvalidUsername() {
        loginPage.enterInvalidUserName();
    }

    @And("entered invalid password")
    public void enteredInvalidPassword() {
        loginPage.enterInvalidPassword();
    }

    @Then("Incorrect login or password message popped up")
    public void incorrectLoginOrPasswordMessagePoppedUp(){
        System.out.println("The current message: " + loginPage.getErrorText());
        Assert.assertEquals("Incorrect login or password",loginPage.getErrorText());
    }
}
