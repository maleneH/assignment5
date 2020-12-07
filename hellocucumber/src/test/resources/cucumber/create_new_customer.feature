Feature: Create New Customer

    Scenario Outline: Create a new customer
        Given customers first name is "<first name>"
        And customers last name is "<last name>"
        Then Create a new customer

        Examples:
            | first name | last name |
            | John       | Doe       |
            | Jane       | Doe       |