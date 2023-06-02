package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.java8.En;

public class GeneralStepDefinitions implements En {

    private Config config = ConfigFactory.load().getConfig("com.simetrik");

    public GeneralStepDefinitions(GeneralPage generalPage){
        Given("^I visit the site$", () -> {
        });
        And("^I get the text of tag \"([^\"]*)\"$", (String tag) -> {
            String textTag = generalPage.getElementByCssSelectorClass(config.getString("idClasses.mainClass"),tag).getText();
            System.out.println("The text of the tag " + tag + " is: " + textTag);
        });
        Given("^I visit the site with the broken link$", () -> {
            generalPage.openPage(config.getString("urlBrokenLink"));
        });
        When("^I find a broken link$", () -> {
        });
        And("^I click on broken link$", () -> {
            generalPage.getElementByXpathHref("Broken link found").click();
        });
        Then("^I report the information about the broken link$", () -> {

        });

    }
}
