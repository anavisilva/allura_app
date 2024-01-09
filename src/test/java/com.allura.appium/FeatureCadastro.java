package com.allura.appium;

import com.allura.appium.PageObjects.CadastroPageObject;
import com.allura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.NoSuchElementException;



public class FeatureCadastro {
    @Test
    public void nao_consigo_cadastrar_usuario_com_senha_invalida() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "456");

        Assertions.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }
    
    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Bugan", "123", "123");
        telaLogin.BuscarElementos();
    }

    @Test
    public void nao_posso_cadastrar_duas_vezes_o_mesmo_usuario() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Bugan", "123", "123");

        telaLogin.BuscarElementos();
        telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "123");


        Assertions.assertEquals("Usuario já Cadastrado", telaCadastro.MensagemErro());
        driver.navigate().back();


    }
}
