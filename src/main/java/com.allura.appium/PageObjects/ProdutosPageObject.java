package com.allura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProdutosPageObject  extends PageObjectBase{

    private WebElement produtoBola;
    private WebElement botaoComprar;
    private final By produtoBolasId;
    private final By botaoComprarId;

    public ProdutosPageObject(AppiumDriver driver) {
        super(driver);
        produtoBolasId = By.id("br.com.alura.aluraesporte:id/item_produto_nome");
        botaoComprarId = By.id("br.com.alura.aluraesporte:id/detalhes_produto_botao_comprar");
    }

    @Override
    public void BuscarElementos() {
        produtoBola = driver.findElement(produtoBolasId);
        botaoComprar = driver.findElement(botaoComprarId);

    }

    public void AdicionarProdutoAoCarrinho(String item) {

        List<WebElement> items = driver.findElements(By.cssSelector("div[class='androidx.recyclerview.widget.RecyclerView']"));
        for (WebElement iten : items) {
            String itemNameString = iten.findElement(By.cssSelector("div[class='android.view.ViewGroup']")).getText();

            if (itemNameString.contains(item)) {
                iten.findElement(By.id("br.com.alura.aluraesporte:id/item_produto_nome")).click();
            }
        }
//        produtoBola.click();
//        botaoComprar.click();


    }
}
