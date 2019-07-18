package ru.comp.utilities;

public enum Product {
    IPhone8gb64("Смартфон Apple iPhone 8 64GB"),
    IPhoneX("Смартфон Apple iPhone X 64GB");

    private String url;

    Product(String screenTitle) {
        this.url = screenTitle;
    }

    public String screenTitle() {
        return url;
    }
}
