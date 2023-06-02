#language: en

Feature: Find broken links

  Scenario: Find broken link
    Given I visit the site with the broken link
    Then I validate broken links

