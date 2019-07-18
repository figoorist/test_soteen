package ru.comp.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MarketProductPage {

    private SelenideElement productScreenPrice = $$(byXpath("//span[@class='price']")).first();

    public int GetProductPrice() {
        return Integer.parseInt(productScreenPrice.text().replaceAll("[^\\d.]", ""));
    }
}
