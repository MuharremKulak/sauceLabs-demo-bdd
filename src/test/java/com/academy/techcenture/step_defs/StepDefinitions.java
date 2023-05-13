package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.CheckOutPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CheckOutPage checkOutPage;

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

    @And("user is on the product page")
    public void user_Is_On_The_Product_Page() {
        homePage.verifyLoggedInSuccessfully();
    }

    @And("user click Add To Cart Sauce Labs Backpack product")
    public void user_Click_Add_To_Cart_Sauce_Labs_Backpack_Product() {
        productPage = new ProductPage(driver);
        productPage.addToCartSauceLabsProduct();
    }

    @And("user click on Cart link")
    public void userClickOnCartLink() {
        productPage.clickOnCartButton();
    }

    @And("user click on Checkout link")
    public void userClickOnCheckoutLink() {
        productPage.clickOnCheckoutButton();
    }

    @And("user enter a valid firstName {string}")
    public void userEnterAValidFirsName(String firstName) {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterFirstName(firstName);
    }

    @And("user enter a valid lastName {string}")
    public void userEnterAValidLastName(String lastName) {
        checkOutPage.enterLastName(lastName);
    }
    
    @And("user enter a valid zipCode {string}")
    public void userEnterAValidZipCode(String zipCode) {
        checkOutPage.enterZipCode(zipCode);
    }


    @And("user click on Continue link")
    public void userClickOnContinueLink() {
        checkOutPage.clickOnContinueButton();
    }

    @And("user click on Finish link")
    public void userClickOnFinishLink() {
        checkOutPage.clickOnFinishButton();
    }

    @Then("user should see Thank you message")
    public void userShouldSeeThankYouMessage() {
        checkOutPage.verifyThankYouMessage();
    }
}
