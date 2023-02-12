package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralPage {
    WebDriver driver = new ChromeDriver();
    public WebElement getElementById (String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getElementByName (String name) {
        return driver.findElement(By.name(name));
    }
}
