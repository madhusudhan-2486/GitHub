package com.ANZ.AnzCalculator.tests;

import com.ANZ.AnzCalculator.pages.CalculatorPage;
import com.ANZ.AnzCalculator.config.SeleniumConfig;
import org.junit.*;
import org.junit.rules.TestName;
import static com.ANZ.AnzCalculator.config.SeleniumConfig.setupDriver;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    private static CalculatorPage calculatorPage;
    private static SeleniumConfig seleniumConfig;

    /**
     * To take snapshot of the application when the test fails
     */
    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void setupSuite() {
        setupDriver();
        seleniumConfig = new SeleniumConfig();
        calculatorPage = new CalculatorPage(seleniumConfig);
    }

    /**
     * Setup and load the calculator page for each test
     */
    @Before
    public void setupTests() {
        calculatorPage.load();
    }

    /**
     * Tear down after each test.
     */
    @After
    public void tearDownTests() {}

    /**
     * Tear down after the test suite and close the browser.
     */
    @AfterClass
    public static void TearDownSuite(){
        calculatorPage.close();
    }

    /**
     * <p><b>Senario:</b> Verify the borrowing estimate when required fields are filled</p>
     * Given The user is on the calculator page<br>
     * When Single, 0 dependants, with income of 80,000,
     * other income 10,000, living expenses 500, current home loan repayments 0,
     * other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled<br>
     * And How much could I borrow button is clicked <br>
     * Then Estimated amount is displayed"
     */
    @Test
    public void GivenCalculatorPage_Calculate_EstimatedAmount() {
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
        calculatorPage.clickCalculateBorrowButton();
        calculatorPage.threadWait(5000);
        Assert.assertThat(calculatorPage.getBorrowAmountText(), is("$542,000"));
    }

    /**
     * <p><b>Scenario:</b> Verify Clicking the ‘start over’ button clears the form</p>
     * Given The user is on the calculator page<br>
     * When Single, 0 dependants, with income of 80,000,
     * other income 10,000, living expenses 500, current home loan repayments 0,
     * other loan repayments 100, other commitments 0 and total credit card limits 10,000 are filled<br>
     * And How much could I borrow button is clicked
     * And click the start over button<br>
     * Then Form is cleared and have default values"
     */
    @Test
    public void GivenCalculatorPage_ResetOver() {
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
        calculatorPage.clickCalculateBorrowButton();
        calculatorPage.threadWait(5000);
        Assert.assertThat(calculatorPage.getBorrowAmountText(), is("$542,000"));

        calculatorPage.clickStartOverResetButton();

        Assert.assertTrue(calculatorPage.getSingleAccountType());
        Assert.assertTrue(calculatorPage.getHomeToLiveProperty());
        Assert.assertThat(calculatorPage.getNumberOfDependents(), is("0"));
        Assert.assertThat(calculatorPage.getAnnualIncomeTextBox(), is ("0"));
        Assert.assertThat(calculatorPage.getOtherAnnualIncomeTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getLivingExpensesTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getOtherLoanTextBox(), is("0"));
        Assert.assertThat(calculatorPage.getTotalCreditLimitTextBox(), is("0"));
    }

    /**
     * <p><b>Scenario:</b> Verify the error message when other fields are empty and only living expenses is entered</p>
     * <br>Given The user is on the calculator page<br>
     * <br>When Living expenses is entered and remaining fields left empty<br>
     * <br>And How much could I borrow button is clicked<br>
     * <br>Then Error message is displayed<br>
     */
    @Test
    public void GivenCalculatorPage_ErrorMessage() {
        calculatorPage.threadWait(3000);
        calculatorPage.enterLivingExpensesTextBox("1");
        calculatorPage.clickCalculateBorrowButton();
        if(calculatorPage.getErrorMessageDisplayed())
            Assert.assertThat(calculatorPage.getErrorMessageText(),
                    is("Based on the details you've entered, we're unable to give " +
                            "you an estimate of your borrowing power with this calculator. " +
                            "For questions, call us on 1800 035 500."));
        else
            Assert.fail("Error Message is not displayed");
    }
}
