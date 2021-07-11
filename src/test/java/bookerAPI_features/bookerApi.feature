Feature: Validating booker API

  Scenario: verify a booking can be created successfully
    When user calls "createBookingAPI" with Post http request
    Then user receives a successful response and a booking ID is generated