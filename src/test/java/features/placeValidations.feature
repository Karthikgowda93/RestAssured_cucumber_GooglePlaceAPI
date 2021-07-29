Feature: Validations of Google PlaceAPI

  Scenario Outline: Verify if the place is added successfully using the google placeADDAPI
    Given Add a place payload With "<name>" "<Phone_number>" "<address>" "<language>"
    When user calls the "AddPlaceAPI" using Post http request
    Then verify the api got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name    | Phone_number       | address                  | language |
      | Karthik | (+91) 983 678 9084 | d.r.c 118/A Hutha Colony | Kannada  |