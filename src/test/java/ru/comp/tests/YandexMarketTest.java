package ru.comp.tests;

import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.pages.MarketHomePage;
import ru.comp.pages.MarketProductPage;
import ru.comp.pages.MarketResultsPage;
import ru.comp.utilities.Product;

import static com.codeborne.selenide.Selenide.open;

public class YandexMarketTest {

    private MarketHomePage marketHomePage;
    private MarketResultsPage marketResultsPage;
    private MarketProductPage marketProductPage;

    @BeforeClass
    @Parameters({"siteUrl"})
    public void initPageObjects(String siteUrl) {
        marketHomePage = new MarketHomePage();
        marketResultsPage = new MarketResultsPage();
        marketProductPage = new MarketProductPage();
        open(siteUrl);
    }

    @Test
    @Parameters({"searchQuery"})
    public void testIPhone8MarketPrice(String searchQuery) {

        marketHomePage.Search(searchQuery);
        int expectedPrice = marketResultsPage.GetProductScreenPrice(Product.IPhone8gb64);
        System.out.println(expectedPrice);

        marketResultsPage.GoToProductPage(Product.IPhone8gb64);
        int productPagePrice = marketProductPage.GetProductPrice();
        System.out.println(productPagePrice);
        Assert.assertEquals(productPagePrice, expectedPrice, "Prices are not equals");
    }

    @AfterClass
    @Parameters({"siteUrl"})
    public void tearDown(String siteUrl) {
        open(siteUrl);
    }
}
