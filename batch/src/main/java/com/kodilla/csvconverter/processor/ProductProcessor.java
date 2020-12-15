package com.kodilla.csvconverter.processor;

import com.kodilla.csvconverter.domain.Product;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        return new Product(item.getId(), item.getQuantity(), (int)(item.getPrice()*1.1));
    }
}
