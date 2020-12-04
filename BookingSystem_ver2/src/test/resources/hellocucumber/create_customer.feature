Feature: Create customer


  Scenario Outline: Create a new customer
    Given First Name is "<firstName>"
    And Last Name is "<lastName>"
    When I create customer
    Then I should receive a customer id"

    Examples:
      | firstName  | lastName  |
      | Jonh       | Doe       |
      | Jane       | Doe       |


