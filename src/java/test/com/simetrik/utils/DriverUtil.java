package com.simetrik.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static com.simetrik.pages.GeneralPage.driver;
import static org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE;

public class DriverUtil {
    public static WebDriver getDefaultDriver(String browser) {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(browser)) {
                return createWebDriverChrome();
            } else {
                return createWebDriverFirefox();
            }
        } else  {
            return driver;
        }
    }

    private static WebDriver createWebDriverChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setUnhandledPromptBehaviour(IGNORE);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private static WebDriver createWebDriverFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        options.setUnhandledPromptBehaviour(IGNORE);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


    public static void closePage () {
        driver.quit();
    }
}
