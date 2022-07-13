Feature: To verify Compose email feature

  @RunTest
  Scenario: To compose an email and save in draft
    Given User opens the app
    And Compose an email
    Then Save it as draft


  @RunTest
  Scenario: To send the email from draft section
    Given User clicks profile
    And Opens the draft section from the menu
    And Selects the mail
    Then Send the email

  @RunTest
  Scenario: To archive an email from the inbox
  Given User clicks profile
    And Clicks inbox
    Then Swipe to archive an email
