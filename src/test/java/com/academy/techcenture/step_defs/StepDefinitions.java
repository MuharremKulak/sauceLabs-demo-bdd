package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        driver = Driver.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters a valid username {string}")
    public void user_enters_a_valid_username(String username) {
        homePage = new HomePage(driver);
        homePage.verifyHomePageTitle();
        homePage.enterUsername(username);
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        homePage.enterPassword(password);
    }

    @When("user enters on the login button")
    public void user_enters_on_the_login_button() throws InterruptedException {
        homePage.clickOnLoginButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        homePage.verifyLoggedInSuccessfully();
    }

    @Then("user should see error message")
    public void user_should_see_error_message() {
        homePage.errorMessage();
    }

    @And("user enters a invalid password {string}")
    public void userEntersAInvalidPassword(String invalidPassword) {
        homePage.enterInvalidPassword(invalidPassword);
    }
}
