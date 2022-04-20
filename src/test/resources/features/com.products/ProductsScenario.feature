Feature: Validation of Products


  @productproject
  Scenario: Validation Of New Product Creation

    Given The user navigates to the products website homepage and click orderButton
    When The user enters the product information "MyMoney" and "4"
    And The user enters the address information "Techtorial", "2200 E Devon","Des Plaines", "Illinois","60018"
    And the user enters the card information "Visa","1234890966664444", "08/26"
    Then the user validates the success message
    And the user validates product details  "Techtorial", "MyMoney","4", "2200 E Devon","Des Plaines", "Illinois","60018", "Visa","1234890966664444", "08/26"


  @productprojectOutline
  Scenario Outline: Validation Of New Product Creation 1

    Given The user navigates to the products website homepage and click orderButton
    When The user enters the product information "<productName>" and "<quantity>"
    And The user enters the address information "<customerName>", "<street>","<city>", "<state>","<zipcode>"
    And the user enters the card information "<cardType>","<cardNumber>", "<expireDate>"
    Then the user validates the success message
    And the user validates product details  "<customerName>", "<productName>","<quantity>", "<street>","<city>", "<state>","<zip>", "<cardType>","<cardNumber>", "<expireDate>"

    Examples:

      | productName | quantity | customerName | street             | city        | state    | zipcode | cardType         | cardNumber       | expireDate |

      | MyMoney     | 4       | Techtorial   | 2200 E Devon       | Des Plaines | Illinois | 60018   | Visa             | 1234890966664444 | 08/26      |
      | FamilyAlbum | 6        | venom        | 5153 michcigan     | Vegas       | Nevada   | 95125   | MasterCard       | 164628384        | 09/24      |
      | ScreenSaver | 9        | malika       | 4142 N Keystone Dr | Orlando     | Florida  | 34535   | American Express | 43747436438438   | 01/29      |
