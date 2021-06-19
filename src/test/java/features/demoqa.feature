Feature: user performs actions on demoQA to demonstrate automation skill

  Background: user navigates to homepage
    Given a user navigates to given url

  @test
  Scenario Outline: user fills out basic form
    Given a user is on demoQA homepage and clicks on elements
    When user clicks on text box
    And user provides full name <fullName>, <Email>, <currentAddress> and <permanentAddress>
    Then user can click on submit
    Then I can check form has correct details as <fullName>, <Email>, <currentAddress> and <permanentAddress>

    Examples:
      | fullName | Email          | currentAddress     | permanentAddress   |
      | David    | david@demo.com | 26 brinkburn close | 26 brinkburn close |

  @test
  Scenario: student fills out registration form happy path
    Given student navigates to student registration form page
    And student provides first name, last name, email and Mobile
    And student selects gender
    And selects date of birth as day "1", month "January" and year "2000"
    And chooses subjects "maths" and "english"
    And selects hobbies
    And uploads a file
    And provides current address
    And selects states and city
    Then submits form
    And I can verify that a modal detailing form information is displayed
    Then I can close Modal

  @test
  Scenario: verify validation on required fields on student form
    Given student navigates to student registration form page
    And provides current address
    Then submits form
    Then user can verify validation is performed on required fields

  @test
  Scenario: test alert page
    Given a user navigates to alerts page
    And clicks button to see alert
    Then user can click ok button on alert
    And user clicks on button and waits five seconds for alert
    Then user can click ok button on alert
    And user clicks button and can dismiss alert box
    And user clicks button and can select ok button
    And user clicks on button and can type into prompt and select ok
    And user clicks on button and can press cancel on prompt

  @test
  Scenario: hover over tool tip and get text
    Given I navigate to toolTip page
    Then I can hover over button
    And I can hover over input field and get text

  @test
  Scenario: select one month from today in date picker
    Given I navigate to the date picker page
    When I click on select date field I can get the text

  @test
  Scenario: get text inside a frame
    Given I navigate to the frame page
    When I switch to frame then I can get text
    Then I navigate to the droppable page
    And I can drag and drop an element

