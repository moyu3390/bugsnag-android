Feature: Reporting Error Context

Scenario: Context automatically set as most recent Activity name
    When I run "AutoContextScenario"
    Then I wait to receive an error
    And the error is valid for the error reporting API version "4.0" for the "Android Bugsnag Notifier" notifier
    And the exception "message" equals "AutoContextScenario"
    And the event "context" equals "SecondActivity"
