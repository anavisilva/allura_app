package com.allura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPageObject extends PageObjectBase{

    private WebElement campoNome;
    private WebElement campoSenha;
    private WebElement campoConfirmarSenha;
    private WebElement botaoCadastrar;

    private final By erroId;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By campoConfirmarSenhaId;
    private final By botaoCadastrarId;

    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void BuscarElementos() {
        campoNome = driver.findElement(campoNomeId);
        campoSenha = driver.findElement(campoSenhaId);
        campoConfirmarSenha = driver.findElement(campoConfirmarSenhaId);
        botaoCadastrar = driver.findElement(botaoCadastrarId);
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao) {
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        campoConfirmarSenha.sendKeys(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));
        WebElement mensagemErro = driver.findElement(erroId);
        return mensagemErro.getText();
    }
}
