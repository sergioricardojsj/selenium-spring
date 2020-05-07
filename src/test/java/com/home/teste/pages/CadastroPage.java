package com.home.teste.pages;

import com.home.teste.Mensagem;
import com.home.teste.configuration.Log;
import com.home.teste.configuration.TLDriverFactory;
import com.home.teste.model.Usuario;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage extends BasePage {

    @FindBy(id = "register_name")
    private WebElement campoNome;

    @FindBy(id = "register_email")
    private WebElement campoEmail;

    @FindBy(id = "register_password")
    private WebElement campoSenha;

    @FindBy(xpath = ".//button[contains(text(), 'Cadastrar')]")
    private WebElement botaoCadastrar;

    @FindBy(xpath = ".//div[@class='panel-body']")
    private WebElement mensagem;

    public CadastroPage() {
        driver = TLDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ConfiguracoesPage cadastrarUsuario(Usuario usuario) {
        Log.logInfo("Iniciando o cadastro do usuário " + usuario.toString());
        preencherCampo(campoNome, usuario.getNome());
        preencherCampo(campoEmail, usuario.getEmail());
        preencherCampo(campoSenha, usuario.getSenha());
        click(botaoCadastrar);

        return new ConfiguracoesPage();
    }

    public CadastroPage preencherCamposExcetoEmail(Usuario usuario) {
        Log.logInfo("Iniciando o cadastro do usuário " + usuario.toString());
        preencherCampo(campoNome, usuario.getNome());
        preencherCampo(campoSenha, usuario.getSenha());
        click(botaoCadastrar);

        return this;
    }

    public void validarMensagem() {
        String txtEmail = getText(mensagem);
        Assert.assertThat(txtEmail, CoreMatchers.containsString(Mensagem.EMAIL_OBRIGATORIO));
    }

}
