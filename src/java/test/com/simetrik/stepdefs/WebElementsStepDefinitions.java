package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.simetrik.utils.RestUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WebElementsStepDefinitions implements En {

    private Config config = ConfigFactory.load().getConfig("com.simetrik");

    public WebElementsStepDefinitions(GeneralPage generalPage){

        Given("^I visit the site webtables$", () -> {
            generalPage.openPage(config.getString("urlWebTable"));
        });
        Then("^I find all elements into the first column of the table$", () -> {
            WebElement parentElement = generalPage.getElementByCssSelector("div.rt-tbody");
            List<WebElement> elements = parentElement.findElements(By.cssSelector("div.rt-td:nth-child(1)"));
            List<String> firstColumn = elements.stream().map(WebElement::getText).filter(x -> !x.trim().isEmpty()).collect(Collectors.toList());
            System.out.println(firstColumn);
            Assert.assertEquals(firstColumn, Arrays.asList("Cierra", "Alden", "Kierra"));

        });

    }
}
