#language: en

Feature: Find broken links

  Scenario: Find broken link
    Given I visit the site with the broken link
    When I find broken links
    Then I report the information about broken links

