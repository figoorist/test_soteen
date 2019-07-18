package ru.comp.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MarketHomePage {

    private SelenideElement searchInput = $("#header-search");
    private SelenideElement goSearchButton = $(byXpath("//*[@type='submit']"));

    public void Search(String text) {
        searchInput.sendKeys(text);
        goSearchButton.click();
    }



}
