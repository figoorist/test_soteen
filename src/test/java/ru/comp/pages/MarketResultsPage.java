package ru.comp.pages;

import com.codeborne.selenide.SelenideElement;
import ru.comp.utilities.Product;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MarketResultsPage {

    public void GoToProductPage(Product product) {
        GetProductBlock(product).scrollTo().$(byTitle(product.screenTitle())).click();
    }

    public SelenideElement GetProductBlock(Product product) {
        return $(byXpath("//div[@data-id and .//a[@title='" + product.screenTitle() + "']]"));
    }

    public int GetProductScreenPrice(Product product) {
        return Integer.parseInt(GetProductBlock(product).$(byXpath("//span[@class='price']")).text().replaceAll("[^\\d.]", ""));
    }
}
