package com.home.teste.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TLDriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    private static final OptionsManager optionsManager = OptionsManager.getInstance();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void setDriver(String browserName) {
        if (browserName.equalsIgnoreCase("CHROME")) {
            WebDriver driver = new ChromeDriver(optionsManager.getChromeOptions());
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            tlDriver.set(driver);
        }
    }

    public static void endDriver() {
        tlDriver.get().quit();
    }

}
