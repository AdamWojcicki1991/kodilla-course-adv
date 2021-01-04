package com.kodilla.events.domain;

public class ProductDto {
    private String productName;
    private String otherData;

    public ProductDto(String productName, String otherData) {
        this.productName = productName;
        this.otherData = otherData;
    }

    public String getProductName() {
        return productName;
    }

    public String getOtherData() {
        return otherData;
    }

}
