Feature: YearBalance lifecycle

  Scenario: Initial yearBalance list is empty
    Given there are 1 yearBalances

  Scenario: Find by year
    When yearBalance year=2021 is retrieved
    And yearBalance year=2021 is retrieved by id

  Scenario: Find by year not found
    When yearBalance year=2020 is not found
