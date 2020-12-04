Feature: Create customer


  Scenario Outline: Create a new customer
    Given First Name is "<firstName>"
    And Last Name is "<lastName>"
    And Birth Date is <birthDate>
    When I create customer
    Then I should receive a customer id"

    Examples:
      | firstName  | lastName  | birthDate   |
      | Jonh       | Doe       |  1984-05-11 |
      | Jane       | Doe       |  1979-06-79 |


