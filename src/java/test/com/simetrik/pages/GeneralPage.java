package com.simetrik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    public static WebDriver driver;

    public void openPage(String url) {
        driver.get(url);
    }
    public WebElement getElementByCssSelectorClass (String text, String tag) {
        return driver.findElement(By.cssSelector("*[class=" + text + "] " + tag));
    }

    // Examples Implement a method to find elements into a webElement.

    public WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getElementByXpathLabel(String text) {
        return driver.findElement(By.xpath("//label[contains(text(),'" + text + "')]"));
    }

    public WebElement getElementByXpathHref(String text) {
        return driver.findElement(By.xpath("//href[contains(text(),'" + text + "')]"));
    }

}
