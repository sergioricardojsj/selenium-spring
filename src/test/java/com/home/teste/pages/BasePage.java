package com.home.teste.pages;

import com.home.teste.configuration.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;

    public void click(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(" + element.getLocation().y + ", 255)");
            element.click();
        } catch (NoSuchElementException e) {
            Log.logErro("Elemento não encontrado: " + e.getMessage());
            Assert.fail();
        }
    }

    public void preencherCampo(WebElement element, String keys) {
        try {
            element.sendKeys(keys);
        } catch (NoSuchElementException e) {
            Log.logErro("Elemento não encontrado: " + e.getMessage());
            Assert.fail();
        }
    }

    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            Log.logErro("Elemento não encontrado: " + e.getMessage());
            Assert.fail();
            throw new NoSuchElementException(e.getMessage());
        }
    }

}
