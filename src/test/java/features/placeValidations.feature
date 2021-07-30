Feature: Validations of Google PlaceAPI

  @AddPlace
  Scenario Outline: Verify if the place is added successfully using the google placeADDAPI
    Given Add a place payload With "<name>" "<Phone_number>" "<address>" "<language>"
    When user calls the "AddPlaceAPI" using "Post" http request
    Then verify the api got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify the place_id created maps to "<name>" from the "GetPlaceAPI" API

    Examples:
      | name    | Phone_number       | address                     | language |
      | Karthik | (+91) 983 678 9084 | d.r.c 118/A Hutha Colony    | Kannada  |
      | Karnal  | (+91) 983 678 9084 | #34 16th cross hudko Colony | Kanglish |

   @UpdatePlace
  Scenario Outline: Update the address using the place_id
    Given UpdatePlace request Payload with "<address>" "<key>"
    When user calls the "UpdatePlaceAPI" using "Put" http request
    Then verify the api got success with status code 200
    And "msg" in response body is "Address successfully updated"

    Examples:
      | address                     | key        |
      | 79, hutha colony, Bdvt 21   | qaclick123 |
      | #45 16th cross hudko Colony | qaclick123 |


  @DeletePlace
  Scenario: Delete the place APi and verify if it's working
    Given DeletePlace payload
    When user calls the "DeletePlaceAPI" using "Post" http request
    Then verify the api got success with status code 200
    And "status" in response body is "OK"