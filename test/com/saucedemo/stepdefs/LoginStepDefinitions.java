package com.saucedemo.stepdefs;

import com.saucedemo.pages.GeneralPage;
import com.saucedemo.pages.LoginPage;
import cucumber.api.java8.En;

public class LoginStepDefinitions implements En {
    public LoginStepDefinitions(GeneralPage generalPage, LoginPage loginPage) {

        Given("^I visit the site saucedemo$", () -> {
            loginPage.openPage();
        });
        And("^I type my username into the \"([^\"]*)\" field$", (String username) -> {
            generalPage.getElementByName(username).sendKeys("standard_user");
        });
        And("^I type my password into the \"([^\"]*)\" field$", (String password) -> {
            generalPage.getElementByName(password).sendKeys("secret_sauce");
        });
        And("^I click on \"([^\"]*)\" button$", (String buttonId) -> {
            generalPage.getElementById(buttonId).click();
        });


    }
}
