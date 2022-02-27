Feature: Login into salesforce application

  Scenario: Login with valid user and invalid password
    Given user on LoginPage
    When User enters "neeru@tekarch.com" into username field
    When User enters "123" into password field
    When Click on login button
    Then error is present with the text "Error"
    
    
   Scenario: Login with valid user and valid password
    Given user on LoginPage
    When User enters "neeru@tekarch.com" into username field
    When User enters "India@127" into password field
    When Click on login button
    Then verify page title as "Home Page ~ Salesforce - Developer Edition"
   
     