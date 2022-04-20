Feature: Login Functionality For WebOrder Page

  Background:
    Given the user navigates to the WebOrder website


  Scenario: Validation of WebOrder Login Positive Scenario
#    Given the user navigates to the WebOrder website
    When the user provides credentials
    Then the user is on the home page

  @negative
  Scenario Outline: Validation of WebOrder Login Negative Scenarios

    When the user provides wrong "<usernamefornegative>" and "<passwordfornegative>"
    Then the user validate the "<errormessage>" error message
    Examples:


      | usernamefornegative   | passwordfornegative | errormessage       |
      | ASEL                  | Guest1!             | Sign in Failed     |
      | guest1@microworks.com | BRAGIM1425          | Sign in Failed     |
      |                       |                     | Sign in Failed     |
      | guest1@microworks.Com | 11111111            | Sign in Failed     |
      | **2888                | 163768974H          | Sign in Failed     |
      | guest1@microworks.Com |                     | Sign in Failed     |
      |                       | Guest1!             | Sign in Failed     |
      |  ^&&*((               | ***************     | Sign in Failed     |
