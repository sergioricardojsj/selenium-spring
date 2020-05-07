package com.home.teste.configuration;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class OptionsManager {

    private static OptionsManager optionsManager;

    private OptionsManager() {

    }

    public static synchronized OptionsManager getInstance() {
        if (optionsManager == null) {
            synchronized (OptionsManager.class) {
                if (optionsManager == null) {
                    optionsManager = new OptionsManager();
                }
            }
        }
        return optionsManager;
    }

    public ChromeOptions getChromeOptions() {
        File file = new File("src/test/resources");

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath() + "/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }

}
