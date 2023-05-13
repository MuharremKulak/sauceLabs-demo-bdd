package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    protected WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    protected WebElement passwordInput;

    @FindBy(how = How.ID, using = "login-button")
    protected WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    protected WebElement productPageTitle;

    @FindBy(how = How.XPATH, using = "//div[@id='login_button_container']/div/form/div[3]/h3")
    protected WebElement errorMessage;

    public void verifyHomePageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals("Home Page Title is not matched!",expectedTitle, actualTitle);
    }

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(2000);

    }

    public void verifyLoggedInSuccessfully(){
        String actualProductPageTitle = productPageTitle.getText();
        String expectedProductPageTitle = "Products";
        Assert.assertEquals("Title is not matched! User Login is not successful!",expectedProductPageTitle, actualProductPageTitle);
    }

    public void errorMessage(){
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals("User doesn't see error message!",expectedErrorMessage,errorMessage.getText());
    }

    public void enterInvalidPassword(String invalidPassword) {
        passwordInput.sendKeys(invalidPassword);
    }

}
