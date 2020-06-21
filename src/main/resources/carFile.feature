Feature: As a user, I wish to be able to read a text file, detect and parse
  any registration numbers present and obtain information on the registered car from
  from https://cartaxcheck.co.uk/

  Scenario: a user inspects a text file containing several car registrations
    Given I have obtained a text file of car registrations
    When the file is parsed
    Then I can obtain the list of registrations

    When I check the make and model of the car
    Then the output is retrieved in the required format