@register_login_Dynamic
Feature: Register and Login
  I want to use this template for my feature file

  @tag1
  Scenario Outline:
: Register to system and Login with Dynamic Locator
    Given Open Home page
    When Click "ico-register" link 
    And check to "gender-male" checkbox 
    And Input to "FirstName" textbox with value "<FirstName>"
    And Input to "LastName" textbox with value "<LastnName>"
    And Select "DateOfBirthDay" dropdown with value "<Date>"
    And Select "DateOfBirthMonth" dropdown with value "<Month>"
    And Select "DateOfBirthYear" dropdown with value "<Year>"
    And Input to "Email" textbox with value "<Email>"
    And Input to "Company" textbox with value "<ComanyName>"
    And Input to "Password" textbox with value "<Password>"
    And Input to "ConfirmPassword" textbox with value "<Password>"
    And Click to "button-1 register-next-step-button" button 
    Then Verify Resgister Success with Dynamic locator
    When Click "ico-logout" link
    And Click "ico-login" link 
    And Input to "Email" textbox in LoginPage with value "<Email>"
    And Input to "Password" textbox in LoginPage with value "<Password>"
    And Click to "button-1 login-button" button 
    
    Examples:
| FirstName | LastnName | Date | Month    | Year | Email                | ComanyName | Password | 
| Phan      | Thuy      | 28   | November | 1998 | Phanthuy04@gmail.com | Sonpham    | 123456   |
