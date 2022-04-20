Feature: Testing Amazon SignUp Functionality

  Background: navigate


    @amazon
    Scenario: Amazon SignUp with DataBase
      When the user clicks the sign in and create your amazon account button
      Then the user validate the header


      |Create account|

      And the user provides the information:
      |aikerim|
      |kerima@gmail.com       |
      |aikerim123|
      |aikerim123|