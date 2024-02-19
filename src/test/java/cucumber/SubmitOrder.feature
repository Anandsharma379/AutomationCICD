
  @tag1
  Feature:Purchase the order from Ecommerce Website
  I want to use this template for my feature file 
  
  Background:
  Given I landed on Ecommerce page
  
  @Regression
  Scenario Outline: Positive Test of Submitting the order
  
    Given Login with username "<name>" and password "<password>"
    When I add product "<productname>" to Cart
    And Checkout "<productname>" and submit the order
    Then "THANKYOU FOR THE ORDER" message is displayed on confirmation page

    Examples: 
      | name                     | password | productname|
      | anandsharma379@gmail.com |@Sairam01@| ZARA COAT 3|
   
