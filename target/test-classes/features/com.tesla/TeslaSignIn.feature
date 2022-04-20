Feature: Testing Tesla SignUp Functionality and validation of title

  Background: navigate to the website


  @tesla  @tc1
  Scenario: Validation of Tesla Charging Department's title
    When the user clicks Shop button and clicks Charging
    Then  validate that the user is on the right page where title is "Tesla | Charging"









  @tesla  @tc1
  Scenario: Tesla SignUp with valid credentials
    When the user clicks on shop, and clicks on menu, and the sign in buttons
    Then  the user enters its "kerima.ibragimova@gmail.com" and "Debil1998"




  @tesla  @tc2
  Scenario: Tesla SignUp with wrong email
    When the user clicks on shop, and clicks on menu, and the sign in buttons
    And  the user enters its wrong email "kerina.@gma.com"
    Then validate the message "Please enter valid email address"


