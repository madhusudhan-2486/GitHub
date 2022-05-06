package com.ANZ.AnzCalculator.pages;

import com.ANZ.AnzCalculator.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {

    @FindBy(css = "h1 span[class=\"text--white\"]")
    private WebElement pageName;

    @FindBy(css = "li label[for=\"application_type_single\"]")
    private WebElement singleAccountType;

    @FindBy(css = "select[title=\"Number of dependants\"]")
    private WebElement numberOfDependents;

    @FindBy(css = "li label[for=\"borrow_type_home\"]")
    private WebElement homeToLiveProperty;

    //div.borrow__question:nth-child(2) div.input__wrapper input[aria-labelledby="q2q1"]
    @FindBy(css = "div.borrow__question:nth-child(2) div.input__wrapper input[aria-labelledby=\"q2q1\"]")
    private WebElement annualIncomeTextBox;

    @FindBy(css = "div.borrow__question:nth-child(3) div.input__wrapper input[aria-labelledby=\"q2q2\"]")
    private WebElement otherAnnualIncomeTextBox;

    @FindBy(css = "div[class=\"input__wrapper\"] input[id=\"expenses\"]")
    private WebElement livingExpensesTextBox;

    @FindBy(css = "div[class=\"input__wrapper\"] input[id=\"homeloans\"]")
    private WebElement currentHomeLoanTextBox;

    @FindBy(css = "div[class=\"input__wrapper\"] input[id=\"otherloans\"]")
    private WebElement otherLoanTextBox;

    @FindBy(css = "div[class=\"input__wrapper\"] input[aria-labelledby=\"q3q4\"]")
    private WebElement otherCommitmentTextBox;

    @FindBy(css = "div[class=\"input__wrapper\"] input[id=\"credit\"]")
    private WebElement totalCreditLimitTextBox;

    @FindBy(css = "button[class=\"btn btn--action btn--borrow__calculate\"]")
    private WebElement calculateBorrowButton;

    @FindBy(css = "span[class=\"borrow__result__text\"] span")
    private WebElement borrowAmountText;

    @FindBy(css = "button[class=\"start-over\"]")
    private WebElement startOverResetButton;

    @FindBy(css = "div[class=\"borrow__error__text\"]")
    private WebElement errorMessageText;

    public CalculatorPage(SeleniumConfig seleniumConfig) {
        super(seleniumConfig);
    }

    /**
    * Load the Calculator page
     * */
    public void load() {
        setPageURL("/personal/home-loans/calculators-tools/much-borrow/");
        navigateTo(getPageURL());
        waitForElementToBeVisible(pageName);
        String currentURL = getCurrentUrl();
    }

    /**
     * click Single Account Type button
     */
    public void clickSingleAccountType() {
        waitForElementToBeVisible(singleAccountType, 30);
        singleAccountType.click();
    }

    /**
     * @return the boolean value for Single Account Type selected
     */
    public Boolean getSingleAccountType() {
        waitForElementToBeVisible(singleAccountType, 30);
        WebElement elem = singleAccountType.findElement(By.cssSelector("input"));
        return elem.isSelected();
    }

    /**
     * Select the Number of Dependents
     * @param optionText String to enter the number of dependents
     */
    public void selectNumberOfDependents(String optionText) {
        //Select se = new Select(getSeliumConfig().getDriver().findElement(By.cssSelector("select[title=\"Number of dependants\"]")));
        //se.selectByValue(optionText);
        numberOfDependents.click();
        threadWait(500);
        numberOfDependents.sendKeys(optionText);
        numberOfDependents.sendKeys(Keys.ENTER);
        //String cssValue = "select[title=\"Number of dependants\"] :nth-child(1)";
    }

    /**
     * @return the selected value from the Number of dependents
     */
    public String getNumberOfDependents() {
        return numberOfDependents.getAttribute("value");
    }

    /**
     * Enter the Annual Income text box
     * @param amount String to enter Annual Income Tax
     */
    public void enterAnnualIncomeTextBox(String amount) {
        waitForElementToBeVisible(annualIncomeTextBox, 30);
        annualIncomeTextBox.sendKeys(amount);
    }

    /**
     * @return the value from Annual Income text box
     */
    public String getAnnualIncomeTextBox() {
        waitForElementToBeVisible(annualIncomeTextBox, 30);
        return annualIncomeTextBox.getAttribute("value");
    }

    /**
     * click Home to Live Type button
     */
    public void clickHomeToLiveProperty() {
        waitForElementToBeVisible(homeToLiveProperty, 30);
        homeToLiveProperty.click();
    }

    /**
     * @return the boolean value for Home to Live Property selected
     */
    public Boolean getHomeToLiveProperty() {
        waitForElementToBeVisible(homeToLiveProperty, 30);
        WebElement elem = homeToLiveProperty.findElement(By.cssSelector("input"));
        return elem.isSelected();
    }

    /**
     * Enter the Other Annual Income text box
     * @param amount String to enter Other Annual Income Tax
     */
    public void enterOtherAnnualIncomeTextBox(String amount) {
        waitForElementToBeVisible(otherAnnualIncomeTextBox, 30);
        otherAnnualIncomeTextBox.sendKeys(amount);
    }

    /**
     * @return the value from Other Annual Income text box
     */
    public String getOtherAnnualIncomeTextBox() {
        waitForElementToBeVisible(otherAnnualIncomeTextBox, 30);
        return otherAnnualIncomeTextBox.getAttribute("value");
    }

    /**
     * Enter the Living Expenses text box
     * @param amount String to enter Living Expenses
     */
    public void enterLivingExpensesTextBox(String amount) {
        waitForElementToBeVisible(livingExpensesTextBox, 30);
        livingExpensesTextBox.sendKeys(amount);
    }

    /**
     * @return the value from Living Expenses text box
     */
    public String getLivingExpensesTextBox() {
        waitForElementToBeVisible(livingExpensesTextBox, 30);
        return livingExpensesTextBox.getAttribute("value");
    }

    /**
     * Enter the Current Home Loan text box
     * @param amount String to enter Current Home Loan
     */
    public void enterCurrentHomeLoanTextBox(String amount) {
        waitForElementToBeVisible(currentHomeLoanTextBox, 30);
        currentHomeLoanTextBox.sendKeys(amount);
    }

    /**
     * Enter the Other Loan text box
     * @param amount String to enter Other Loan
     */
    public void enterOtherLoanTextBox(String amount) {
        waitForElementToBeVisible(otherLoanTextBox, 30);
        otherLoanTextBox.sendKeys(amount);
    }

    /**
     * @return the value from Other Loan text box
     */
    public String getOtherLoanTextBox() {
        waitForElementToBeVisible(otherLoanTextBox, 30);
        return otherLoanTextBox.getAttribute("value");
    }

    /**
     * Enter the Other Commitment text box
     * @param amount String to enter Other Commitment
     */
    public void enterOtherCommitmentTextBox(String amount) {
        waitForElementToBeVisible(otherCommitmentTextBox, 30);
        otherCommitmentTextBox.sendKeys(amount);
    }

    /**
     * Enter the Total Credit limit text box
     * @param amount String to enter Total Credit limit
     */
    public void enterTotalCreditLimitTextBox(String amount) {
        waitForElementToBeVisible(totalCreditLimitTextBox, 30);
        totalCreditLimitTextBox.sendKeys(amount);
    }

    /**
     * @return the value from Total Credit limit text box
     */
    public String getTotalCreditLimitTextBox() {
        waitForElementToBeVisible(totalCreditLimitTextBox, 30);
        return totalCreditLimitTextBox.getAttribute("value");
    }

    /**
     * click Borrow Calculate button
     */
    public void clickCalculateBorrowButton() {
        waitForElementToBeVisible(calculateBorrowButton, 30);
        calculateBorrowButton.click();
    }

    /**
     * @return the value from calculated borrow amount text
     */
    public String getBorrowAmountText() {
        waitForElementToBeVisible(borrowAmountText, 30);
        return borrowAmountText.getText();
    }

    /**
     * click Start Over Reset button
     */
    public void clickStartOverResetButton() {
        waitForElementToBeVisible(startOverResetButton, 30);
        startOverResetButton.click();
    }

    /**
     * @return the Error message text when insufficient data is entered
     */
    public String getErrorMessageText() {
        waitForElementToBeVisible(errorMessageText, 30);
        return errorMessageText.getText();
    }

    /**
     * @return the boolean for the Error message displayed when insufficient data is entered
     */
    public Boolean getErrorMessageDisplayed() {
        try{
            return errorMessageText.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
