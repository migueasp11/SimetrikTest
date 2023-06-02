package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.simetrik.utils.RestUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.java8.En;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralStepDefinitions implements En {

    private Config config = ConfigFactory.load().getConfig("com.simetrik");

    public GeneralStepDefinitions(GeneralPage generalPage){
        Given("^I visit the site$", () -> {
        });
        And("^I get the text of tag \"([^\"]*)\"$", (String tag) -> {
            String textTag = generalPage.getElementByCssSelectorClass(config.getString("idClasses.mainClass"),tag,"2").getText();
            System.out.println("The text of the tag " + tag + " is: " + textTag);
        });
        Given("^I visit the site with the broken link$", () -> {
            generalPage.openPage(config.getString("urlBrokenLink"));
        });
        When("^I find broken links$", () -> {
            List<String> links = generalPage.getElementsByTagA().stream().map(webElement -> {
                return webElement.getAttribute("href");
            }).map(link -> {
                RestUtil.isBrokenLink(link).map(isBrokenLink -> {
                    System.out.println("Link " + link + "is broken: " + isBrokenLink );
                    return isBrokenLink;
                })
            }).collect(Collectors.toList());

        });
        Then("^I report the information about broken links$", () -> {

        });

    }
}
