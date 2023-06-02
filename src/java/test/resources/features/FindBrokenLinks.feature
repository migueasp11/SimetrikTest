#language: en

Feature: Find broken links

  Scenario: Find broken link
    Given I visit the site with the broken link
    When I find a broken link
    And I click on broken link
    Then I report the information about the broken link

