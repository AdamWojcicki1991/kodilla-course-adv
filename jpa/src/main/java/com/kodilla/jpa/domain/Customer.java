package com.kodilla.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String addresLineOne;
    private String addresLineTwo;

    public Customer() {
    }

    public Customer(Long id, String name, String addresLineOne, String addresLineTwo) {
        this.id = id;
        this.name = name;
        this.addresLineOne = addresLineOne;
        this.addresLineTwo = addresLineTwo;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddresLineOne() {
        return addresLineOne;
    }

    public String getAddresLineTwo() {
        return addresLineTwo;
    }
}
