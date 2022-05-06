package com.ANZ.AnzCalculator.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String setDownloadPath = System.getProperty("user.dir")+"\\DownloadedFiles";

    public SeleniumConfig() {
        String isHeadless = System.getProperty("isHeadless");
        HashMap<String, Object> chromePref = new HashMap<>();
        chromePref.put("download.default_directory", setDownloadPath);
        ChromeOptions options = new ChromeOptions();
        if (isHeadless != null && isHeadless.equalsIgnoreCase("true")) {
            options.addArguments("headless");
            options.addArguments("disable-gpu");
            options.addArguments("window-size=1200,1100");
        }
        options.setExperimentalOption("prefs", chromePref);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void RefreshPageWithDriver() {
        driver.navigate().refresh();
    }
}