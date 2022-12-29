Feature: Group 4 Project

Background:
When user enters valid username and valid password
And user clicks on login button
Then user is successfully logged in
When user clicks on PIM option
And user clicks on EmployeeList option
When user enter valid employee id
And user clicks on search button
Then user clicks on an employee id

@testAider
Scenario: Adding work Experience in Qualifications

When user clicks on Qualifications field
And user clicks on Add button for Work Experience
Then checks Company textbox is displayed and user can enter values there
And checks Job Title textbox is displayed and user can enter values there
And checks FROM calendar is displayed and user can pick values from there

  @NubiaSkills
Scenario: Adding work Skills in Qualifications

  When user clicks on Qualifications field
  And user clicks on Add button for Skills
  Then checks Skills dropdown is displayed and user can select of skills there
  And checks Years of Experience textbox is displayed and user can enter values there
  And checks Comments textbox is displayed and user can enter values there
  Then user clicks on save changes
    Then user varifies saved values

