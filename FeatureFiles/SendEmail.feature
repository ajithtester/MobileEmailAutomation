Feature: To verify Compose email feature

  @RunTest
  Scenario: To compose an email and save in draft
    Given User opens the app
    And compose an email
    And save it as draft
    Then validate the draft

  @RunTest
  Scenario: To send the email from draft section
    Given User clicks profile
    And Opens the draft section from the menu
    And Selects the mail
    Then send the email

  @RunTest
  Scenario: To archive an email from the inbox
  Given User clicks profile
    And Selects inbox
    Then swipe to archive an email
