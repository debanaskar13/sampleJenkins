Feature: Checking Search Functionality of Google

  Scenario Outline: Verify whether Search Functionality is working or not
    Given user opens the browser
    When user enters url "https://www.google.com/"
    And user enters search data in inputbox '<data>'
    And user press enter
    Then Verify whether results are showing or not
    
    Examples:
    |data|
    |java|
