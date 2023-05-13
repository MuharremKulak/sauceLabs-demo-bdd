package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }



}
