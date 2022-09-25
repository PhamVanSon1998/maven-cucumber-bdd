@paramater
Feature: Paramater Feature
  @no_param
  Scenario: Scenario have no parameter
    #Given Open facebook application
    When Input to email textbox
    And Input to password textbox 
    And Click to submit button 
    #And close applications
    
  @param_mark
  Scenario: Scenario have parameter
    #Given Open facebook application
    When Input to email textbox with "phanthuy@gmail.com"
    And Input to password textbox with "281198"
    And Click to submit button 
    #And close applications
    
  @multiple_param
  Scenario: Scenario have multiple parameter
    #Given Open facebook application
    When Input to email textbox with "phanthuy@gmail.com" and password with "281198"
    And Click to submit button 
    #And close applications
    
  