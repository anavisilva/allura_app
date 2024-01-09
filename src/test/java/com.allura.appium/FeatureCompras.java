package com.allura.appium;

import com.allura.appium.PageObjects.LoginPageObject;
import com.allura.appium.PageObjects.ProdutosPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;

import static com.allura.appium.AppiumDriverConfig.*;

public class FeatureCompras {
    @Test
    public void  posso_realizar_compra() {
        AppiumDriver driver = Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        ProdutosPageObject telaCompras = telaLogin.Login("Bugan", "123");
        telaCompras.AdicionarProdutoAoCarrinho("Bola de futebol");

    }

}
