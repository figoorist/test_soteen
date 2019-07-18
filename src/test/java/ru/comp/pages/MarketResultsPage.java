package ru.comp.pages;

import ru.comp.utilities.Product;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MarketResultsPage {

    public void GoToProductPage(Product product) {
        $(byXpath("//div[@data-id and .//a[@title='" + product.screenTitle() + "']]//*[@title='" + product.screenTitle() + "']")).click();
    }

    public int GetProductScreenPrice(Product product) {
        return Integer.parseInt($(byXpath("//div[@data-id and .//a[@title='" + product.screenTitle() + "']]//div[@class='price']")).text().replaceAll("[^\\d.]", ""));
    }
}
