Feature: Validate the submenu of LivingStorage Option

  Scenario: validating the submenu under LivingStorage
    Given the user close the popup
    When the user clicks on the LivingStorage Option
    Then the user should able to see the submenu present under that option
