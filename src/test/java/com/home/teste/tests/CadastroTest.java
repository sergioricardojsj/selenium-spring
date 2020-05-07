package com.home.teste.tests;

import com.home.teste.listeners.InvokedMethodListener;
import com.home.teste.model.Usuario;
import com.home.teste.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ InvokedMethodListener.class })
public class CadastroTest extends BaseTestCase {

    @Test
    public void realizarCadastro() {
        Usuario usuario = new Usuario();

        new LoginPage()
                .acessarTelaDeCadastro()
                .cadastrarUsuario(usuario)
                .validarLogin(usuario);
    }

    @Test
    public void realizarCadastroFaltandoCampos() {
        Usuario usuario = new Usuario();

        new LoginPage()
                .acessarTelaDeCadastro()
                .preencherCamposExcetoEmail(usuario)
                .validarMensagem();
    }

}
