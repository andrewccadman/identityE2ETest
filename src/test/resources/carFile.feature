Feature: As a user, I wish to be able to read a text file, detect and parse
  any registration numbers present and obtain information on the registered car from
  from https://cartaxcheck.co.uk/

  Scenario Outline: a user inspects a text file containing several car registrations
    Given I have obtained a text file of car registrations <fileName>
    When the <fileName> file is parsed
    Then I can obtain the list of registrations <Registrations>

    Examples:
      | fileName      | Registrations                   |
      | car_input.txt | DN09HRM,BW57BOW,KT17DLX,SG18HTN |


  Scenario Outline: a user submits the car registration number to the car tax check web site
    When I check the make and model of the car using the <registrationNumber> registration number
    Then the information for the <registrationNumber>, <Make>, <Model>, <Colour> and <Year> are as expected

  Examples:
    | registrationNumber | Make       | Model                     | Colour | Year |
    | DN09HRM            | BMW        | 320D Se                   | Black  | 2009 |
#    fails due to incorrect registration number
    | BW57BOW            | Toyota     | Yaris T2                  | Black  | 2010 |
    | KT17DLX            | Skoda      | Superb Sportline Tdi S-A  | White  | 2017 |
    | SG18HTN            | Volkswagen | Golf Se Navigation Tsi Evo | White  | 2018 |



