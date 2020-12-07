Feature: Employees


  Scenario Outline: Create a new employee
    Given employees first name is "<first name>"
    And employees last name is "<last name>"
    Then create a new employee

    Examples:
      | first name | last name |
      | John       | Doe       |
      | Jane       | Doe       |




  Scenario Outline: Create a work time block
    Given an employee id <id>
    And a date "<d/MM/yyyy>"
    And work time start "<start>"
    And work time end "<end>"
    Then create a work time block

    Examples:
    id | d/MM/yyyy  | start  | end   |
     1 | 30/12/2020 | 10,00  | 16,00 |
     2 | 27/12/2020 | 12,00  | 18,00 |