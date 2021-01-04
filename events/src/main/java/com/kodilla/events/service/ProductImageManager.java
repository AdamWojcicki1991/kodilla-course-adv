package com.kodilla.events.service;

import com.kodilla.events.event.ProductRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductImageManager implements ApplicationListener<ProductRegisteredEvent> {

    @Override
    public void onApplicationEvent(ProductRegisteredEvent event) {
        System.out.println("Processing image of " + event.getProductName());
        System.out.println("The graphics is: " + event.getOtherData());
    }

//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//        System.out.println(event);
//    }
}
