package com.home.teste.tests;

import com.home.teste.TesteApplicationTests;
import com.home.teste.configuration.Config;
import com.home.teste.configuration.Log;
import com.home.teste.configuration.TLDriverFactory;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.BeforeClass;

@Configuration
@SpringBootTest
public class BaseTestCase {

    private WebDriver driver;

    @BeforeClass
    public void get() {
        SpringApplication.run(TesteApplicationTests.class);
        TLDriverFactory.setDriver("CHROME");
        driver = TLDriverFactory.getDriver();

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void end() {
        WebDriver driver = TLDriverFactory.getDriver();

        if (driver != null) {
            TLDriverFactory.endDriver();
        }

        Log.logInfo("---------------------- FINISHED ----------------------");
    }

    

}
