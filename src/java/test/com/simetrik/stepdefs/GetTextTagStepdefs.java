package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.java8.En;
import org.testng.Assert;

public class GetTextTagStepdefs implements En {
    private Config config = ConfigFactory.load().getConfig("com.simetrik");

    public GetTextTagStepdefs(GeneralPage generalPage) {
        Given("^I open the local HTML file \"([^\"]*)\"$", (String file) -> {
            generalPage.openPage(getClass().getClassLoader().getResource("html/tags.html").toString());
        });
        And("^I get tag \"([^\"]*)\" with the text \"([^\"]*)\"$", (String tag, String expectedText) -> {
            String textTag = generalPage.getElementByCssSelectorClass(config.getString("idClasses.mainClass"),tag,"2").getText();
            System.out.println("The text of the tag " + tag + " is: " + textTag);
            Assert.assertEquals(textTag, expectedText);
        });
    }
}
