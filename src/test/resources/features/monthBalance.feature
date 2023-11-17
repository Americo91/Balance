Feature: MonthBalance lifecycle

  Scenario: Initial monthBalance list is empty
    Given there are 0 monthBalance

  Scenario: Find by month
    Given there are 0 monthBalance with Month "APRIL"
