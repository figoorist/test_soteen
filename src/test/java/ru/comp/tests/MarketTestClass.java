package ru.comp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.pages.MarketHomePage;
import ru.comp.pages.MarketProductPage;
import ru.comp.pages.MarketResultsPage;
import ru.comp.utilities.Product;

import static com.codeborne.selenide.Selenide.open;

public class MarketTestClass {

    private MarketHomePage marketHomePage;
    private MarketResultsPage marketResultsPage;
    private MarketProductPage marketProductPage;

    @BeforeClass
    public void initPageObjects() {
        marketHomePage = new MarketHomePage();
        marketResultsPage = new MarketResultsPage();
        marketProductPage = new MarketProductPage();
    }

    @Test
    @Parameters({"siteUrl", "searchQuery"})
    public void testMarketPrice(String siteUrl, String searchQuery, Product product) {
        open(siteUrl);
        marketHomePage.Search(searchQuery);
        int expectedPrice = marketResultsPage.GetProductScreenPrice(product);
        System.out.println(expectedPrice);

        marketResultsPage.GoToProductPage(Product.IPhone8gb64);
        int productPagePrice = marketProductPage.GetProductPrice();
        System.out.println(productPagePrice);
        Assert.assertEquals(expectedPrice, productPagePrice, "Prices are not equals");
    }
}
