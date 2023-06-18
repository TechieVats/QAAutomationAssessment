Feature: Test suite on adding user into web tables

  @AddUsersToUserListTable
  Scenario Outline: Add users to the User List Table
    Given user navigate to the base url
    Then  user validates that user landed on the user list table
    When  user clicks the add user button
    And   provide the details as "<FirstName>", "<LastName>", "<UserName>", "<Password>", "<Company>", "<Role>", "<Email>" and "<CellPhone>"
    Then  user validates the newly added "<UserName>" is added to the list

    Examples:
      | FirstName | LastName | UserName | Password | Company | Role     | Email              | CellPhone |
      | FName1    | LName1   | User1    | Pass1    | AAA     | Admin    | admin@gmail.com    | 082555    |
      | FName2    | LName2   | User2    | Pass2    | BBB     | Customer | customer@gmail.com | 083444    |
