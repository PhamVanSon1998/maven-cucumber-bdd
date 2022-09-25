@register_login
Feature: Register and Login
  I want to use this template for my feature file

  @tag1
  Scenario: Register to system and Login
    Given Open Home page
    When Click Register link
    And check to Gender Male
    And Input to firstName textbox
    And Input to LastName textbox
    And Select Date dropdown
    And Select Month dropdown
    And Select Year dropdown
    And Input to Email textbox
    And Input to CompanyName textbox
    And Input to Password textbox
    And Input to Confirm Password textbox
    And Click Register Button
    Then Verify Resgister Success
    And Click Logout link
    And Click Login link
    And Input to Email textbox in LoginPage
    And Input to Password textbox in LoginPage
    And Click to Login Button
    

