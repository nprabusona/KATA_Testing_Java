Feature: Book a room

  @book
  Scenario: Option to book a room is available on the page
    Given I am on the home page
    When I browse through the page
    Then I have the option to book a room

  @book
  Scenario: Calendar option to book dates is available on the page
    Given I have the option to book a room
    When I click the book button
    Then I have the calendar option to select the dates

  @book
  Scenario: Booking the room for two days
    Given I have the calendar option to select the dates
    And I select two available dates on the calendar
    And I fill in the customer details
      | FirstName | LastName  | Email                | Phone        |
      | Prabu     | Nallavedi | nprabusona@gmail.com | 919191919191 |
    When I submit the booking
    Then I get the booking successful message with the dates booked
