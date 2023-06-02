package com.simetrik.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class RestUtil {

    public static Response sendAndGetResponse(String url) {
        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.get();
    }

    public static Optional<Boolean> isBrokenLink(String linkUrl){
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            return Optional.of(httpURLConnect.getResponseCode() >= 400);

        }catch(Exception e){
            return Optional.empty();
        }
    }

}
