Feature: Open MRS tests


  @openMRS
  Scenario: Register  a patient

    Given the user logs in to OpenMRS with following credentials
      | username | admin    |
      | password | Admin123 |


    When the user registers a new patient with following information:

    |GivenName|Kerim|
    |FamilyName|Bragim|
    |Gender|Female|
    |Day|13|
    |Month|November|
    |Year|1998|
    |Address|2200 E Devon ave|
    |PhoneNumber|4154160043|
    |Relative|Sibling|
    |RelativeName|Zhanara|



    Then the user validates the patient name and familyName

      |GivenName|Kerim|
      |FamilyName|Bragim|