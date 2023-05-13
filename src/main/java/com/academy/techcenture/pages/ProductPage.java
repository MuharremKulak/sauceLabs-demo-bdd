package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;


    public ProductPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    protected WebElement sauceLabsBackpackProduct;

    @FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
    protected WebElement cartButton;

    @FindBy(how = How.ID, using = "checkout")
    protected WebElement checkoutButton;


    public void addToCartSauceLabsProduct(){
        sauceLabsBackpackProduct.click();
    }

    public void clickOnCartButton(){
        cartButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
}

