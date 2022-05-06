package com.ANZ.AnzCalculator.stepDefinition;

import com.ANZ.AnzCalculator.pages.CalculatorPage;
import com.ANZ.AnzCalculator.run.RunnerTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.junit.rules.TestName;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorStepdefs {
    private static CalculatorPage calculatorPage;
    //private static SeleniumConfig seleniumConfig;

    /**
     * To take snapshot of the application when the test fails
     */
    @Rule
    public TestName name = new TestName();


    /**
     * Setup and load the calculator page for each test
     */
//    @Before
//    public void setupTests() {
//        calculatorPage.load();
//    }

    /**
     * Tear down after each test.
     */
    @After
    public void tearDownTests() {}

//    /**
//     * Tear down after the test suite and close the browser.
//     */
//    @AfterClass
//    public static void TearDownSuite(){
//        //calculatorPage.close();
//    }

    @Given("^Calculator URL page is entered$")
    public void openCalculatorPage() {
        calculatorPage = new CalculatorPage(RunnerTest.seleniumConfig);
        calculatorPage.load();
    }


    @When("^Single, 0 dependants, with income of 80,000, other income 10,000, living expenses 500, current home loan repayments 0, other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled$")
    public void enterValueForFields() {
        calculatorPage.clickSingleAccountType();
        calculatorPage.selectNumberOfDependents("0");
        calculatorPage.threadWait(3000);
        calculatorPage.enterAnnualIncomeTextBox("80000");
        calculatorPage.threadWait(3000);
        calculatorPage.enterOtherAnnualIncomeTextBox("10000");
        calculatorPage.enterLivingExpensesTextBox("500");
        calculatorPage.enterCurrentHomeLoanTextBox("0");
        calculatorPage.enterOtherLoanTextBox("100");
        calculatorPage.enterOtherCommitmentTextBox("0");
        calculatorPage.enterTotalCreditLimitTextBox("10000");
    }

    @And("^How much could I borrow button is clicked$")
    public void clickBarrowCalculateButton() {
        calculatorPage.clickCalculateBorrowButton();
        calculatorPage.threadWait(5000);
    }

    @Then("^Estimated amount is displayed$")
    public void verifyEstimatedAmount() {
        calculatorPage.threadWait(5000);
        Assert.assertThat(calculatorPage.getBorrowAmountText(), is("$542,000"));
    }

    @And("^click the start over button$")
    public void clickStartOverButton() {
        calculatorPage.clickStartOverResetButton();
    }

    @Then("^Form is cleared$")
    public void verifyFormCleared() {
        Assert.assertTrue(calculatorPage.getSingleAccountType());
        Assert.assertTrue(calculatorPage.getHomeToLiveProperty());
        Assert.assertThat(calculatorPage.getNumberOfDependents(), is("0"));
        Assert.assertThat(calculatorPage.getAnnualIncomeTextBox(), is ("0"));
        Assert.assertThat(calculatorPage.getOtherAnnualIncomeTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getLivingExpensesTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getOtherLoanTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getTotalCreditLimitTextBox(), is("0"));
    }

    @When("^Living expenses is entered and remaining fields left empty$")
    public void enterLivingExpenses() {
        calculatorPage.threadWait(3000);
        calculatorPage.enterLivingExpensesTextBox("1");
    }

    @Then("^Error message is displayed$")
    public void verifyErrorMessage() {
        if(calculatorPage.getErrorMessageDisplayed())
            Assert.assertThat(calculatorPage.getErrorMessageText(),
                is("Based on the details you've entered, we're unable to give you an " +
                        "estimate of your borrowing power with this calculator. " +
                        "For questions, call us on 1800 035 500."));
        else
            Assert.fail("Error Message is not displayed");
    }
}
