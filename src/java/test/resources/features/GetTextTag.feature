#language: en

Feature: Get the text of specific tag

  Scenario: Get text of tag
    Given I visit the site
    And I get the text of tag "h2"
    And I get the text of tag "p"