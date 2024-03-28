Feature: Default


  Background: For all the scenarios user is on the login page of application Trycloud
    Given Users Log to the application Trycloud

  @B32G24-213 @positive
  Scenario:  Users can login with valid credentials by clicking on the "Login" button.
    Then  user logged in with a valid credentials
      | username | Employee61  |
      | password | Employee123 |
    Then user click on the login button
    And the user is redirected to the dashboard page
