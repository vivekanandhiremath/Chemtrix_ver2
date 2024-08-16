package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {
    private static volatile WebdriverManager instance;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebdriverManager() {
    }

    public static WebdriverManager getInstance(String browser) {
        if (instance == null) {
            synchronized (WebdriverManager.class) {
                if (instance == null) {
                    instance = new WebdriverManager();
                }
            }
        }

        if (tlDriver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    public static void quitBrowser() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

    public void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;

            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("invalid browser" + browser);
        }
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }
}

