package com.home.teste.pages;

import com.home.teste.configuration.TLDriverFactory;
import com.home.teste.model.Usuario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfiguracoesPage extends BasePage {

    @FindBy(xpath = ".//span[@class='profile-address']")
    private WebElement email;

    public ConfiguracoesPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void validarLogin(Usuario usuario) {
        String txtEmail = getText(email);
        Assert.assertEquals(txtEmail, usuario.getEmail());
    }

}
