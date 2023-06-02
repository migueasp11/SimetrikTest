#language: en

Feature: Get the text of specific tag

  Scenario: Get text of tag
    Given I open the local HTML file "tags.html"
    And I get tag "h2" with the text "Resources"
    And I get tag "p" with the text "JSONPlaceholder comes with a set of 6 common resources:"