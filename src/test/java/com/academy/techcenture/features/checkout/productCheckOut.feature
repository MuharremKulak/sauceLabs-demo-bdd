Feature: SauceLabs Product Checkout Feature

  Scenario: Successful product selection checkout
    Given user is on the home page
    When user enters a valid username "standard_user"
    And user enters a valid password "secret_sauce"
    And user enters on the login button
    And user is on the product page
    And user click Add To Cart Sauce Labs Backpack product
    And user click on Cart link
    And user click on Checkout link
    And user enter a valid firstName "Kevin"
    And user enter a valid lastName "Lee"
    And user enter a valid zipCode "22201"
    And user click on Continue link
    And user click on Finish link
    Then user should see Thank you message


