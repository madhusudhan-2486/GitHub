$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Calculator.feature");
formatter.feature({
  "line": 2,
  "name": "Calculator Page Test",
  "description": "",
  "id": "calculator-page-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Calculator"
    }
  ]
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Calculator URL page is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "CalculatorStepdefs.openCalculatorPage()"
});
formatter.result({
  "duration": 8920262500,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Verify the borrowing estimate when required fields are filled",
  "description": "",
  "id": "calculator-page-test;verify-the-borrowing-estimate-when-required-fields-are-filled",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Single, 0 dependants, with income of 80,000, other income 10,000, living expenses 500, current home loan repayments 0, other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "How much could I borrow button is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Estimated amount is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CalculatorStepdefs.enterValueForFields()"
});
formatter.result({
  "duration": 8583386900,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.clickBarrowCalculateButton()"
});
formatter.result({
  "duration": 5237209000,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.verifyEstimatedAmount()"
});
formatter.result({
  "duration": 5146311700,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Calculator URL page is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "CalculatorStepdefs.openCalculatorPage()"
});
formatter.result({
  "duration": 2795970600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify Clicking the ‘start over’ button clears the form",
  "description": "",
  "id": "calculator-page-test;verify-clicking-the-‘start-over’-button-clears-the-form",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "Single, 0 dependants, with income of 80,000, other income 10,000, living expenses 500, current home loan repayments 0, other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "How much could I borrow button is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "click the start over button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Form is cleared",
  "keyword": "Then "
});
formatter.match({
  "location": "CalculatorStepdefs.enterValueForFields()"
});
formatter.result({
  "duration": 8612439400,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.clickBarrowCalculateButton()"
});
formatter.result({
  "duration": 5215048300,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.clickStartOverButton()"
});
formatter.result({
  "duration": 157841300,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.verifyFormCleared()"
});
formatter.result({
  "duration": 857196600,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Calculator URL page is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "CalculatorStepdefs.openCalculatorPage()"
});
formatter.result({
  "duration": 2001244700,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verify the error message when other fields are empty and only living expenses is entered",
  "description": "",
  "id": "calculator-page-test;verify-the-error-message-when-other-fields-are-empty-and-only-living-expenses-is-entered",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Living expenses is entered and remaining fields left empty",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "How much could I borrow button is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Error message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CalculatorStepdefs.enterLivingExpenses()"
});
formatter.result({
  "duration": 3185817900,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.clickBarrowCalculateButton()"
});
formatter.result({
  "duration": 5199067700,
  "status": "passed"
});
formatter.match({
  "location": "CalculatorStepdefs.verifyErrorMessage()"
});
formatter.result({
  "duration": 160419500,
  "status": "passed"
});
});