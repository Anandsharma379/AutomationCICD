
@tag
Feature: Error Validation
  I want to use this template for my feature file

 
 @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Login with username "<name>" and password "<password>"
    Then "Login Successfully" message is displayed

    Examples: 
      | name                     | password   |
      | anandsharma379@gmail.com |@Sairam01@|
