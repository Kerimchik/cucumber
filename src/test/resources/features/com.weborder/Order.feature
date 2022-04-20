Feature: WebOrder Page Food Order
Background:
  Given the user is on weborder homepage
  When the user selects "Office"
  And the user is on the groupOrderPage
  And the user sends ivitees notes "Test"
  And the user sents invite list "kirabragim@gmail.com" and "kerima.ibragimova@gmail.com"

  Scenario: Validation  Of Food Frder For Office

#   Given the user is on weborder homepage
#    When the user selects "Office"
#    And the user is on the groupOrderPage
#    And the user sends ivitees notes "Test"
#    And the user sents invite list "kirabragim@gmail.com" and "kerima.ibragimova@gmail.com"
    Then the user validates the "2012 EMPIRE BLVD" address
    * the user validate "View Group Order" text
    * the user validates total participants is 1




  Scenario: Validation  Of Food Frder For My House

#    Given the user is on weborder homepage
#    When the user selects "Office"
#    And the user is on the groupOrderPage
#    And the user sends ivitees notes "Test"
#    And the user sents invite list "kirabragim@gmail.com" and "kerima.ibragimova@gmail.com"
    And the user selects "My House"
    Then the user validates the "2112 EMPIRE BLVD" address
    * the user validate "View Group Order" text
    * the user validates total participants is 1