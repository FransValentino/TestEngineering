Feature: Test Uji Coba Login
  Scenario Outline: Test Login Feature
    Given buka browser
    And user berada di halaman login
    When user input "<email>" dan "<password>"
    And user menekan tombol Login
    Then tampilkan page "<page>"
    Examples:
      | email | password | page |
      | example@email.com | password | Home |
      | example@email.com | Password1234 | Login |