package com.simetrik.stepdefs;

import com.simetrik.pages.GeneralPage;
import com.simetrik.utils.RestUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class BackendStepDefinitions implements En {

    private Config config = ConfigFactory.load().getConfig("com.simetrik");
    private Response response;
    public BackendStepDefinitions(){

        Given("^I send the url request$", () -> {
            response = RestUtil.sendAndGetResponse(config.getString("urlRequest"));
        });
        And("^I get succesful status$", () -> {
            Assert.assertEquals(response.getStatusCode(), 200);
        });

        And("^I get the following json in the response:$", (String jsonString) -> {
            JsonPath actual = response.getBody().jsonPath();
            JsonPath expected = JsonPath.from(jsonString);
            Assert.assertEquals(actual.prettyPrint(), expected.prettyPrint());
        });

    }
}
