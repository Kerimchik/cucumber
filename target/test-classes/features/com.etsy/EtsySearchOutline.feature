@special
Feature: Etsy Search Functionality


  Background: navigate
    Given the user navigates to "https://www.etsy.com/"

 @regressionOUTLINE
  Scenario Outline: Validation of etsy search Hat
#    Given the user navigates to "https://www.etsy.com/".        Scenario Outline:always comes with Examples:
    When the user searches with "<searchvalue>"
    Then the user validates the title "<titlevalidation>"
    Examples:

#    command+option+L ---> ORGANIZING NICELY

      | searchvalue | titlevalidation |
      | Hat         | Hat \| Etsy     |
      | Key         | Key \| Etsy     |
      | Pin         | Pin \| Etsy     |
      | bag         | notitle         |
      | flower      | flower          |