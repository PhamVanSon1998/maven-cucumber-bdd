@datatable
Feature: DataTable Feature
  @datatable_step
  Scenario Outline: Create new Customer with email <username>
    #Given Open facebook application
    When Input to email and password 
    |username|password|
    |phanthuy123@gmail.com|281198|
 		|phanthuy124@gmail.com|281198|
 		|phanthuy125@gmail.com|281198|
 		|phanthuy126@gmail.com|281198|
    #|<username>|<password>|
    And Click to submit button 
    #And close applications
    
    Examples:
 		|username|password|
 		|phanthuy123@gmail.com|281198|
    
  @datatable_scenario
  Scenario Outline: Data Table in Scenario
    #Given Open facebook application
    When Input to email textbox with "<username>"
    And Input to password textbox with "<password>"
    And Click to submit button 
    #And close applications
    
    Examples:
 		|username|password|
 		|phanthuy123@gmail.com|281198|
 		|phanthuy124@gmail.com|281198|
 		|phanthuy125@gmail.com|281198|
 		|phanthuy126@gmail.com|281198|
 		|phanthuy127@gmail.com|281198|
    