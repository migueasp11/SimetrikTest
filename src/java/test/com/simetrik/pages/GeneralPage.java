package com.simetrik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralPage {
    public static WebDriver driver;

    public void openPage(String url) {
        driver.get(url);
    }
    public WebElement getElementByCssSelectorClass (String nameClass, String tag, String position) {
        return driver.findElement(By.cssSelector(String.format("main.%s > %s:nth-of-type(%s)",nameClass,tag,position)));
    }

    // Examples Implement a method to find elements into a webElement.

    public WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

        public WebElement getElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public WebElement getElementByXpathLabel(String text) {
        return driver.findElement(By.xpath("//label[contains(text(),'" + text + "')]"));
    }

    public WebElement getElementByXpathHref(String text) {
        return driver.findElement(By.xpath("//href[contains(text(),'" + text + "')]"));
    }

    public List<WebElement> getElementsByTagA(){
        return driver.findElements(By.tagName("a"));
    }

}
