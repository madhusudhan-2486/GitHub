package com.ANZ.AnzCalculator.pages;

import com.ANZ.AnzCalculator.config.SeleniumConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ANZ.AnzCalculator.utils.Utils.CONFIG;

@SuppressWarnings("all")
public abstract class BasePage {

    private SeleniumConfig seleniumConfig;
    public String email;

    BasePage(SeleniumConfig seleniumConfig) {
        this.seleniumConfig = seleniumConfig;
        PageFactory.initElements(this.seleniumConfig.getDriver(), this);
    }

    /**
     * Each page should have a URL set;
     */
    private String pageURL;

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    protected SeleniumConfig getSeliumConfig() {
        return seleniumConfig;
    }

    public void close() {
        seleniumConfig.getDriver().close();
    }

    public String getCurrentUrl() {
        return seleniumConfig.getDriver().getCurrentUrl();
    }

    void navigateTo(String url) {
        seleniumConfig.getDriver().navigate().to(CONFIG.getBaseUri() + url);
    }

    public void waitForUrlToContain(String url) {
        seleniumConfig.getWait().until(ExpectedConditions.urlContains(url));
    }

    public void waitForUrlToContain(String url, Integer seconds) {
        Wait wait = new WebDriverWait(seleniumConfig.getDriver(), seconds);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitForUrlToEndWith(String url) {
        seleniumConfig.getWait().until(ExpectedConditions.urlMatches(url + "$"));
    }

    //wait for the element to be visible
    void waitForElementToBeVisible(WebElement element) {
        seleniumConfig.getWait().until(ExpectedConditions.visibilityOf(element));
    }

    //wait for the element to be visible till specified time
    void waitForElementToBeVisible(WebElement element, Integer seconds) {
        Wait wait = new WebDriverWait(seleniumConfig.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //wait for particular time
    public void threadWait(int MilliSeconds) {
        try {
            Thread.sleep(MilliSeconds);
        } catch (Exception e) {
        }
    }

    //Refresh the page, when the data is not properly loaded
    public void RefreshPage() {
        seleniumConfig.RefreshPageWithDriver();
    }

}

