Feature: Validations of Google PlaceAPI

  Scenario: Verify if the place is added successfully using the google placeADDAPI
    Given Add a place payload
    When user calls the "AddPlaceAPI" using Post http request
    Then verify the api got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
