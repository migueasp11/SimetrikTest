package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.simetrik.utils.RestUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BrokenLinksStepDefinitions implements En {

    private Config config = ConfigFactory.load().getConfig("com.simetrik");

    public BrokenLinksStepDefinitions(GeneralPage generalPage){

        Given("^I visit the site with the broken link$", () -> {
            generalPage.openPage(config.getString("urlBrokenLink"));
        });
        When("^I validate broken links$", () -> {
            List<Boolean> links = generalPage.getElementsByTagA().stream().map(webElement -> {
                return webElement.getAttribute("href");
            })
            .filter(Objects::nonNull)
            .map(link -> {
                return RestUtil.isBrokenLink(link).map(isBrokenLink -> {
                    System.out.println("Link " + link + " is broken: " + isBrokenLink );
                    return isBrokenLink;
                }).orElseGet(() -> {
                    System.out.println("There was an error validating the link " + link);
                    return false;
                });
            }).collect(Collectors.toList());

            List<Boolean> brokenLinks = links.stream().filter(x -> x).collect(Collectors.toList());
            List<Boolean> validLinks = links.stream().filter(x -> !x).collect(Collectors.toList());
            Assert.assertEquals(brokenLinks.size(), 1);
            Assert.assertEquals(validLinks.size(), 2);

        });
    }
}
