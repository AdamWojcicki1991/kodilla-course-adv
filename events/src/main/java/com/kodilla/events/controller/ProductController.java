package com.kodilla.events.controller;

import com.kodilla.events.domain.ProductDto;
import com.kodilla.events.event.ProductRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @PostMapping(path = "/createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Register product: " + productDto.getProductName());
        publisher.publishEvent(
                new ProductRegisteredEvent(
                        this,
                        productDto.getProductName(),
                        productDto.getOtherData()));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
