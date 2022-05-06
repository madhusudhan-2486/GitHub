@Calculator
  Feature: Calculator Page Test

    Background:
      Given Calculator URL page is entered

      Scenario: Verify the borrowing estimate when required fields are filled
        When Single, 0 dependants, with income of 80,000, other income 10,000, living expenses 500, current home loan repayments 0, other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled
        And How much could I borrow button is clicked
        Then Estimated amount is displayed

      Scenario: Verify Clicking the ‘start over’ button clears the form
        When Single, 0 dependants, with income of 80,000, other income 10,000, living expenses 500, current home loan repayments 0, other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled
        And How much could I borrow button is clicked
        And click the start over button
        Then Form is cleared

      Scenario: Verify the error message when other fields are empty and only living expenses is entered
        When Living expenses is entered and remaining fields left empty
        And How much could I borrow button is clicked
        Then Error message is displayed
