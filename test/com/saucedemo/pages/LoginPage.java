package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {

    public void openPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        }


    }

