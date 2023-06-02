#language: en

Feature: Get json information

  Scenario: Get the information
    Given I send the url request
    And I get succesful status
    And I get the json with the response