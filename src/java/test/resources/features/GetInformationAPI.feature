#language: en

Feature: Get json information

  Scenario: Get the information
    Given I send the url request
    And I get succesful status
    And I get the following json in the response:
    """
        {
          "userId": 1,
          "id": 1,
          "title": "delectus aut autem",
          "completed": false
        }
        """