package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "first-name")
    protected WebElement firstNameInput;

    @FindBy(how = How.ID, using = "last-name")
    protected WebElement lastNameInput;

    @FindBy(how = How.ID, using = "postal-code")
    protected WebElement postalCodeInput;

    @FindBy(how = How.ID, using = "continue")
    protected WebElement continueButton;

    @FindBy(how = How.ID, using = "finish")
    protected WebElement finishButton;

    @FindBy(how = How.XPATH, using = "//div[@id='checkout_complete_container']/h2")
    protected WebElement thankYouMessage;

    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        postalCodeInput.sendKeys(zipCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }

    public void verifyThankYouMessage(){
        String actualThankYouMessage = thankYouMessage.getText();
        String expectedThankYouMessage = "Thank you for your order!";
        Assert.assertEquals("Thank you messages are not matched!",expectedThankYouMessage,actualThankYouMessage);
    }
}
