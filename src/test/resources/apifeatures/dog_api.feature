@DOG_API
Feature: Test suite to verify the functionalities of dog apis

  Scenario: To verify that retriever breed is present within the dog breeds list
    Given the Dog API base URI is set
    When user access the dog api "/breeds/list/all"
    Then the response status code should be 200
    And the response should contain the "retriever" breed in the list of dog breeds

  Scenario: Successful retrieval of sub-breeds for Retriever
    Given the Dog API base URI is set
    When user request to retrieve the list of sub-breeds for "/breed/retriever/list"
    Then the response status code should be 200
    And the response should contain sub-breeds for retriever


  Scenario: Retrieving a random image/link for the sub-breed "golden"
    Given the Dog API base URI is set
    When user request to retrieve the list of random images "/breed/retriever/golden/images/random"
    Then the response status code should be 200
    And the response body should contain a valid image URL

