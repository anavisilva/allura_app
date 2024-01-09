package com.allura.appium.PageObjects;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends PageObjectBase{

    private WebElement botaoCadastro;
    private WebElement botaoLogar;
    private WebElement campoNome;
    private WebElement campoSenha;

    private final By botaoCadastroId;
    private final By botaoLogarId;
    private final By campoNomeId;
    private final By campoSenhaId;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_usuario");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoLogarId = By.id("br.com.alura.aluraesporte:id/login_botao_logar");
        botaoCadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void BuscarElementos() {
        botaoCadastro = driver.findElement(botaoCadastroId);
        campoNome = driver.findElement(campoNomeId);
        campoSenha = driver.findElement(campoSenhaId);
        botaoLogar = driver.findElement(botaoLogarId);
    }

    public CadastroPageObject IrParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }

    public ProdutosPageObject Login (String usuario, String senha) {
        campoNome.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        botaoLogar = driver.findElement(botaoLogarId);
        botaoLogar.click();
        return new ProdutosPageObject(this.driver);
    }
}
