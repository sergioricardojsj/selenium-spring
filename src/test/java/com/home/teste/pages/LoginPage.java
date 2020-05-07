package com.home.teste.pages;

import com.home.teste.Mensagem;
import com.home.teste.configuration.Log;
import com.home.teste.configuration.TLDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "login_email")
    private WebElement campoEmail;

    @FindBy(id = "login_password")
    private WebElement campoSenha;

    @FindBy(xpath = ".//button[text()='Login']")
    private WebElement botaoLogin;

    @FindBy(xpath = ".//div[contains(@class, 'alert-login')]/child::div")
    private WebElement mensagem;

    @FindBy(xpath = ".//a[@href='/register']")
    private WebElement cliqueAqui;

    public LoginPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    private void efetuarLogin(String user, String pass) {
        Log.logInfo("Efetuando login para o usuário " + user + "...");
        preencherCampo(campoEmail, user);
        preencherCampo(campoSenha, pass);
        click(botaoLogin);
    }

    public LoginPage efetuarLogin() {
        efetuarLogin("usuario", "senha");
        return this;
    }

    public BasePage validarFalha() {
        Log.logInfo("Validando presença da mensagem de falha: [" + Mensagem.EMAIL_INCORRETO_OU_AUSENTE + "]");
        String msg = getText(mensagem);
        Assert.assertEquals(msg, Mensagem.EMAIL_INCORRETO_OU_AUSENTE);

        return this;
    }

    public CadastroPage acessarTelaDeCadastro() {
        click(cliqueAqui);
        return new CadastroPage();
    }

}
