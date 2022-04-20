Feature: Login Functionality For WebOrder Page

  Background:
    Given the user navigates to the WebOrder website

  Scenario: Validation of WebOrder Login Positive Scenario
#    Given the user navigates to the WebOrder website
    When the user provides credentials
    Then the user is on the home page


  Scenario: Validation of WebOrder Login Negative Scenario1
#    Given the user navigates to the WebOrder website
    When the user provides correct username and wrong password
    Then the user validate the "Sign in Failed" error message



  Scenario: Validation of WebOrder Login Negative Scenario2
#    Given the user navigates to the WebOrder website
    When the user provides wrong "kerim" and "bragim"
    Then the user validate the "Sign in Failed" error message


@smoke @regression
  Scenario: Validation of WebOrder Login Negative Scenario3
#    Given the user navigates to the WebOrder website
    When the user provides empty "" and ""
    Then the user validate the "Sign in Failed" error message