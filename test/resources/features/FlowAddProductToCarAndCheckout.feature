#language: en

  Feature: checkout product

    Scenario Outline: Add product to cart, checkout and validate item name
      Given  I visit the site saucedemo
      And I type my username into the "user-name" field
      And I type my password into the "password" field
      And I click on "login-button" button
      When I see the "inventory_container" screen
      And I get the item name text "<item-name>"
      And I click on "<add-to-cart>" button
      And I click on "shopping_cart_container" button
      And I see the "cart_contents_container" screen
      Then I get the item name text "<item-name>" and is the same that I got before
      And I click on "checkout" button
      And I type "Jhon" into the "firstName" field
      And I type "Doe" into the "lastName" field
      And I type "050035" into the "postalCode" field
      And I click on "continue" button
      And I see the "checkout_summary_container" screen
      Then I get the item name text "<item-name>" and is the same that I got before
      And I click on "finish" button
      And I see the "checkout_complete_container" screen

      Examples:
        | item-name         | add-to-cart                     |
        | item_4_title_link | add-to-cart-sauce-labs-backpack |





