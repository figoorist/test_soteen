package ru.comp.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byXpath;

public class MarketProductPage {

    private SelenideElement productScreenPrice = $$(byXpath("//span[@class='price']")).first();

    public int GetProductPrice() {
        return Integer.parseInt(productScreenPrice.text());
    }
}
